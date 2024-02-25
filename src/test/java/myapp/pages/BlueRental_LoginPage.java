package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueRental_LoginPage {

    // 1. Create constructor and use PageFactory class to initialize the object of this class
    // 2. Locate elements using @FindBy annotation


    public BlueRental_LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "formBasicEmail")
    public WebElement email;

    @FindBy(id = "formBasicPassword")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

}
