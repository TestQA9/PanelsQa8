package com.telran.pages.Learning;


import com.telran.LogLog4j;
import com.telran.pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ProjectSurveysMarinaPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;
    @FindBy(xpath = "//h2[contains(text(),'" + "Tadiran" + "')]/../..//a")
    public WebElement projectButtonTadiran;

    public ProjectSurveysMarinaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //method
    public ProjectSurveysMarinaPage waitForFirstProjectIsLoaded(){
        Log.info("Waiting for header is loading");
        //waitAndFindWebElement(By.xpath(LIST_PROJECT_LOCATOR+"[1]"));
        //здесь путанница с делением на элементы и что называется страницей
        return this;
    }
}
