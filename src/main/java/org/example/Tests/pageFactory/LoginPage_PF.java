package org.example.Tests.pageFactory;

import org.example.Base.CommonToAllPage;
import org.example.Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage_PF extends CommonToAllPage { // single inheritance

    WebDriver driver;

    public LoginPage_PF(WebDriver driver) {
        PageFactory.initElements(driver,this);  // page factory will initialize all the element
    }
    //Page Locators
    @FindBy(id ="login-username")
    private WebElement username;

    @FindBy(id ="login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private  WebElement signButton;

    @FindBy(id = "js-notification-box-msg")
    private WebElement error_message;

    //Page Actions
    public String loginToVWOInvalidCreds() throws InterruptedException, IOException {

       enterInput(username, PropertyReader.readKey("invalid_username"));   //using property Reader
       //enterInput(username, "admin@123");
       enterInput(password,PropertyReader.readKey("invalid_password"));  //using property Reader
       //enterInput(password, "pass123")
       clickElement(signButton);
        Thread.sleep(3000);

        return error_message.getText();
    }
}
