package myapp.tests.smoketest;

import myapp.pages.OrangeHRM_DashboardPage;
import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_OrangeHRM_Login {

//    Automate login functionality, using page object model
//    https://opensource-demo.orangehrmlive.com/web/index.php/auth/login


    @Test
    public void loginTest() {

//    Given user is the application login page
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//    Then enter the credentials
//      Inorder to access the webElements, we need to create the Page object
        OrangeHRM_LoginPage orangeHRMLoginPage = new OrangeHRM_LoginPage();

//        orangeHRMLoginPage.userName.sendKeys("Admin");
//        WaitUtils.waitFor(2); // Hard Wait
//        orangeHRMLoginPage.password.sendKeys("admin123");
//        WaitUtils.waitFor(2); // Hard Wait
//        orangeHRMLoginPage.loginButton.click();
//        WaitUtils.waitFor(2); // Hard Wait

//      Or Use REUSABLE method
        orangeHRMLoginPage.login("Admin", "admin123");

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

}
