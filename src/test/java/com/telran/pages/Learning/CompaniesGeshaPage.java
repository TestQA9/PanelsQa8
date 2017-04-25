package com.telran.pages.Learning;

import com.telran.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by G_Lab on 2/11/2017.
 */
public class CompaniesGeshaPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;

    @FindBy(id = "managementList")
    public WebElement managementButton;

    @FindBy(xpath = "//*[for='managementList']")
    public WebElement managementList;

    @FindBy(id = "surveysList")
    public WebElement surveysButton;

    @FindBy(xpath = "//*[for='surveysList']")
    public WebElement surveysList;

    @FindBy(id = "reportsList")
    public WebElement reportsButton;

    @FindBy(xpath = "//*[for='reportsList']")
    public WebElement reportsList;

    @FindBy(id = "alertsBtn")
    public WebElement alertButton;

    @FindBy(id = "quit")
    public WebElement logoutButton;

    //ElementsBlock for wait method
    @FindBy(xpath = "//*[@class='adminMenu']")
    public WebElement adminMenuBlock;
    //tadiranProjectButton
    @FindBy(xpath = "//*[contains(@style,'tadiran')]/..//a")
    public WebElement tadiranbyNameProjectButton;
    @FindBy(xpath = "//*[@class='mdl-grid']/div[1]//a")
    public WebElement tadiranProjectButton;
    //diklaProjectButton
    @FindBy(xpath = "//*[@class='mdl-grid']/div[2]//a")
    public WebElement clalitProjectButton;
    //clalitProjectButton
    @FindBy(xpath = "//*[@class='mdl-grid']/div[3]//a")
    public WebElement diklaProjectButton;
    @FindBy(xpath = "//select[@ng-model='selectedLanguage']")
    public WebElement selectLanguage;
    private boolean isOnCompaniesPage;


    public CompaniesGeshaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //methods

    public void waitForCompaniesPageInLoaded() {
        waitUntilIsLoadedCustomTime(tadiranProjectButton, 30);
    }

    public boolean isOnCompaniesPage() {
        return exists(tadiranProjectButton);
    }

    public void setOnCompaniesPage(boolean onCompaniesPage) {
        isOnCompaniesPage = onCompaniesPage;
    }

    public void clickManagementButton() {
        clickElement(managementButton);
    }

    public void selectValueInDropdownManagement(String value) {
        selectValueInDropdownbyText(managementList, value);
    }

    public void clickSurveysButton() {
        clickElement(surveysButton);
    }

    public void selectValueInDropdownSurveys(String value) {
        selectValueInDropdownbyText(surveysList, value);
    }

    public void clickReportsButton() {

        clickElement(reportsButton);
    }

    public void selectValueInDropdownReports(String value) {
        selectValueInDropdownbyText(reportsList, value);
    }

    public void clickAlertButton() {
        clickElement(alertButton);
    }

    public void clickTadiranProjectButton() {
        clickElement(tadiranProjectButton);
    }

    public void clickProjectButtonbyName(String company) {
        String s = "//h2[contains(Text(),'" + company + "')]/../..//a";
        driver.findElement(By.xpath(s)).click();

    }

    public void clickClalitProjectButton() {
        clickElement(clalitProjectButton);
    }

    public void clickDiclaProjectButton() {
        clickElement(diklaProjectButton);
    }

    public void selectEnglishLanguage() {
        selectValueInDropdownbyText(selectLanguage, "English");
    }

    public void selecthebrewLanguage() {
        selectValueInDropdownbyText(selectLanguage, "עברית");
    }
}
