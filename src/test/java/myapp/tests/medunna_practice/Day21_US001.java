package myapp.tests.medunna_practice;

import myapp.pages.Medunna_HomePage;
import myapp.pages.Medunna_RegistrationPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
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

        BrowserUtils.sendKeysWithTimeout(medunnaRegistrationPage.ssn, "22255-5432", 2);

        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);

    }


}
