package myapp.tests.extentreport;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_AdminLogin {

    /*
    ADD EXTENT REPORT CAPABILITY
    1. use createTestReport(String name, String description) first for creating extent report for this test
    2. Then use all methods to log the information on the extent report e.g. pass, info, fail etc.
    3.
     */

    BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();

    BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();

    @Test
    public void blueRentalLoginTest() {

        // 1.
        ExtentReportUtils.createTestReport("Smoke Test Report", "Login Function");

        // 2.
        ExtentReportUtils.info("User is logging on to https://www.bluerentalcars.com/");


//    Given user is on the application home page  https://www.bluerentalcars.com/

        Driver.getDriver().get(ConfigReader.getProperty("bluerental_url"));  // Dynamic way

//    Then clicks on login link

        BrowserUtils.clickWithTimeOut(blueRentalHomePage.userIcon, 1); // Dynamic way
        // 2.
        ExtentReportUtils.pass("User clicks on Login icon");

//    Then enters admin email, password

        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.email, ConfigReader.getProperty("bluerental_email"), 2);
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.password, ConfigReader.getProperty("bluerental_password"), 2);

        // 2.
        ExtentReportUtils.pass("User is entered email and password succesfully!");
//    Then click on login button

        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton, 1);

        // 2.
        ExtentReportUtils.pass("User clicked on log in button successfully");

//    Then verify the login is successful
        Assert.assertTrue(blueRentalLoginPage.dropDown.isDisplayed());
//    2.
        ExtentReportUtils.passAndCaptureScreenshot("User has logged in successfully");


//        Then logout and verify logout is successful
//        First we need to click on dropdown, so we can see logout option
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.dropDown, 2);


//        Then we click on logout

        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.logoutOption, 2);
        WaitUtils.waitFor(3);

        // 2.
        ExtentReportUtils.info("User clicked on logout option");

        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.okOption, 2);


//        verify logout is successful
        WaitUtils.waitFor(2);
        BrowserUtils.verifyElementDisplayed(blueRentalHomePage.userIcon);

        // 2.
        ExtentReportUtils.passAndCaptureScreenshot("Logout is successful");

//        Close the driver
        Driver.closeDriver();

        // 2.
        ExtentReportUtils.info("Driver is closed");

    }
}