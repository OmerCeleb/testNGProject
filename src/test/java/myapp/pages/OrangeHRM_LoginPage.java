package myapp.pages;

import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_LoginPage {

    /*
    1- Create constructor and use PageFactory class in it to initialise the page objects.
    2- Locate the webElements using @FindBy, so we can call them in Test classes.

     Trafitional / jUnit way => WebElement userName = driver.findElement(By.id())
     In TestNG => @FindBy(using = "any locator") public WebElement userName;
     */

    public OrangeHRM_LoginPage() {  // Constructor
        PageFactory.initElements(Driver.getDriver(), this);

    }

    //Username
    @FindBy(name = "username")
    public WebElement userName;

    //Password
    @FindBy(name = "password")
    public WebElement password;

    //LoginButton
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;


    // Reusable method for Page Specific Function
    public void login(String userId, String pass) {
        userName.sendKeys(userId);
        WaitUtils.waitFor(2); // Hard Wait
        password.sendKeys(pass);
        WaitUtils.waitFor(2); // Hard Wait
        loginButton.click();
        WaitUtils.waitFor(2); // Hard Wait


    }


}
