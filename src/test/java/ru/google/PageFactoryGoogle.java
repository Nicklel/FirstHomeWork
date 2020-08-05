package ru.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PageFactoryGoogle {
    private WebDriver chromeDriver;

    @FindBy(how= How.XPATH, using = "//*[@title ='Поиск']")
    WebElement searchField;

    @FindBy(how= How.XPATH, using = "//*[@class='FPdoLc tfB0Bf']//*[@value='Поиск в Google']")
    WebElement searchButton;

    @FindAll(@FindBy(how = How.XPATH, using = "//*[@class=\"LC20lb DKV0Md\"]"))
    List<WebElement> searchResult;

    public PageFactoryGoogle(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
    }

    public List<WebElement> getSearchResult() {
        return searchResult;
    }

    public void find(String keyWord){
        searchField.click();
        searchField.sendKeys(keyWord);
        searchButton.click();
    }
}
