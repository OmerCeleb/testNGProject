package myapp.tests.topics;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.annotations.Test;

public class Day16_BlueRental_Login {
    //    Given user is on the application home page  https://www.bluerentalcars.com/
//    Admin email: jack1@gmail.com
//    Admin password: 12345
//
//    Then clicks on login link
//    Then enters admin email, password
//    Then click on login button
//    Then verify the login is successful
    @Test
    public void blueRentalLoginTest() {
//    Given user is on the application home page  https://www.bluerentalcars.com/
//        Driver.getDriver().get("https://www.bluerentalcars.com/login");
        Driver.getDriver().get(ConfigReader.getProperty("bluerental_url"));  // Dynamic way

//    Then clicks on login link
//    To click on the login, we need to create object of the class where this element is store
        BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();

//        blueRentalHomePage.userIcon.click();
//        WaitUtils.waitFor(1);

        BrowserUtils.clickWithTimeOut(blueRentalHomePage.userIcon, 1); // Dynamic way

//    Then enters admin email, password
//    To click on the admin email, password, we need to create object of the class where these element are store
        BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();

//        blueRentalLoginPage.email.sendKeys("jack1@gmail.com");
//        blueRentalLoginPage.password.sendKeys("12345");


        //              OR

//        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.email, "jack1@gmail.com", 2);
//        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.password, "12345", 2);


        //              OR

        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.email, ConfigReader.getProperty("bluerental_email"), 2);
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.password, ConfigReader.getProperty("bluerental_password"), 2);


//    Then click on login button
//        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton, 2);
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton, 1);

//    Then verify the login is successful


    }
}