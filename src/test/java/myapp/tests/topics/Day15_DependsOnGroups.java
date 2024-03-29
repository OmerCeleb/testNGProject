package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_DependsOnGroups {


    @Test(dependsOnGroups = "Smoke Test")
    // groups keyboard is used to declare that this test belongs to a particular group
    public void homePageTest() {
        System.out.println("Home page test...");
        Assert.assertTrue(false);  // test fails at this step

    }


    @Test(groups = "Smoke Test")
    public void searchTest() {
        System.out.println("Searching something ...");
        Assert.assertTrue(false);  // test fails at this step

    }

    @Test(groups = "minor_regression_group")
    public void checkOutTest() {
        System.out.println("User is checking out...");
    }

    @Test(dependsOnGroups = "Smoke Test")
    public void logOutTest() {
        System.out.println("Logging out...");
    }

    // logOutTest is dependent on the group called "Smoke Test", if all tests belonging to this group pass, logOutTest will pass to
    // otherwise it will be skipped


}
