package myapp.tests.medunna_practice;

import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day21_US001 {


    @BeforeTest
    public void setUp() {
//        Driver.getDriver().get("https://www.medunna.com/");
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
    }

    @Test
    public void medunnaTest() {


    }


}
