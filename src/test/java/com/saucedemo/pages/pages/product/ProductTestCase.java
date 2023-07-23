package com.saucedemo.pages.pages.product;

import com.saucedemo.pages.driver.DriverManager;
import com.saucedemo.pages.pages.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class ProductTestCase {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = DriverManager.getDriver();

    }

    @Test(enabled = false)
    public void TC1AddToCartBackPack() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductPage productPage =new ProductPage(driver);

        WebElement addToCartBackpackElement = productPage.getAddToCart(By.xpath("//div[@class='pricebar']//child::button"));

        //WebElement addToCartBikeLightElement = productPage.getAddToCart(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button"));
        addToCartBackpackElement.click();
        Thread.sleep(3000);
        //addToCartBikeLightElement.click();
        WebElement removeButtonElement = productPage.getElement(By.xpath("//button[@class='btn_secondary btn_inventory']"));
        //removeButtonElement.click();
        String expectedResult = "REMOVE";
        String actualResult = removeButtonElement.getText();

        Assert.assertEquals(actualResult,expectedResult);

        Thread.sleep(3000);
    }

    @Test(enabled = false)
    public void TC1SortingWithDescendingPrice() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(3000);
        ProductPage productPage =new ProductPage(driver);
        productPage.sorting("Price (high to low)");
        Thread.sleep(3000);
        productPage.checkDescendingOrderOfProductList();
    }

    @Test(enabled = false)
    public void TC2SortingWithAscendingPrice() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(3000);
        ProductPage productPage =new ProductPage(driver);
        productPage.sorting("Price (low to high)");
        Thread.sleep(3000);
        productPage.checkAscendingOrderOfProductList();
    }

    @Test
    public void TC1CheckNotification() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(3000);
        ProductPage productPage =new ProductPage(driver);
        WebElement addToCartBackpackElement = productPage.getAddToCart(By.xpath("//div[@class='pricebar']//child::button"));
        addToCartBackpackElement.click();
//        WebElement addToCartBikeLightElement = productPage.getAddToCart(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button"));
//        addToCartBikeLightElement.click();
        productPage.checkNotification("1");
    }

    @AfterTest(enabled = true)
    public void afterTest(){

        driver.close();
        driver.quit();
    }

}
