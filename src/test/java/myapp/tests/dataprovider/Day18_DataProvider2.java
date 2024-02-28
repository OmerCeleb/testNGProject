package myapp.tests.dataprovider;

import myapp.pages.DataTablesPage;
import myapp.utilities.DataProviderUtils;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day18_DataProvider2 {

    /*
    PLAN:
        1- Create a data provider method in Utils class that will take the data from user_data sheet.
        2- Connect the data provider method to the test method using two parameters =>  dataProvider and dataProviderClass
        3- Complete your test case
     */

    DataTablesPage dataTablesPage; // Create the page object here but initiate it inside the test method.


    @Test(dataProvider = "userData", dataProviderClass = DataProviderUtils.class)
    public void userCreationWithDataProvider(
            String firstName,
            String lastName,
            String position,
            String office,
            String extension,
            String startDate,
            String salary) {

//    When user go to https://editor.datatables.net/
        Driver.getDriver().get("https://editor.datatables.net/");

//    Click on the new button
        // Initialise DataTablesPage object to access the elements
        dataTablesPage = new DataTablesPage();

//    When user enters all fields
        dataTablesPage.newButton.click();
        WaitUtils.waitFor(1);
        dataTablesPage.firstName.sendKeys(firstName);
        WaitUtils.waitFor(1);
        dataTablesPage.lastName.sendKeys(lastName);
        WaitUtils.waitFor(1);
        dataTablesPage.position.sendKeys(position);
        WaitUtils.waitFor(1);
        dataTablesPage.office.sendKeys(office);
        WaitUtils.waitFor(1);
        dataTablesPage.extension.sendKeys(extension);
        WaitUtils.waitFor(1);
        dataTablesPage.startDate.sendKeys(startDate);
        WaitUtils.waitFor(1);
        dataTablesPage.salary.sendKeys(salary);
        WaitUtils.waitFor(1);

//    When user clicks on ‘create’ button
        dataTablesPage.createButton.click();
        WaitUtils.waitFor(1);

//    And search for the first name
        dataTablesPage.searchBox.sendKeys(firstName);
        WaitUtils.waitFor(1);

//    Then verify the name field contains firstname
        Assert.assertTrue(dataTablesPage.nameField.getText().contains(firstName));

        Driver.closeDriver();

    }

}
