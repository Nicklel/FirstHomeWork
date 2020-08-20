package ru.google;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    WebDriver chromeDriver;

/*    @BeforeEach
    private void startTestInDocker(){
        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setVersion("83.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        try {
            chromeDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    }

    @AfterEach
    private void endTestInDocker(){
        if(chromeDriver!=null){
            chromeDriver.quit();
            chromeDriver=null;
        }

    }*/


    @BeforeEach
    public void startBrowser(){

        //System.setProperty("webdriver.chrome.driver","C:\\temp\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER"));
        chromeDriver=new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    }

    @AfterEach
    public void closeTest(){
        chromeDriver.quit();
    }

}
