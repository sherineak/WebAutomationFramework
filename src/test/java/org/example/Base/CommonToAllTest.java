package org.example.Base;

import org.example.Driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {
    // To Call the Start the WebDriver
    //Down the WebDiver
    //Start WebDriver start

    @BeforeMethod
    public void setup() {
        DriverManager.initialize();
    }
    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }

}
