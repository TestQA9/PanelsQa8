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
public class LoginKapelovichPage extends Page {
  private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
  @FindBy(id = "button")
  public WebElement loginButton;
  @FindBy(xpath = ".//*[@id='quit']")
  public WebElement ButtonQuit;
  @FindBy(id = "login")
  WebElement loginField;
  @FindBy(id= "pass")
  WebElement passwordField;

  public LoginKapelovichPage(WebDriver driver) {
    super(driver);//
    PageFactory.initElements(driver, this);

  }

  public void fillLoginField(String logintext){
    setElementText(loginField, logintext);
  }

  public void fillPasswordField(String passwordtext){
    setElementText(passwordField, passwordtext);
  }

  public void pressLoginButton() {
    clickElement(loginButton);
  }

  public void waitForLoginPageIsLoaded() {
    waitUntilIsLoaded(loginButton);
  }

  public boolean isOnCompanyPage() {
    return exists(ButtonQuit);
  }

  public boolean isOnLoginPage (){
    return exists(loginButton);
  }
}

