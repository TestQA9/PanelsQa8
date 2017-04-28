package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTonyPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @FindBy(id = "login")
    WebElement loginField;

    @FindBy(id = "pass")

    WebElement passwordField;

    @FindBy(id = "button")
    WebElement butButton;

    public LoginTonyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillLoginField(String text) {
        setElementText(loginField, text);
    }

    public void fillPasswordField(String logintext) {
        setElementText(passwordField, logintext);
    }

    public void clickButton(){
        this.clickElement(butButton);
    }

    public void waitLoginPageToLoad(){
    waitUntilIsLoaded(butButton);
    }

    public boolean isOnLoginPage(){
        return exists(butButton);
    }

}
