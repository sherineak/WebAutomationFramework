package org.example.Tests;

import org.example.Tests.pageFactory.LoginPage_PF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class TestVWOLogin_PF {
    @Test
    public void testLoginNegativeVWO() throws InterruptedException, IOException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        LoginPage_PF loginPagePF = new LoginPage_PF(driver);
        String error_message = loginPagePF.loginToVWOInvalidCreds();
        Assert.assertEquals(error_message,"Your email, password, IP address or location did not match");
        driver.quit();

    }


}
