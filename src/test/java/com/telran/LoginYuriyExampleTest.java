package com.telran;

import com.telran.pages.LoginYuriyPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginYuriyExampleTest extends TestNgTestBase {

    public LoginYuriyPage loginYuriyPage; //first I create instance of my class


    @BeforeMethod
    public void initPageObjects() {
        loginYuriyPage = PageFactory.initElements(driver, LoginYuriyPage.class);

    }
// now writing a test

    @Test(groups = {"smoke"})
    public void negativeLoginTest() {
        driver.get("https://greengnome.github.io/panels/#/login");
        loginYuriyPage.waitLoginPageToLoad();
        loginYuriyPage.fillUserName("");
        loginYuriyPage.fillPassword("");
        loginYuriyPage.clickToLogin();
        loginYuriyPage.waitLoginPageToLoad();

        Assert.assertTrue(loginYuriyPage.isOnLoginPage(), "We are not on a Login page");
    }

    @Test(groups = {"regression"})
    public void negativeLoginTest2() {
        driver.get("https://greengnome.github.io/panels/#/login");
        loginYuriyPage.waitLoginPageToLoad();
        loginYuriyPage.fillUserName("");
        loginYuriyPage.fillPassword("");
        loginYuriyPage.clickToLogin();
        loginYuriyPage.waitLoginPageToLoad();

        Assert.assertTrue(loginYuriyPage.isOnLoginPage(), "We are not on a Login page");
    }

    @Test
    public void positiveLoginTest() {
        driver.get("https://greengnome.github.io/panels/#/login");
        loginYuriyPage.waitLoginPageToLoad();
        loginYuriyPage.fillUserName("admin");
        loginYuriyPage.fillPassword("12345");
        loginYuriyPage.clickToLogin();
        loginYuriyPage.waitLoginPageToLoad();
        Assert.assertTrue(loginYuriyPage.isOnLoginPage(), "We are on login page");
    }
}
