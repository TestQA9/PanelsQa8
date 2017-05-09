package com.telran;

import com.telran.pages.LoginIakovV2Page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginExampleTest extends TestNgTestBase {

    public LoginIakovV2Page loginIakovV2Page;


    @BeforeMethod
    public void initPageObjects() {


    }

    @Test(groups = {"smoke"})
    public void negativeLoginTest1() {
        driver.get("https://greengnome.github.io/panels");
        loginIakovV2Page.waitLoginPagetoload();
        loginIakovV2Page.fillUsername("");
        loginIakovV2Page.fillPassword("");
        loginIakovV2Page.clicktoLogin();
        loginIakovV2Page.waitLoginPagetoload();
        Assert.assertTrue(loginIakovV2Page.isOnLoginPage(), "We are not on login page");
    }

    @Test(groups = {"smoke", "inProgress"})
    public void negativeLoginTest2() {
        driver.get("https://greengnome.github.io/panels");
        loginIakovV2Page.waitLoginPagetoload();
        loginIakovV2Page.fillUsername("");
        loginIakovV2Page.fillPassword("");
        loginIakovV2Page.clicktoLogin();
        loginIakovV2Page.waitLoginPagetoload();
        Assert.assertTrue(loginIakovV2Page.isOnLoginPage(), "We are not on login page");
    }

}
