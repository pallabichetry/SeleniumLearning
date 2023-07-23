package com.saucedemo.pages.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver = null ;

    public static WebDriver getDriver(){
        if(driver == null ){
            return new ChromeDriver();
        }

        return driver;
    }
}
