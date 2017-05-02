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
public class LoginStasPage extends Page
{
  private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
//--------------------------------------------------//
  //variables

  @FindBy(xpath = ".//input [@id='login']") // field 'login' но можно использовать xpath = ".//input [@id='login']"
  WebElement loginField; // тип переменной 'WebElement'

  @FindBy(id = "pass")
  WebElement passField;

  @FindBy(xpath = ".//button[@id='button']")
  WebElement loginButton;
//-----------------------------------------------//
  public LoginStasPage(WebDriver driver)
  {
    super(driver);//наследуем от супер-класса
    PageFactory.initElements(driver, this);
  }
  //actions
//------------------------------------------------//// method fill field 'login' >> setElementText(loginField,loginText);
public void fillLoginField(String loginText)
{
  setElementText(loginField,loginText);
}
//------------------------------------------------//// method fill field 'password'
public void fillPasswordField(String passwordText)
{
  setElementText(passField,passwordText);
}
//------------------------------------------------//
  public void clickToLogin()
  {
    clickElement(loginButton);

  }
  //waits
  //-----------------------------------------------//
  public void waitLoginPageLoad()
  {
    waitUntilIsLoaded(loginButton);
  }
  //-----------------------------------------------//
  //varification
  //-----------------------------------------------//
  public boolean isOnLoginPage()
  {
    return (exists(loginButton));//exist > метод проверяет наличие элемента на странице//
  }

  //==============================================//


}
