package ru.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectGoogle {

    private WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;
    private List<WebElement> searchResult;

    PageObjectGoogle(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.xpath("//*[@title ='Поиск']"));
        searchButton = chromeDriver.findElement(By.xpath("//*[@class='FPdoLc tfB0Bf']//*[@value='Поиск в Google']"));
    }

    public List<WebElement> getSearchResult() {
        return searchResult;
    }

    public void find(String keyWord){
        searchField.click();
        searchField.sendKeys(keyWord);
        searchButton.click();
    }

    public void refreshListOfElement(){
        searchResult = chromeDriver.findElements(By.xpath("//*[@class=\"LC20lb DKV0Md\"]"));
    }

}
