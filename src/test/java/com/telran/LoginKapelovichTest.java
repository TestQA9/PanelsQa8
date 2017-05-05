package com.telran;

import com.telran.pages.LoginKapelovichPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginKapelovichTest extends TestNgTestBase {

    public LoginKapelovichPage loginKapelovichPage;


    @BeforeMethod
    public void initPageObjects() {
        loginKapelovichPage = PageFactory.initElements(driver, LoginKapelovichPage.class);

    }
@Test
    public void negativeLoginTest(){
        driver.get("https://greengnome.github.io/panels");
        loginKapelovichPage.waitForLoginPageIsLoaded();
        loginKapelovichPage.fillLoginField("");
        loginKapelovichPage.fillPasswordField("");
        loginKapelovichPage.pressLoginButton();
    loginKapelovichPage.waitForLoginPageIsLoaded();
        Assert.assertTrue(loginKapelovichPage.isOnLoginPage(), "We are not on login page");
    }

    @Test
    public void positiveLoginTest() {
        driver.get("https://greengnome.github.io/panels");
        loginKapelovichPage.waitForLoginPageIsLoaded();
        loginKapelovichPage.fillLoginField("admin");
        loginKapelovichPage.fillPasswordField("12345");
        loginKapelovichPage.pressLoginButton();
        loginKapelovichPage.waitForLoginPageIsLoaded();
        Assert.assertTrue(loginKapelovichPage.isOnCompanyPage(), "We are on login page");
    }



}
