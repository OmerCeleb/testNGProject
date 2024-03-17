package myapp.tests.medunna_practice;

import myapp.pages.Medunna_HomePage;
import myapp.pages.Medunna_RegistrationPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day21_US001 {

    Medunna_HomePage medunnaHomePage = new Medunna_HomePage();
    Medunna_RegistrationPage medunnaRegistrationPage = new Medunna_RegistrationPage();


    @BeforeTest
    public void setUp() {
//        Driver.getDriver().get("https://www.medunna.com/");
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
        medunnaHomePage.userIcon.click();
        WaitUtils.waitFor(2);
        medunnaHomePage.registerOption.click();
//        BrowserUtils.clickWithTimeOut(medunnaHomePage.userIcon, 2);
//        BrowserUtils.clickWithTimeOut(medunnaHomePage.registerOption, 2);

    }


    @Test
    public void medunnaTest1() {

        medunnaRegistrationPage.ssn.sendKeys("22255-5432", Keys.TAB);

        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);

        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-5432", Keys.TAB);

        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);


        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-54-543", Keys.TAB);

        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);


        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-54-543a", Keys.TAB);

        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);


        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-54-5432", Keys.TAB);

        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.invalidSsnMessage);

    }

    @Test
    public void medunnaTest2() {

        medunnaRegistrationPage.ssn.click();
        WaitUtils.waitFor(1);
        medunnaRegistrationPage.ssn.sendKeys(Keys.TAB);
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.ssnRequiredMessage);
        WaitUtils.waitFor(1);

    }


}