package com.telran;

import com.telran.pages.LoginKapelovichPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class LoginExampleTest extends TestNgTestBase {

    public LoginKapelovichPage loginIakovPage;


    @BeforeMethod
    public void initPageObjects() {
        loginIakovPage = PageFactory.initElements(driver, LoginKapelovichPage.class);

    }


}
