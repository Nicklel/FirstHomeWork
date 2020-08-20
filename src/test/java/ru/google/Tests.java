package ru.google;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Tests extends WebDriverSettings {


    @Test
    @Description(value = "Поиск в гугле по слову Гладиолус. Результатов больше трех. Есть ссылка Гладиолус — Википедия. PageObject")
    public void firstTaskPO(){
        chromeDriver.get("https://www.google.ru");
        PageObjectGoogle firstPO = new PageObjectGoogle(chromeDriver);
        firstPO.find("Гладиолус");
        firstPO.refreshListOfElement();
        Steps.checkResultAmount(firstPO, chromeDriver);
        Steps.checkWikiLink(firstPO, chromeDriver);
    }

    @Test
    @Description(value = "Поиск в гугле по слову Гладиолус. Результатов больше трех. PageFactory")
    public void firstTaskPF(){
        chromeDriver.get("https://www.google.ru");
        PageFactoryGoogle firstPF = PageFactory.initElements(chromeDriver,PageFactoryGoogle.class);
        firstPF.find("гладиолус");
        Assertions.assertTrue(firstPF.getSearchResult().size()>3);
    }

    @Test
    @Description(value = "Поиск в гугле по слову Гладиолус. Есть ссылка Гладиолус — Википедия. PageFactory")
    public void secondTaskPF(){
        chromeDriver.get("https://www.google.ru");
        PageFactoryGoogle secondPF = PageFactory.initElements(chromeDriver,PageFactoryGoogle.class);
        secondPF.find("гладиолус");
        Assertions.assertTrue(secondPF.getSearchResult().stream().anyMatch(x->x.getText().contains("Гладиолус — Википедия")));
    }


    @Test
    @Description(value = "Фильтрация в Яндекс Маркете по Айфонам. В результате есть только айфоны")
    public void YandexMarketTestWithSteps() throws InterruptedException {
        chromeDriver.get("https://market.yandex.ru/");

        PageObjectYandexMarketMain yandexMarketPO = new PageObjectYandexMarketMain(chromeDriver);
        Steps.findIphone(yandexMarketPO, chromeDriver);

        PageObjectYandexMarketPhones yandexMarketPhonesPO = new PageObjectYandexMarketPhones(chromeDriver);
        Steps.checkPhones(yandexMarketPhonesPO, chromeDriver);
    }

}
