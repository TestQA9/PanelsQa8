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
public class LoginGlebPage extends Page {
  private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

  @FindBy(id = "login")
  WebElement loginField;

  @FindBy(id = "pass")
  WebElement passField;

  @FindBy(id = "button")
  WebElement loginButton;

  @FindBy(id = "quit")
  WebElement logoutButton;


  public LoginGlebPage(WebDriver driver) {
    super(driver);//наследуем от супер-класса
    PageFactory.initElements(driver, this);

  }
  //actions
  public void fillLoginField(String text){
    setElementText(loginField, text);
  }

  public void fillPassField(String text){
    setElementText(passField, text);
  }

  public void pressLoginButton() {clickElement(loginButton);}

  //waits
  public void waitLoginPageToLoad(){
waitUntilIsLoaded(loginButton);
  }

  public void waitCompaniesPageToLoad(){waitUntilIsLoaded(logoutButton);}

  //verifications
  public boolean isOnLoginPage(){
    return exists(loginButton);
  }

  public boolean isOnCompaniesPage(){return exists(logoutButton);}
}
