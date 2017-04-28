package com.telran;

import com.telran.pages.LoginTonyPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTonyTest extends TestNgTestBase {

    public LoginTonyPage loginTonyPage;

    @BeforeMethod
public void initPageObjects() {
        loginTonyPage = PageFactory.initElements(driver, LoginTonyPage.class);
    }

    @Test
public void negativeLoginTest(){
 driver.get("https://greengnome.github.io/panels");
    loginTonyPage.waitLoginPageToLoad();
    loginTonyPage.fillLoginField("");
    loginTonyPage.fillPasswordField("");
    loginTonyPage.clickButton();
    loginTonyPage.waitLoginPageToLoad();
    Assert.assertTrue(loginTonyPage.isOnLoginPage(),"Not on Login Page");
}

}
