package ru.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class PageObjectYandexMarketPhones {

    private WebDriver chromeDriver;


    private WebElement AppleFilterBox;
    private WebElement nextPage;


    private List<WebElement> Phones;

    PageObjectYandexMarketPhones(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        AppleFilterBox = chromeDriver.findElement(By.xpath("//span [contains(.,'Apple')]"));
        nextPage = chromeDriver.findElement(By.xpath("//a[contains(.,'Вперёд')]"));

    }

    public List<WebElement> getPhones() {
        return Phones;
    }

    public WebElement getNextPage() {
        return nextPage;
    }


    public void filterPhones(){

        AppleFilterBox.click();
    }

    public void savePhones(){
        Phones = chromeDriver.findElements(By.xpath("//a[@class='_27nuSZ19h7 wwZc93J2Ao cia-cs']"));
    }
}
