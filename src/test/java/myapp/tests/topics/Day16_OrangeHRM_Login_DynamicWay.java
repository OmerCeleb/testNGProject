package myapp.tests.topics;

import myapp.pages.OrangeHRM_DashboardPage;
import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_OrangeHRM_Login_DynamicWay {

//    Automate login functionality, using page object model
//    https://opensource-demo.orangehrmlive.com/web/index.php/auth/login


    @Test
    public void loginTestDynamic() {

//    Given user is the application login page
        Driver.getDriver().get(ConfigReader.getProperty("orangeHRM_url")); // Returns URL
//    Then enter the credentials
//      Inorder to access the webElements, we need to create the Page object
        OrangeHRM_LoginPage orangeHRMLoginPage = new OrangeHRM_LoginPage();

        orangeHRMLoginPage.userName.sendKeys(ConfigReader.getProperty("orangeHRM_username"));
        WaitUtils.waitFor(2); // Hard Wait
        orangeHRMLoginPage.password.sendKeys(ConfigReader.getProperty("orangeHRM_password"));
        WaitUtils.waitFor(2); // Hard Wait
        orangeHRMLoginPage.loginButton.click();
        WaitUtils.waitFor(2); // Hard Wait

//      Or Use REUSABLE method
        orangeHRMLoginPage.login(ConfigReader.getProperty("orangeHRM_username)"), ConfigReader.getProperty("orangeHRM_password"));

//    Then verify the login is successful
        // We need to create the object from OrangeHRM_DashboardPage to reach out to dropdown for verification purpose
        OrangeHRM_DashboardPage orangeHRMDashboardPage = new OrangeHRM_DashboardPage(); //Creating the object of the relevent page
        orangeHRMDashboardPage.dropDown.click();
        WaitUtils.waitFor(2); // Hard Wait

//    And logout the application
        orangeHRMDashboardPage.logout.click();

//    Then verify the logout is successful
        Assert.assertTrue(orangeHRMLoginPage.userName.isDisplayed());


//    Close the driver
        Driver.closeDriver();


    }

    @Test
    public void loginTestDynamic_ReusableMethods() {

//    Given user is the application login page
        Driver.getDriver().get(ConfigReader.getProperty("orangeHRM_url")); // Returns URL
//    Then enter the credentials
//      Inorder to access the webElements, we need to create the Page object
        OrangeHRM_LoginPage orangeHRMLoginPage = new OrangeHRM_LoginPage();


//      Or Use REUSABLE method from Page class
//        orangeHRMLoginPage.login(ConfigReader.getProperty("orangeHRM_username)"), ConfigReader.getProperty("orangeHRM_password"));

//      Recommended way => Use Reusable method from Util class
        BrowserUtils.sendKeysWithTimeout(orangeHRMLoginPage.userName, "Admin", 2);
//        BrowserUtils.sendKeysWithTimeout(orangeHRMLoginPage.userName, ConfigReader.getProperty("orangeHRM_username"), 2);
//        BrowserUtils.sendKeysWithTimeout(orangeHRMLoginPage.password, "admin123", 2);
        BrowserUtils.sendKeysWithTimeout(orangeHRMLoginPage.password, ConfigReader.getProperty("orangeHRM_password"), 2);

        BrowserUtils.clickWithTimeOut(orangeHRMLoginPage.loginButton, 1);

//    Then verify the login is successful
        // We need to create the object from OrangeHRM_DashboardPage to reach out to dropdown for verification purpose
        OrangeHRM_DashboardPage orangeHRMDashboardPage = new OrangeHRM_DashboardPage(); //Creating the object of the relevent page

        BrowserUtils.verifyElementDisplayed(orangeHRMDashboardPage.dropDown); // Using Reusable method from Util class

//    And logout the application
        BrowserUtils.clickWithTimeOut(orangeHRMDashboardPage.dropDown, 2);
        BrowserUtils.clickWithTimeOut(orangeHRMDashboardPage.logout, 2);


//    Then verify the logout is successful
        BrowserUtils.verifyElementDisplayed(orangeHRMLoginPage.userName);


//    Close the driver
        Driver.closeDriver();


    }

}
