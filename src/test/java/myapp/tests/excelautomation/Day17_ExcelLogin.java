package myapp.tests.excelautomation;

import myapp.pages.DataTablesPage;
import myapp.utilities.Driver;
import myapp.utilities.ExcelUtils;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day17_ExcelLogin {

//    When user go to https://editor.datatables.net/
//    Click on the new button
//    When user enters all fields
//    When user clicks on ‘create’ button
//    And search for the first name
//    Then verify the name field contains firstname

    DataTablesPage dataTablesPage;
    ExcelUtils excelUtils;

    List<Map<String, String>> datalist;   // Create an empty list and initialise it inside the test method TO STORE DATA from Excel sheet and use it for the test class

    //    WITHOUT EXCEL
    @Test
    public void loginTTest() {
        Driver.getDriver().get("https://editor.datatables.net/");

//    Click on the new button
        // Create the DataTablesPage object to access the elements
        DataTablesPage dataTablesPage = new DataTablesPage();

//    When user enters all fields
        dataTablesPage.newButton.click();
        WaitUtils.waitFor(1);
        dataTablesPage.firstName.sendKeys("john");
        WaitUtils.waitFor(1);
        dataTablesPage.lastName.sendKeys("lennon");
        WaitUtils.waitFor(1);
        dataTablesPage.position.sendKeys("musician");
        WaitUtils.waitFor(1);
        dataTablesPage.office.sendKeys("LA");
        WaitUtils.waitFor(1);
        dataTablesPage.extension.sendKeys("52345");
        WaitUtils.waitFor(1);
        dataTablesPage.startDate.sendKeys("2023-12-27");
        WaitUtils.waitFor(1);
        dataTablesPage.salary.sendKeys("1000000");
        WaitUtils.waitFor(1);

//    When user clicks on ‘create’ button
        dataTablesPage.createButton.click();
        WaitUtils.waitFor(1);

//    And search for the first name
        dataTablesPage.searchBox.sendKeys("john");
        WaitUtils.waitFor(1);

//    Then verify the name field contains firstname
        Assert.assertTrue(dataTablesPage.nameField.getText().contains("john"));

        Driver.closeDriver();

    }

    //       WITH EXCEL
    @Test
    public void loginTTestWithExcel() {

//     Path of the Excel sheet
        String pathOfExcel = "./resources/data_sheet.xlsx";
//     Initialise the ExcelUtils class here and provide the path of the sheet and name of the sheet in this object
        excelUtils = new ExcelUtils(pathOfExcel, "user_data");

// We get all data from Excel sheet through getDataList() Reusable method and
// store it in dataList that we created at the class level
        datalist = excelUtils.getDataList();

        // LOOP BEGINS
        for (Map<String, String> eachData : datalist) {

//    When user go to https://editor.datatables.net/
            Driver.getDriver().get("https://editor.datatables.net/");

//    Click on the new button
            // Create the DataTablesPage object to access the elements
            dataTablesPage = new DataTablesPage();

//    When user enters all fields
            dataTablesPage.newButton.click();
            WaitUtils.waitFor(1);
            dataTablesPage.firstName.sendKeys(eachData.get("first_name"));  // eachData container is a MAP so we can use get()
            WaitUtils.waitFor(1);
            dataTablesPage.lastName.sendKeys(eachData.get("last_name"));
            WaitUtils.waitFor(1);
            dataTablesPage.position.sendKeys(eachData.get("position"));
            WaitUtils.waitFor(1);
            dataTablesPage.office.sendKeys(eachData.get("office"));
            WaitUtils.waitFor(1);
            dataTablesPage.extension.sendKeys(eachData.get("extension"));
            WaitUtils.waitFor(1);
            dataTablesPage.startDate.sendKeys(eachData.get("start_date"));
            WaitUtils.waitFor(1);
            dataTablesPage.salary.sendKeys(eachData.get("salary"));
            WaitUtils.waitFor(1);

//    When user clicks on ‘create’ button
            dataTablesPage.createButton.click();
            WaitUtils.waitFor(1);

//    And search for the first name
            dataTablesPage.searchBox.sendKeys("first_name");
            WaitUtils.waitFor(1);

//    Then verify the name field contains firstname
//            Assert.assertTrue(dataTablesPage.nameField.getText().contains(eachData.get("first_name")));

        }

        //  LOOP END

        Driver.closeDriver();

    }

}
