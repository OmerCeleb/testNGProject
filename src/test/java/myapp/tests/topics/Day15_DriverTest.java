package myapp.tests.topics;

import myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_DriverTest {

    @Test
    public void driverTest() throws InterruptedException {

        //    driver.get("https://www.amazon.se"); We were calling driver from TestBase class in JUnit framework

        Driver.getDriver().get("https://www.amazon.se");
        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh(); // to get rid of captcha

        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        Assert.assertTrue(title.contains("Amazon.se"));

        // To close the driver
        Driver.closeDriver();


    }

}
