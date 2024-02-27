package myapp.tests.dataprovider;

import myapp.utilities.DataProviderUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day17_DataProvider1 {

//      DataProvider Method works with 20 Array
//      We don't need TO LOOP to pass all data sets...
//      DataProvider annotation ensures that all data sets are provided to test method one by one

    // DataProvider method 1
    @DataProvider
    public Object[][] productListProvider() {

        Object[][] productList = {{"BMW"}, {"Volvo"}, {"Toyota"}, {"Tesla"}, {"Mercedes"}};
        return productList;

    }

    // Test Method 1
    @Test(dataProvider = "productListProvider")
    // call the DataProvider Method by it name and connect with the test method
    public void test1(String data) {
        System.out.println(data);


    }

    // DataProvider Method 2
    @DataProvider(name = "employee_credentials")
    // You can also give a customised name to @DataProvider and use that to connect with Test method
    public Object[][] credentialProvider() {
        Object[][] credentialList = {
                {"admin1", "pass1", "QA", "52"},
                {"admin2", "pass2", "SDET", "45"},
                {"admin3", "pass3", "PM", "38"},
                {"admin4", "pass4", "QA", "30"}
        };
        return credentialList;
    }


    // Test method 2
    @Test(dataProvider = "credentialProvider")
    public void test2(String username, String password, String title, String age) {
        System.out.println("UserName " + username + "Password " + password + "Title " + title + "Age " + age);
    }


    // Test method 3
    @Test(dataProvider = "employee_credentials")
    public void test3(String username, String password, String title, String age) {
        System.out.println("UserName " + username + "Password " + password + "Title " + title + "Age " + age);
    }

    // NOTE: We should write DataProvider methods in UTILS class to implement DRY Rule (Don't Repeat Yourself)
    // When DataProvider methods are stored in a different class (like in UTILS class), we have to provide the Name of that class too


    // Test method 4 => works with DataProviderUtils class
    @Test(dataProvider = "employeeCredentialsProvider", dataProviderClass = DataProviderUtils.class)
    public void test4(String email, String password) {
        System.out.println("email = " + email + "password = " + password);

    }

    // Test method 5 => works with DataProviderUtils class
    @Test(dataProvider = "employeeCredentialsProvider", dataProviderClass = DataProviderUtils.class)
    public void test5(String email, String password) {
        System.out.println("email = " + email + "password = " + password);

    }


}
