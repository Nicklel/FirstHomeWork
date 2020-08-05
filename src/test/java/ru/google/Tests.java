package ru.google;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import javax.naming.directory.SearchResult;
import java.util.List;

public class Tests extends WebDriverSettings {

/*    @Test
    public void firstTask(){
        chromeDriver.get("https://www.google.ru");
        WebElement searchField = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        WebElement searchButton = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));
        searchField.click();
        searchField.sendKeys("гладиолус");
        searchButton.click();

        List<WebElement> searchResult = chromeDriver.findElements(By.xpath("//*[@class=\"LC20lb DKV0Md\"]"));
        Assertions.assertTrue(searchResult.size()>3);

    }
    @Test
    public void secondTask(){
        chromeDriver.get("https://www.google.ru");
        WebElement searchField = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        WebElement searchButton = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));
        searchField.click();
        searchField.sendKeys("гладиолус");
        searchButton.click();

        List<WebElement> searchResult = chromeDriver.findElements(By.xpath("//*[@class=\"LC20lb DKV0Md\"]"));
        System.out.println(searchResult.size());
        Assertions.assertTrue(searchResult.stream().anyMatch(x->x.getText().contains("Гладиолус — Википедия")));

    }*/

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
}
