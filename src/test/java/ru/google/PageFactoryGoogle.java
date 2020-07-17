package ru.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PageFactoryGoogle {
    private WebDriver chromeDriver;

    @FindBy(how= How.XPATH, using = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")
    WebElement searchField;

    @FindBy(how= How.XPATH, using = "//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")
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
