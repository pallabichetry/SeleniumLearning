package com.saucedemo.pages.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class ProductPage {


    WebDriver driver;

    String priceLocator = "//div[@class = 'pricebar']/div[@class='inventory_item_price']";
    String notificationLocator = "//span[@class='fa-layers-counter shopping_cart_badge']";

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // this method will return webElement based on the given locator
    public WebElement getElement(By by){
       return driver.findElement(by);
    }

    public WebElement getAddToCart(By by) {
        return getElement(by);
    }

    public void sorting(String type) {
        WebElement sortingElement = getElement(By.className("product_sort_container"));
        sortingElement.click();
        WebElement optionElement = getElement(By.xpath("//option[text()='" + type + "']"));
        optionElement.click();

    }
    public void checkAscendingOrderOfProductList(){
       List<WebElement> priceList = driver.findElements(By.xpath(priceLocator));
       for(int index=0; index<priceList.size()-1; index++){
           WebElement currentElement = priceList.get(index);
           float firstNumber = formatPrice(currentElement.getText());
           float secondNumber = formatPrice(priceList.get(index+1).getText());
           System.out.println(String.valueOf(firstNumber) + "-" + String.valueOf(secondNumber));
           Assert.assertTrue(firstNumber <= secondNumber);
       }

    }

    public void checkDescendingOrderOfProductList(){
        List<WebElement> priceList = driver.findElements(By.xpath(priceLocator));
        for(int index=0; index<priceList.size()-1; index++){
            WebElement currentElement = priceList.get(index);
            float firstNumber = formatPrice(currentElement.getText());
            float secondNumber = formatPrice(priceList.get(index+1).getText());
            System.out.println(String.valueOf(firstNumber) + "-" + String.valueOf(secondNumber));
            Assert.assertTrue(firstNumber >= secondNumber);
        }

    }


    private float formatPrice(String price){
        price = price.replace("$","");
        return Float.valueOf(price);
    }

    public void checkNotification(String expectedResult){
        WebElement notificationElement = getElement(By.xpath(notificationLocator));
        String actualResult = notificationElement.getText();
        System.out.println("Number of items in cart ::" + actualResult);
        Assert.assertEquals(actualResult,expectedResult);

    }


}

