package com.telran;

import com.telran.pages.LoginAlexanderPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAlexanderTest extends TestNgTestBase {

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public LoginAlexanderPage loginAlexanderPage;


    @BeforeMethod
    public void initPageObjects() {
        loginAlexanderPage = PageFactory.initElements(driver, LoginAlexanderPage.class);

    }
    @Test (groups = {"smoke",})
    public void negativeLoginTest(){
        driver.get("https://greengnome.github.io/panels");
        loginAlexanderPage.waitLoginPageLoaded();
        loginAlexanderPage.fillUserName(" ");
        loginAlexanderPage.fillPassword(" ");
        loginAlexanderPage.preesLoginButton();
        loginAlexanderPage.waitLoginPageLoaded();

        Assert.assertTrue(loginAlexanderPage.isOnLoginPage(),"We Are Not On Login Page");
    }

    @Test (groups = {"inProgress"})
    public void positiveLoginTest(){
        driver.get("https://greengnome.github.io/panels");
        loginAlexanderPage.waitLoginPageLoaded();
        loginAlexanderPage.fillUserName("");
        loginAlexanderPage.fillPassword(" ");
        loginAlexanderPage.preesLoginButton();
        loginAlexanderPage.waitLoginPageLoaded();
        Log.info("");
        Assert.assertTrue(loginAlexanderPage.isOnLoginPage(), "We Are On Login Page");
    }

}
