package com.telran;

import com.telran.pages.LoginIakovPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class LoginExampleTest extends TestNgTestBase {

    public LoginIakovPage loginIakovPage;


    @BeforeMethod
    public void initPageObjects() {
        loginIakovPage = PageFactory.initElements(driver, LoginIakovPage.class);

    }


}
