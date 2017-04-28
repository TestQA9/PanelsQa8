package com.telran;

import com.telran.pages.LoginIakovV2Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginExampleTest extends TestNgTestBase {

    public LoginIakovV2Page loginIakovV2Page;


    @BeforeMethod
    public void initPageObjects() {
        loginIakovV2Page = PageFactory.initElements(driver, LoginIakovV2Page.class);

    }

    @Test
    public void negativeLoginTest() {
        driver.get("https://greengnome.github.io/panels");
        loginIakovV2Page.waitLoginPagetoload();
        loginIakovV2Page.fillUsername("");
        loginIakovV2Page.fillPassword("");
        loginIakovV2Page.clicktoLogin();
        loginIakovV2Page.waitLoginPagetoload();
        Assert.assertTrue(loginIakovV2Page.isOnLoginPage(), "We are not on login page");
    }

}
