package com.telran;

import com.telran.pages.LoginBerAnnaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginBerAnnaTest extends TestNgTestBase {

    public LoginBerAnnaPage loginBerAnnaPage;


    @BeforeMethod
    public void initPageObjects() {
        loginBerAnnaPage = PageFactory.initElements(driver, LoginBerAnnaPage.class);

    }

    @Test
    public void negativeLoginTest() {
        driver.get("https://greengnome.github.io/panels");
        loginBerAnnaPage.waitLoginPageToLoad();
        loginBerAnnaPage.fillLoginField("");
        loginBerAnnaPage.fillPasswordField("");
        loginBerAnnaPage.pressLoginButton();
        loginBerAnnaPage.waitLoginPageToLoad();

        Assert.assertTrue(loginBerAnnaPage.isOnLoginPage(), "We aren't on login page");
    }

}
