package org.example.Driver;

import com.google.common.base.CaseFormat;
import org.example.Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;

public class DriverManager {
    public static WebDriver driver;

    // getter setter for driver below
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        // in setter can use switch to statement
        DriverManagerThreadLocal.driver = driver;
    }

    public static void initialize() {

        // Here we can use switch statement for each browser which you want to use
        String browser = null;
        try {
            browser = PropertyReader.readKey("browser");  // reading browser name from property Reader
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (driver == null) switch (browser) {
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                System.out.println("No Browser found");
        }
    }

        public static void down(){
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }

// we are using static functions and variables, so we don't want to create object of this class "Driver Manger" directly we can use them
//We are usually using static in WebDriver class, so we can use these static variable and functions without creating object