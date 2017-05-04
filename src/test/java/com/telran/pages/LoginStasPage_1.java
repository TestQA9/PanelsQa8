package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page positive login
 */
public class LoginStasPage_1 extends Page
{
  private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
//----------------------------------------------------------------------//переменные
  @FindBy (id = "login")
  WebElement loginField;

  @FindBy (id = "pass")
  WebElement passwordField;

  @FindBy (id = "button")
  WebElement buttonLogin;

  @FindBy(xpath = ".//div[@class='mdl-color--black mdl-color-text--yellow'][text()='PANELS']")
  WebElement textPANELS;
//----------------------------------------------------------------------//конструктор
  public LoginStasPage_1(WebDriver driver)
  {
    super(driver);//наследуем от супер-класса
    PageFactory.initElements(driver, this);
  }
//=======================================================================//
 public void toFielLoginField(String login)
 {
   setElementText(loginField,login);
 }

 public void toFielPasswordField(String password)
 {
   setElementText(passwordField,password);
 }

 public void clickLoginButton()
 {
   clickElement(buttonLogin);
 }

 public void waitLoginPageLoad()
 {
   waitUntilIsLoaded(buttonLogin);
 }

    public void waitPANELSpageLoad()
    {
        waitUntilIsLoaded(textPANELS);
    }

  public boolean isOnPANELSpage()
  {
    return (exists(textPANELS));
  }

//----------------------------------------------------------------------//

}
