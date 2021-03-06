package com.telran;

import com.telran.pages.LoginLijulaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginLijulaTest extends TestNgTestBase {

    public LoginLijulaPage loginLijulaPage;



    @BeforeMethod
    public void initPageObjects() {
        loginLijulaPage = PageFactory.initElements(driver, LoginLijulaPage.class);
    }

    @Test(groups = {"smoke"})
    public void negativeLoginTest1() {
        driver.get("https://greengnome.github.io/panels");
        loginLijulaPage.waitLoginPageToLoad();
        loginLijulaPage.fillUsername("");
        loginLijulaPage.fillPassword("");
        loginLijulaPage.pressButton();
        loginLijulaPage.waitLoginPageToLoad();
        Assert.assertTrue(loginLijulaPage.isOnLoginPage(), "We are not on login page");
    }

    @Test(groups = {"smoke", "inProgress"})
    public void negativeLoginTest2() {
        driver.get("https://greengnome.github.io/panels");
        loginLijulaPage.waitLoginPageToLoad();
        loginLijulaPage.fillUsername("damin");
        loginLijulaPage.fillPassword("12345");
        loginLijulaPage.pressButton();
        loginLijulaPage.waitLoginPageToLoad();
        Assert.assertTrue(loginLijulaPage.isOnLoginPage(), "We are not on login page");
    }

    @Test(groups = {"smoke"})
    public void negativeLoginTest3() {
        driver.get("https://greengnome.github.io/panels");
        loginLijulaPage.waitLoginPageToLoad();
        loginLijulaPage.fillUsername("admin");
        loginLijulaPage.fillPassword("j254");
        loginLijulaPage.pressButton();
        loginLijulaPage.waitLoginPageToLoad();
        Assert.assertTrue(loginLijulaPage.isOnLoginPage(), "We are not on login page");
    }

    @Test(groups = {"smoke"})
    public void positiveLoginTest() {
        driver.get("https://greengnome.github.io/panels");
        loginLijulaPage.waitLoginPageToLoad();
        loginLijulaPage.fillUsername("admin");
        loginLijulaPage.fillPassword("12345");
        loginLijulaPage.pressButton();
        loginLijulaPage.waitCompaniesPageToLoad();
        Assert.assertTrue(loginLijulaPage.isOnCompaniesPage(), "We are on companies page");
    }
}
