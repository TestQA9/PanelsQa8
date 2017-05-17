package com.telran;

import com.telran.pages.LoginVikaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginVikaTest extends TestNgTestBase {

    public LoginVikaPage loginVikaPage;


    @BeforeMethod
    public void initPageObjects() {
        loginVikaPage = PageFactory.initElements(driver, LoginVikaPage.class);

    }

    @Test(groups = {"smoke"})
    public void negativeLoginTest() {
        driver.get("https://greengnome.github.io/panels/");
        loginVikaPage.vaitLoginPagetoload();
        loginVikaPage.fillUsename("");
        loginVikaPage.fillPassword("");
        loginVikaPage.ClicktoLogin();
        loginVikaPage.vaitLoginPagetoload();

        Assert.assertTrue(loginVikaPage.IsOnLoginPage(), "We are not on login page");
    }

    @Test(groups = {"inProgress"})
    public void positiveLoginTest() {
        driver.get("https://greengnome.github.io/panels");
        loginVikaPage.vaitLoginPagetoload();
        loginVikaPage.fillUsename("admin");
        loginVikaPage.fillPassword("12345");
        loginVikaPage.ClicktoLogin();
        loginVikaPage.vaitLoginPagetoload();
        //   Assert.assertTrue(loginVikaPage."Not on the Main Menu Page");
    }

}
