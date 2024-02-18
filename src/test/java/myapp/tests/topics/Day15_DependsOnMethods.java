package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_DependsOnMethods {

    // DependsOnMethods parameter is used to make test dependent on each other
    // if the test (on which other tests are dependent) fails,  the tower tests will be skipped




    @Test
    public void homePageTest() {
        System.out.println("Home page test...");


    }


    @Test(dependsOnMethods = "homePageTest")
    public void searchTest() {
        System.out.println("Searching something ...");
        Assert.assertTrue(false);  // test fails at this step

    }

    @Test(dependsOnMethods = "searchTest")
    public void checkOutTest() {
        System.out.println("User is checking out...");
    }


}
