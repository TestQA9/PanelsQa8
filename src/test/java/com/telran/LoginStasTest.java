package com.telran;


import com.telran.pages.LoginStasPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginStasTest extends TestNgTestBase
{

    public LoginStasPage loginStasPage; //instance of class

    @BeforeMethod
    public void initPageObjects()
    {
        loginStasPage = PageFactory.initElements(driver, LoginStasPage.class);// инициализация класса

    }
//--------------------------------------------------------------------------//
    @Test
public void negativeLoginTest()
{
    driver.get("https://greengnome.github.io/panels");
    loginStasPage.waitLoginPageLoad();
    loginStasPage.fillLoginField("");
    loginStasPage.fillPasswordField("");
    loginStasPage.clickToLogin();
    loginStasPage.waitLoginPageLoad();
    Assert.assertTrue(loginStasPage.isOnLoginPage(),"We are not on login page!!!");
}
}
