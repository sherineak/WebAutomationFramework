package org.example.Base;

import org.example.Driver.DriverManager;
import org.example.Utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.example.Driver.DriverManager.getDriver;

public class CommonToAllPage {
    // if you want to call something before every page object class call, put your code here
    //Open File, Open Data Base connection You can write code here


    public CommonToAllPage() {   // Generate Default constructor
    }
    public void openVWOLoginURL(String url) throws IOException {
        //driver.get
        //getDriver().get("https://app.vwo.com");  // As getDriver is a static function in DriverManger Class, we can call this function without creating object
        switch (url){
            case  "qa":
              getDriver().get(PropertyReader.readKey("qa_url")); // taking value from property Reader
              break;
            case "dev":
                getDriver().get(PropertyReader.readKey("url")); // taking value from property Reader
               break;
            default:
                getDriver().get(PropertyReader.readKey("url")); // taking value from property Reader
        }
    }
 // "By " supported by page object Model "WebElement" Supported by Page Factory

    public void clickElement(By by) {   // overloading concepts, same function name"clickElement" with different parameter
        getDriver().findElement(by).click();
    }
    //"WebElement " supported by PageFactory
    public void clickElement(WebElement by){  // overloading concepts, same function name"clickElement" with different parameter
        by.click();
    }
    public void enterInput(By by, String key){   // overloading concepts, same function name"clickElement" with different parameter
       getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement element, String key){   // overloading concepts, same function name"clickElement" with different parameter
        element.sendKeys(key);
    }
    // using these above 2 function(method overloading concepts in oops) for page Object Model and page factory)
    //Waits
    public WebElement presenceOfElement(By elementLocation){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }
    public WebElement visibilityOfElement(By elementLocation){
        return new WebDriverWait(getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }
    public WebElement getElement(By key){  //Page Object Model
        return  getDriver().findElement(key);
    }
    public WebElement getElement(WebElement element){ //Page Factory
        return element;
    }


}
