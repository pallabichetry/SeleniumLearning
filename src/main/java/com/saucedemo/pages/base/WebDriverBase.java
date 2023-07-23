package com.saucedemo.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class WebDriverBase {

    private static WebDriver driver;

//    public static WebDriver getDriver(String browser){
//
//        switch(BrowserTypeEnum.valueOf(browser)){
//            case CHROME:
//                driver = new ChromeDriver();
//                break;
//            case SAFARI:
//                driver = new SafariDriver();
//                break;
//            case FIREFOX:
//                driver = new FirefoxDriver();
//                break;
//        }
//
//        return driver;
//
//    }
}
