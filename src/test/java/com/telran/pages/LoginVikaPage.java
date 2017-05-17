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
public class LoginVikaPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @FindBy(id = "login")
    WebElement loginField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(id = "button")
    WebElement submitButton;


    @FindBy(id = "quit")
    WebElement ButtonQuit;




    public LoginVikaPage(WebDriver driver) {
        super(driver);//наследуем от супер-класса
        PageFactory.initElements(driver, this);

    }

    //actions
    public void fillUsename(String text) {
        Log.info("Fill username wish" + text);
        setElementText(loginField, text);
    }

    public void fillPassword(String text) {
        Log.info("Fill password wish" + text);
        setElementText(passwordField, text);
    }

    public void ClicktoLogin() {
        Log.info("Click to login");
        clickElement(submitButton);
    }

    public void vaitLoginPagetoload() {
        Log.info("Vait login page to load");
        waitUntilIsLoaded(submitButton);
    }
    // public void waitCompaniesPageToLoad(){waitUntilIsLoaded(logoutButton);}
    // public boolean isOnCompanyPage() {
    //   return exists(ButtonQuit);
    //}

    public boolean IsOnLoginPage() {
        return exists(submitButton);
    }

}
