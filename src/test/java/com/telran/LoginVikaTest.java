package com.telran;

import com.telran.pages.LoginVikaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginVikaTest extends TestNgTestBase {

    public LoginVikaPage loginVikaPage;

    @Test
    @BeforeMethod
    public void initPageObjects() {
        loginVikaPage = PageFactory.initElements(driver, LoginVikaPage.class);

    }

    public void negativeLoginTest() {
        driver.get("https://greengnome.github.io/panels/");
        loginVikaPage.vaitLoginPagetoload();
        loginVikaPage.fillUsename("");
        loginVikaPage.fillPassword("");
        loginVikaPage.ClicktoLogin();
        loginVikaPage.vaitLoginPagetoload();

        Assert.assertTrue(loginVikaPage.IsOnLoginPage(), "We are not on login page");
    }

}
