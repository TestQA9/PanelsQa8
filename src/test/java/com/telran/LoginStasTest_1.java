package com.telran;


import com.telran.pages.LoginStasPage;
import com.telran.pages.LoginStasPage_1;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginStasTest_1 extends TestNgTestBase
{

    public LoginStasPage_1 loginStasPage_1; //instance of class

    @BeforeMethod
    public void initPageObjects()
    {
        loginStasPage_1 = PageFactory.initElements(driver, LoginStasPage_1.class);// инициализация класса

    }
//--------------------------------------------------------------------------//
    @Test
public void positiveLoginTest()
{
    driver.get("https://greengnome.github.io/panels");
    loginStasPage_1.waitLoginPageLoad();
    loginStasPage_1.toFielLoginField("admin");
    loginStasPage_1.toFielPasswordField("12345");
    loginStasPage_1.clickLoginButton();
    loginStasPage_1.waitPANELSpageLoad();
    Assert.assertTrue(loginStasPage_1.isOnPANELSpage(),"We are not on PANELS page!!!");
}
}
