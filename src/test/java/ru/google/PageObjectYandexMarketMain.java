package ru.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class PageObjectYandexMarketMain {

    private WebDriver chromeDriver;

    private WebElement CatalogButton;
    private WebElement ElectronicsButton;
    private WebElement SmartphoneButton;




    PageObjectYandexMarketMain(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        CatalogButton = chromeDriver.findElement(By.xpath("//span[contains(.,'Каталог товаров')]"));
  /*      ElectronicsButton = chromeDriver.findElement(By.xpath("//button[@id='39889743-tab']"));
        SmartphoneButton = chromeDriver.findElement(By.xpath("//a[text()='Смартфоны и умные часы']/..//..//a[text()='Смартфоны']"));*/


    }



    public void goToPhones() throws InterruptedException {
        Actions actions = new Actions(chromeDriver);
        Thread.sleep(10000);
        CatalogButton.click();
        ElectronicsButton = chromeDriver.findElement(By.xpath("//button[@id='39889743-tab']"));
        actions.moveToElement(ElectronicsButton).build().perform();
        SmartphoneButton = chromeDriver.findElement(By.xpath("//a[text()='Смартфоны и умные часы']/..//..//a[text()='Смартфоны']"));
        SmartphoneButton.click();

    }
}
