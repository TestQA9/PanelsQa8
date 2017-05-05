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
public class LoginIlyaPage extends Page {
  private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

  @FindBy(id = "login")
  WebElement loginField;

  @FindBy(id = "pass")
  WebElement passwordField;

  @FindBy(id="button")
  WebElement submitbutton;


  //actions
  public LoginIlyaPage(WebDriver driver) {
    super(driver);//наследуем от супер-класса
    PageFactory.initElements(driver, this);

  }

  public void fieldloginField(String logintext){
    setElementText(loginField,logintext);
  }

  public void fieldpasswordField(String passwordtext){
    setElementText(passwordField,passwordtext);
  }

  public void clicktoLogin(){
    clickElement(submitbutton);
  }

  //waits
  public void waitLoginPageToLoad(){
    waitUntilIsLoaded(submitbutton);
  }

  //Verifications
  public boolean isOnLoginPage(){
    return exists(submitbutton);
  }



}
