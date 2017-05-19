package com.telran;

import com.telran.pages.LoginRaisaPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginRaisaTest extends TestNgTestBase {

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    /*  @BeforeMethod
    public void initPageObjects() {
        loginRaisaPage = PageFactory.initElements(driver, LoginRaisaPage.class);
    }*/
    public LoginRaisaPage loginRaisaPage;

    @Test(groups = {"smoke"})
    public void negativeLoginTest() {
        driver.get("https://greengnome.github.io/panels");
        loginRaisaPage.waitLoginPageLoad();
        loginRaisaPage.fillLoginField("");
        loginRaisaPage.fillPasswordField("");
        loginRaisaPage.clickLoginButton();
        loginRaisaPage.waitLoginPageLoad();
        Log.info("Check that we are on login page");
        Assert.assertTrue(loginRaisaPage.isOnLoginPage(), "We are not on login page");
    }

    @Test(groups = {"smoke"})
    public void positiveLoginTest() {
        driver.get("https://greengnome.github.io/panels");
        loginRaisaPage.waitLoginPageLoad();
        loginRaisaPage.fillLoginField("admin");
        loginRaisaPage.fillPasswordField("12345");
        loginRaisaPage.clickLoginButton();
        loginRaisaPage.waitPANELSpageLoad();
        Log.info("Check that we are on panels page");
        Assert.assertTrue(loginRaisaPage.isOnPANELSpage(), "We are not on PANELS page!!!");
    }

}
