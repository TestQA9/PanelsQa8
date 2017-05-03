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
public class LoginBerAnnaPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @FindBy(id = "login")
    WebElement loginField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(id = "button")
    WebElement submitButton;

    @FindBy(tagName = "b")
    WebElement panelsPage;

    public LoginBerAnnaPage(WebDriver driver) {
        super(driver);//наследуем от супер-класса
        PageFactory.initElements(driver, this);

    }

    public void fillLoginField(String text) {
        setElementText(loginField, text);
    }

    public void fillPasswordField(String text) {
        setElementText(passwordField, text);
    }

    public void pressLoginButton() {
        clickElement(submitButton);
    }

    //vaits
    public void waitLoginPageToLoad() {
        waitUntilIsLoaded(submitButton);
    }

    public void waitPanelsToLoad() {
        waitUntilIsLoaded(panelsPage);
    }

    //verifications
    public boolean isOnLoginPage() {
        return exists(submitButton);
    }

    public boolean isOnPanelsPage() {
        return exists(panelsPage);
    }
}
