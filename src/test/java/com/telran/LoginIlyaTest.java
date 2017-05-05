package com.telran;


import com.telran.pages.LoginIlyaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Sample page
 */
public class LoginIlyaTest extends TestNgTestBase {


  public LoginIlyaPage loginIlyaPage;

  @BeforeMethod
  public void initPageObjects() {
    loginIlyaPage = PageFactory.initElements(driver, LoginIlyaPage.class);
  }

@Test
public void NegativeLoginTest(){
    driver.get("https://greengnome.github.io/panels");
    loginIlyaPage.waitLoginPageToLoad();
    loginIlyaPage.fieldloginField("");
    loginIlyaPage.fieldpasswordField("");
    loginIlyaPage.clicktoLogin();
    loginIlyaPage.waitLoginPageToLoad();
  Assert.assertTrue(loginIlyaPage.isOnLoginPage(),"We are not on login page");
}









}
