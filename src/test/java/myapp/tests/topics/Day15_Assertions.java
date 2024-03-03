package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class Day15_Assertions {

    /*

    In JUnit, we had only HARD ASSERTION
    In TestNG, we have two types of Assertions ==> Hard and Soft
    HARD ASSERTION works the same in TestNG as it works in JUnit. it stops executing rest of the test
    if assertion fails at any point. We get the error message / exception straight away

    SOFT ASSERTION is different in a sense that it doesn't stop executing the test if it at fails at any point
    It continues executing the test and informs in the end which step the test failed at. Only IF WE USE assertAll() is
    mandatory last step.

     */

    @Test
    public void assertionsTest() {

        System.out.println("Checking how hard assertion works");
        assertTrue(true); // passes
        System.out.println("Line 17");
        assertTrue(false); // fails at this point... so the rest of the test is not executed
        System.out.println("Line 19");

    }

    @Test (groups = "minor_regression_group")
    public void javaAssert() {

        /*
        This comes from Java Library. It works the same way as HARD ASSERTION
        But we (testers) prefer TestNG assertions, specially HARD ASSERTION
         */

        System.out.println("Line 42");
        assert 3 < 5;
        System.out.println("Line 44");
        assert "Apple".toLowerCase().contains("c");
        System.out.println("Line 46");
        assert "apple" == "apple";
        System.out.println("Line 48");

    }

    @Test
    public void softAssert() {

        /*
        If Soft Assertion fails at any step. it continues to execute the test steps
        1. Create Soft Assertion object
        2. Use the Soft Assertion method such as assertEquals(), assertTrue() etc.
        3. Use assertAll() as a last step, otherwise you cannot find out where if the test step failed
         */

        System.out.println("Line 63");
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals("5", 5);
        System.out.println("Line 67");
        softAssert.assertTrue("Apple".toLowerCase().contains("a"));
        System.out.println("Line 69");
        softAssert.assertTrue("apple".equals("orange"));
        System.out.println("Line 71");

        softAssert.assertEquals("pineapple", "grapes");
        System.out.println("Line 74");
        softAssert.assertAll();

    }

}
