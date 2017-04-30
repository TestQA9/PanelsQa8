package com.telran;

import com.telran.pages.LoginGlebPage;
import com.telran.pages.LoginGlebPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginGlebTest extends TestNgTestBase {

    public LoginGlebPage loginGlebPage;


    @BeforeMethod
    public void initPageObjects() {
        loginGlebPage = PageFactory.initElements(driver, LoginGlebPage.class);

    }

    @Test
public void negativeLoginTest(){
        driver.get("https://greengnome.github.io/panels/#/login");
        loginGlebPage.waitLoginPageToLoad();
        loginGlebPage.fillLoginField("");
        loginGlebPage.fillPassField("");
        loginGlebPage.pressLoginButton();
        loginGlebPage.waitLoginPageToLoad();
    Assert.assertTrue(loginGlebPage.isOnLoginPage(), "We are not on login page");
}

}
