package com.telran.LearningTest;

import com.telran.DataProviders;
import com.telran.TestNgTestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAnnaTest extends TestNgTestBase {



    private String url = "https://greengnome.github.io/panels";
    private String rightUsername = "admin";
    private String rightPassword = "12345";

    @BeforeMethod(alwaysRun = true)
    public void initPageObjects() {
        driver.get(baseUrl);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeAdmin")
    public void negativeAllWrongLoginTest(String login, String pass) {

        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField(login);
        loginPage.fillPasswordField(pass);

        loginPage.pressLoginButton();
        loginPage.waitUntilIsLoadedCustomTime(loginPage.alertWrongLogin, 20);

//         Assert.assertTrue(loginPage.isOnLoginPage());
        Assert.assertTrue(loginPage.isAlertDisplayed());
    }

    @Test
    public void positiveLoginTest() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField(rightUsername);
        loginPage.fillPasswordField(rightPassword);

        loginPage.pressLoginButton();
        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.managementButton, 30);
//        Assert.assertTrue(companiesAnna.isManagementButtonDisplayed());
        Assert.assertTrue(companiesAnna.isManagementButtonPresent());
    }

    @Test
    public void positiveLoginTestAnyScreen() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField(rightUsername);
        loginPage.fillPasswordField(rightPassword);

        loginPage.pressLoginButton();
//        loginPage.wait(20000, 0);

//        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.menuButton, 20);
//        if(!companiesAnna.isMenuButtonDisplayed()) {
//            Assert.assertTrue(companiesAnna.isManagementButtonPresent());
//        }

        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.managementButton, 15);
        if (!companiesAnna.isManagementButtonPresent()) {
            Assert.assertTrue(companiesAnna.isMenuButtonDisplayed());
            companiesAnna.menuButton.click();
        }
//        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.managementButton, 5);
        Assert.assertTrue(companiesAnna.isManagementButtonPresent());
    }

    @Test
    public void positiveDoubleClickLoginTest() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField(rightUsername);
        loginPage.fillPasswordField(rightPassword);

        loginPage.isDoubleClicked();
        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.managementButton, 30);
        Assert.assertTrue(companiesAnna.isManagementButtonDisplayed());
    }

    @Test
    public void negativeWrongUsernameLoginTest() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField("abcde");
        loginPage.fillPasswordField(rightPassword);

        loginPage.pressLoginButton();
        loginPage.waitUntilIsLoadedCustomTime(loginPage.alertWrongLogin, 30);

        Assert.assertTrue(loginPage.isAlertDisplayed());
    }

    @Test
    public void negativeWrongPasswordLoginTest() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField(rightUsername);
        loginPage.fillPasswordField("54321");

        loginPage.pressLoginButton();
        loginPage.waitUntilIsLoadedCustomTime(loginPage.alertWrongLogin, 30);

        Assert.assertTrue(loginPage.isAlertDisplayed());
    }

}