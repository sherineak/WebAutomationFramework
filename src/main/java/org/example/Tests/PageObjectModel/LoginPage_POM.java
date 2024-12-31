package org.example.Tests.PageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPage_POM {



    //Contains
    //Page locators
    // Default constructor
    WebDriver driver;
    public LoginPage_POM(WebDriver driver){
        this.driver = driver;

    }
    // private for - encapsulation
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By sign_button = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    //page Actions
    //Login Page Actions
    public String loginToVWOInvalidCreds(String user, String pwd){
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(sign_button).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.id("js-notification-box-msg"));
        String error_msg_text = error_msg.getText();
        return error_msg_text;

        // Here is no assertion
    }

}
