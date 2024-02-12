package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    public WebDriver driver;
    public OrderConfirmationPage(WebDriver driver){this.driver=driver;}

    private By price = By.xpath("//span[@id='Price']");
    private By continueShopping =By.xpath("//a[text()='Continue shopping']");

    public double getPrice() throws InterruptedException {
        Thread.sleep(5000);
        return Double.parseDouble(driver.findElement(price).getText());
    }

    public  void setContinueShopping(){
        driver.findElement(continueShopping).click();
    }
}
