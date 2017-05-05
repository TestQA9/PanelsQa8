package com.telran;

import com.telran.pages.LoginAngelinaPage;
import com.telran.pages.LoginIakovV2Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginExampleAngelinaTest extends TestNgTestBase {

    public LoginAngelinaPage loginAngelinaPage;


    @BeforeMethod
    public void initPageObjects() {
        loginAngelinaPage = PageFactory.initElements(driver, LoginAngelinaPage.class);

    }

    @Test
    public void negativeLoginTest() {
        driver.get("https://greengnome.github.io/panels");
        loginAngelinaPage.waitLoginPagetoload();
        loginAngelinaPage.fillUsername("");
        loginAngelinaPage.fillPassword("");
        loginAngelinaPage.clicktoLogin();
        loginAngelinaPage.waitLoginPagetoload();
        Assert.assertTrue(loginAngelinaPage.isOnLoginPage(), "We are not on login page");
    }
    @Test
    public void positiveLoginTest() {
        driver.get("https://greengnome.github.io/panels");
        loginAngelinaPage.waitLoginPagetoload();
        loginAngelinaPage.fillUsername("admin");
        loginAngelinaPage.fillPassword("12345");
        loginAngelinaPage.clicktoLogin();
        loginAngelinaPage.waitHomePagetoload();
        Assert.assertTrue(loginAngelinaPage.isOnHomePage(), "We are not logged in");
    }

}
