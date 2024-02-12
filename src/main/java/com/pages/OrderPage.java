package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {
    public WebDriver driver;

    public OrderPage(WebDriver driver){this.driver=driver;}

    //objectRepo
    By quantity = By.xpath("//input[@placeholder='Quantity']");
    By name = By.xpath("//input[@placeholder='Your name']");
    By email = By.xpath("//input[@placeholder='Your email']");
    By checkBox = By.xpath("//input[@type='checkbox']");
    By order = By.xpath("//input[@value='Order']");
    By dropDown = By.xpath("//select[@id='Size']");

    double price;
    public void fillOrderDetails(String arg0, String arg1, String arg2, String arg3) {
        Select select = new Select(driver.findElement(dropDown));
        if (arg0.equalsIgnoreCase("small")) {
            select.selectByIndex(1);
            price=3.4;
        } else {
            select.selectByIndex(2);
            price=5.6;
        }
        driver.findElement(quantity).sendKeys(arg1);
        driver.findElement(name).sendKeys(arg2);
        driver.findElement(email).sendKeys(arg3);
        driver.findElement(checkBox).click();
        driver.findElement(order).click();
    }

    public double getPrice(){
        return price;
    }


}
