package com.telran.LearningTest;

import com.telran.DataProviders;
import com.telran.LogLog4j;
import com.telran.TestNgTestBase;
import com.telran.pages.Learning.CompaniesMarinaPage;
import com.telran.pages.Learning.HeaderMarinaPage;
import com.telran.pages.Learning.LoginMarinaPage;
import com.telran.pages.Learning.NavigationMarinaPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.factory.WebDriverPool;

public class LoginMarinaTest extends TestNgTestBase {
    private static final String URL_LINK = "https://greengnome.github.io/panels/";
    private static final String PSW_ADM = "12345";
    private static final String LOGIN_ADM ="Admin" ;
    private static final String NAME_COMPANY ="Tadiran" ;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private LoginMarinaPage loginMarinaPage;
    private CompaniesMarinaPage companiesMarinaPage;
    private NavigationMarinaPage navigationMarinaPage;
    private HeaderMarinaPage headerMarinaPage;


    @BeforeMethod(alwaysRun = true)
    public void initPageObjects() {
        loginMarinaPage = PageFactory.initElements(driver, LoginMarinaPage.class);
        companiesMarinaPage = PageFactory.initElements(driver,CompaniesMarinaPage.class);
        navigationMarinaPage = PageFactory.initElements(driver, NavigationMarinaPage.class);
        headerMarinaPage = PageFactory.initElements(driver, HeaderMarinaPage.class);
        driver.get(URL_LINK);
        loginMarinaPage.waitForLoginPageIsLoadedTime50();
}
    @BeforeClass(alwaysRun = true)
    public void initWebDriver() {
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
    }

    @Test(groups = {"smoke", "regression"},dataProviderClass = DataProviders.class, dataProvider = "negativeAdmin")
    //@Test(dataProviderClass = DataProviders.class, dataProvider = "negativeAdmin")
    public void negativeLoginTest(String login, String pass) {
        Log.info("----Test: negativeLoginTest");
        loginMarinaPage.fillLoginField(login)
                        .fillPassField(pass)
                        .clickOnLoginButton()
                        .waitForLoginPageIsLoaded();
        Assert.assertTrue(loginMarinaPage.isOnLoginPage(),"Not passed. User is not on login page");
    }

    //@Test(groups = "regression")
    /*public void negativeLoginTestPswIncorrect() {

        loginMarinaPage.fillLoginField(LOGIN_ADM)
                        .fillPassField("hjkwi")
                        .clickOnLoginButton();
        //companiesMarinaPage.waitForCompanyLoaded("Tadiran"); - it doesn't work (with dynamic element)
        companiesMarinaPage.waitForTadiranProjectLoaded();
        Assert.assertTrue(loginMarinaPage.isOnLoginPage(), "Not passed. User is not on login page");
    } */


    @Test(groups = {"smoke", "regression"})
    public void positiveAdminLoginTest() throws InterruptedException {
        Log.info("----Test: positiveLoginTest");
        loginMarinaPage.fillLoginField(LOGIN_ADM)
                        .fillPassField(PSW_ADM)
                        .clickOnLoginButton();
        //companiesMarinaPage.waitForCompanyLoaded(NAME_COMPANY);// - it doesn't work (with dynamic element)
        companiesMarinaPage.waitForCompanyLoadedByName(NAME_COMPANY)
                        .isCompanyOnCompaniesPage("Tadiran");

        Assert.assertTrue(companiesMarinaPage.isCompanyOnCompaniesPage("Tadiran"),"Not passed. User is not on companies page");


    }

}
