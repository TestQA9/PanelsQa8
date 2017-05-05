package com.telran;

import com.telran.pages.ElenaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginElenaTest extends TestNgTestBase {

    public ElenaPage elenaPage;


    @BeforeMethod
    public void initPageObjects() {
        elenaPage = PageFactory.initElements(driver, ElenaPage.class);

    }

    @Test

    public void negativeLoginTest() {
        driver.get("https://greengnome.github.io/panels");
        elenaPage.waitLoginPagetoload();
        elenaPage.fillUsername("");
        elenaPage.filPasswordField("");
        elenaPage.clickbutton();
        elenaPage.waitLoginPagetoload();
        Assert.assertTrue(elenaPage.isOnLoginPage(), "We are not on login page");
    }


}
