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
    WebElement loginButton;

    public LoginBerAnnaPage(WebDriver driver) {
        super(driver);//наследуем от супер-класса
        PageFactory.initElements(driver, this);

    }

    public void fillLoginField(String logintext) {
        setElementText(loginField, logintext);
    }

    public void fillPasswordField(String logintext) {
        setElementText(passwordField, logintext);
    }

    public void pressLoginButton() {
        Log.info("Clicking to login button ");
        clickElement(loginButton);
    }
}
