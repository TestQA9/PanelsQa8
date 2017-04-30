package com.telran.pages.Learning;

import com.telran.LogLog4j;
import com.telran.pages.Page;
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
public class LoginKapelovichPage extends Page {
  private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

  @FindBy(xpath = ".//*[@id='login']")
  WebElement loginField;

  @FindBy(xpath=".//*[@id='pass']")
  WebElement passwordField;

  @FindBy(xpath = ".//*[@id='button']")
  public WebElement loginButton;



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

  // verifecation

  public boolean isOnLoginPage (){

    return exists(loginButton);
  }
}

