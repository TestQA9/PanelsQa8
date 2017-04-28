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

    @Test
    public void negativeLoginTest() {
        driver.get("https://greengnome.github.io/panels");
        loginLijulaPage.waitLoginPageToLoad();
        loginLijulaPage.fillUsername("");
        loginLijulaPage.fillPassword("");
        loginLijulaPage.pressButton();
        loginLijulaPage.waitLoginPageToLoad();
        Assert.assertTrue(loginLijulaPage.isOnLoginPage(), "We are not on login page");
    }

}
