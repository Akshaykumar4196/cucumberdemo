package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver){this.driver=driver;}

    //Object Repo

    private By userNm = By.name("email");
    private  By passWd = By.name("pass");
    private By loginBtn = By.name("login");

    public void enterUserCredentials(String usNm , String pwd){
        driver.findElement(userNm).sendKeys(usNm);
        driver.findElement(passWd).sendKeys(pwd);
    }
    public void clickSubmitButton(){
        driver.findElement(loginBtn).click();
    }
}
