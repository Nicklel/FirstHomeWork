package ru.google;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Steps {

    @Step("Шаг 1. Проверка что результатов поиска больше 3")
    public static void checkResultAmount(PageObjectGoogle firstPO, WebDriver driver) {
        if (firstPO.getSearchResult().size()>3) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Результатов меньше трех");
        }
    }

    @Step("Шаг 2. Проверка что есть ссылка Гладиолус — Википедия")
    public static void checkWikiLink(PageObjectGoogle firstPO, WebDriver driver) {
        if (firstPO.getSearchResult().stream().anyMatch(x->x.getText().contains("Гладиолус — Википедия"))) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Ссылки Гладиолус — Википедия нет");
        }
    }

    @Step("Шаг 1. Сортировка по айфонам")
    public static void findIphone(PageObjectYandexMarketMain yandexMarketPO, WebDriver chromeDriver) throws InterruptedException {
        yandexMarketPO.goToPhones();
    }

    @Step("Шаг 2. Проверка что на странице только айфоны")
    public static void checkPhones(PageObjectYandexMarketPhones yandexMarketPhonesPO, WebDriver chromeDriver) throws InterruptedException {
        yandexMarketPhonesPO.filterPhones();
        while (true) {
            Thread.sleep(5000);
            yandexMarketPhonesPO.savePhones();
            yandexMarketPhonesPO.getPhones().forEach(x -> System.out.println(x.getText()));
            Assertions.assertTrue(yandexMarketPhonesPO.getPhones().stream().allMatch(x -> x.getText().contains("iPhone")));
            if (chromeDriver.findElements(By.xpath("//a[contains(.,'Вперёд')]")).size()>0)
            {
                yandexMarketPhonesPO.getNextPage().click();
            } else {
                break;
            }
        }
    }
}