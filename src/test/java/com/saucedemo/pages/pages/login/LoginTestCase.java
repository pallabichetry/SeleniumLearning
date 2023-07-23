package com.saucedemo.pages.pages.login;

import com.saucedemo.pages.base.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import com.saucedemo.pages.driver.DriverManager;

public class LoginTestCase {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = DriverManager.getDriver();

    }

    @Test()
    public void TC1_login_with_valid_username_valid_pwd() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce" );
        System.out.println("Test case 1 is executed successfully");
    }

    @Test()
    public void TC2_login_with_invalid_username_valid_pwd() throws InterruptedException {
        System.out.println("TC2_login_with_valid_username_and_invalid_pwd started");
        Thread.sleep(3000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard", "secret_sauce");
        Thread.sleep(3000);
        loginPage.checkErrorMsg("Epic sadface: Username and password do not match any user in this service");
        System.out.println("Test case 2 is executed successfully");
    }

    @Test()
    public void TC3_login_with_invalid_username_invalid_pwd() throws InterruptedException {
        System.out.println("TC3_login_with_invalid_username_and_invalid_pwd started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid-username", "invalid-pwd");
        loginPage.checkErrorMsg("Epic sadface: Username and password do not match any user in this service");
        System.out.println("Test case 3 is executed successfully");
    }

    @Test
    public void TC4_login_with_empty_username_valid_pwd() throws InterruptedException {

        System.out.println("TC4_login_with_empty_username_and_invalid_pwd started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "secret_sauce");
        loginPage.checkErrorMsg("Epic sadface: Username is required");
        System.out.println("TC4_login_with_empty_username_and_invalid_pwd executed successfully");
    }

    @Test()
    public void TC5_login_with_valid_username_empty_pwd() throws InterruptedException {
        System.out.println("TC5_login_with_valid_username_and_empty_pwd started");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","");
        loginPage.checkErrorMsg("Epic sadface: Password is required");
        System.out.println("TC5_login_with_valid_username_and_empty_pwd executed successfully");
    }

    @AfterTest
    public void afterTest(){

        driver.close();
        driver.quit();
    }

}
