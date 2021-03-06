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
public class ElenaPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    @FindBy(id = "login")
    WebElement loginField;

    @FindBy(id = "pass")
    WebElement passField;


    @FindBy(id = "button")
    WebElement submitButton;

    @FindBy(tagName = "b")
    WebElement panelsPage;


    public ElenaPage(WebDriver driver) {
        super(driver);//наследуем от супер-класса
        PageFactory.initElements(driver, this);

    }

    //actions
    public void fillUsername(String text) {
        Log.info("Fill Username With " + text);
        setElementText(loginField, text);
    }

    public void filLoginField(String text) {
        Log.info("Fill Login With " + text);
        setElementText(loginField, text);
    }

    public void clickbutton() {
        Log.info("Click to login");
        clickElement(submitButton);
    }

    public void filPasswordField(String text) {
        Log.info("Fill password with " + text);
        setElementText(passField, text)
        ;
    }

    //vaits
    public void waitLoginPagetoload() {
        waitUntilIsLoaded(submitButton);
    }

    public void waitPanelsToLoad() {
        waitUntilIsLoaded(panelsPage);
    }

    //verifcations

    public boolean isOnLoginPage() {
        return exists(submitButton);
    }

    public boolean isOnPanelsPage() {
        return exists(panelsPage);
    }

}