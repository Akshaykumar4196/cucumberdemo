package com.qa.factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver driver;

    public WebDriver init_driver(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://bar.bagconsult.eu/");
        return getDriver();
    }

    public static WebDriver getDriver() {return driver;}
}
