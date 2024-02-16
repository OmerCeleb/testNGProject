package myapp.tests.topics;

import org.testng.annotations.*;

public class Day14_Annotations {

    /*
    @Test: is the most used annotation to create test cases - just like JUnit
    @Before and @After annotations: there are 5 before and after annotations

    Hierarchy: suite > class > group > test > method  ... this provides better control on test flow

    @Ignore: used to ignore / skip a test
    @Test (enabled = false) : disables the test :  another way of ignoring the test method (this one is stronger)

    By default, tests run from top to bottom ... following ascending / alphabetical order
    So if we want to run any particular test first, we have to mention priority that test case
    @Test(priority = 3) will run this test case at number 3
    We can also use negative numbers; but that's not common and recommended

    We can also group test together by passing group = "name of the group" in @Test parameter to run all tests under one group

     */

    @BeforeSuite
    public void beforeSuit() {
        System.out.println("Before suite ....");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before groups ...");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class ...");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test ...");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method ...");
    }


    @AfterSuite
    public void afterSuit() {
        System.out.println("After suit ...");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("After groups ...");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class ...");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test ...");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method ...");
    }


    @Test(priority = 2, groups = "Smoke Test")
    public void test1() {

        System.out.println("Test case 1...");

    }

    @Test
    @Ignore
    public void test2() {

        System.out.println("Test case 2...");

    }

    @Test(enabled = false)
    public void test3() {

        System.out.println("Test case 3...");

    }

    @Test(priority = 3)
    public void test4() {

        System.out.println("Test case 4...");

    }

    @Test(priority = 1, groups = "Smoke Test")
    public void test5() {

        System.out.println("Test case 5...");

    }

}
