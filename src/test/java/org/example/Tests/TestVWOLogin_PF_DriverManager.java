package org.example.Tests;

import org.assertj.core.api.Assertions;
import org.example.Base.CommonToAllTest;
import org.example.Tests.pageFactory.LoginPage_PF;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.example.Driver.DriverManager.driver;


public class TestVWOLogin_PF_DriverManager extends CommonToAllTest {
// Use load manager for logs

    //To get logs
private static final Logger LOGGER = Logger.getLogger("TestVWOLogin_PF_DriverManager.class");

    @Test
    public void testLoginNegativeVWO() throws InterruptedException, IOException {
        LOGGER.info("Starting Test");
        LoginPage_PF loginPagePF = new LoginPage_PF(driver);
        loginPagePF.openVWOLoginURL("qa");   // commonToAllPage
        LOGGER.info("Opening URL");
        String error_message = loginPagePF.loginToVWOInvalidCreds();
        LOGGER.info("Verifying the Result");
// There are different types of logs available LOGGER.--- , but most of the time using Info

        Assert.assertEquals(error_message,"Your email, password, IP address or location did not match");

        Assertions.assertThat(error_message).isNotNull().isNotBlank();
        driver.quit();

    }


}
