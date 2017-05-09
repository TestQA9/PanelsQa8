package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class LoginAlexanderPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @FindBy(id = "login")
    WebElement loginField;

    @FindBy(id = "pppass")
    WebElement passField;

    @FindBy(id = "button")
    WebElement submitButton;

    public LoginAlexanderPage(WebDriver driver) {
        super(driver);//наследуем от супер-класса
        PageFactory.initElements(driver, this);

    }
      // ACTIONS

    public void fillUserName (String text){
        setElementText(loginField, text);
    }

    public void fillPassword (String text){
        setElementText(passField, text);
    }

    public void preesLoginButton(){
        clickElement(submitButton);
    }

    // WAITS

    public void waitLoginPageLoaded(){
        waitUntilIsLoaded(submitButton);
    }

    //VERIFICATIONS

    public boolean isOnLoginPage(){
        return exists(submitButton);
    }


}

