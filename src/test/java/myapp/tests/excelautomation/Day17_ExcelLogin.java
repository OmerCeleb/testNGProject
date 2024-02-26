package myapp.tests.excelautomation;

import myapp.utilities.Driver;
import org.testng.annotations.Test;

public class Day17_ExcelLogin {

//    When user go to https://editor.datatables.net/
//    Click on the new button
//    When user enters all fields
//    When user clicks on ‘create’ button
//    And search for the first name
//    Then verify the name field contains firstname

    @Test
    public void loginTTest(){
        Driver.getDriver().get("https://editor.datatables.net/");
    }

}
