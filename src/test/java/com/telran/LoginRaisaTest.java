package com.telran;

import com.telran.pages.LoginRaisaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginRaisaTest extends TestNgTestBase {

    public LoginRaisaPage loginRaisaPage;


    @BeforeMethod
    public void initPageObjects() {
        loginRaisaPage = PageFactory.initElements(driver, LoginRaisaPage.class);
    }

    @Test
    public void negativeLoginTest() {
        driver.get("https://greengnome.github.io/panels");
        loginRaisaPage.waitLoginPageLoad();
        loginRaisaPage.fillLoginField("");
        loginRaisaPage.fillPasswordField("");
        loginRaisaPage.clickLoginButton();
        loginRaisaPage.waitLoginPageLoad();
        Assert.assertTrue(loginRaisaPage.isOnLoginPage(), "We are not on login page");
    }

}
