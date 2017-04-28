package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class LoginYuriyPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @FindBy(id = "login")
    WebElement loginField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(id = "button")
    WebElement submitButton;

    public LoginYuriyPage(WebDriver driver) {
        super(driver);//наследуем от супер-класса
        PageFactory.initElements(driver, this);

    }

    //actions
    public void fillUserName(String text) {
        setElementText(loginField, text);
    }

    public void fillPassword(String text) {
        setElementText(passwordField, text);
    }

    public void clickToLogin() {
        clickElement(submitButton);
    }

    //waiting

    public void waitLoginPageToLoad() {
        waitUntilIsLoaded(submitButton);
    }

    //verifications

    public boolean isOnLoginPage() { //checks if we are still on Login Page
        return exists(submitButton);
    }

}

