package com.saucedemo.pages.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
   WebDriver driver;
   private String username = "user-name";
   private String password = "password";
   private String loginButton = "login-button";
    String errorMsg = "//*[@id=\"login_button_container\"]/div/form/h3";
    String errorMsg1 = "//*[@id=\"login_button_container\"]/div/form/h3";


    public LoginPage(WebDriver driver){
       this.driver = driver;
    }

    // creating login method
    public void login(String usernameParam, String passwordParam) throws InterruptedException {

        // to get the web page
        driver.get("https://www.saucedemo.com/v1/");
        // to maximize the screen
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // locating the web-element
        WebElement usernameElement = driver.findElement(By.id(username));
        WebElement passwordElement = driver.findElement(By.id(password));
        WebElement loginButtonElement = driver.findElement(By.id(loginButton));

        // sending the inputs
        usernameElement.sendKeys(usernameParam);
        passwordElement.sendKeys(passwordParam);

        // button click action
        loginButtonElement.click();


        Thread.sleep(3000);

    }

    public void checkErrorMsg(String expectedMsg){
        WebElement errMsg = driver.findElement(By.xpath(errorMsg));
        String actualMsg = errMsg.getText();
        if (actualMsg.equals(expectedMsg)) {
            System.out.println("Unable to login because of invalid username/pwd");
        } else {
            System.out.println(actualMsg);
            System.out.println("Incorrect msg");
        }
    }






    public void closeBrowser() {
        driver.close();
        driver.quit();
    }



}
