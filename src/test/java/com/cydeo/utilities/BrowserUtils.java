package com.cydeo.utilities;

// In this class only general utility methods that are not related to some specific page

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    //Accept int (seconds) and execute Thread.sleep() for given duration
    public static void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    //Switch window and verify title (day7 TC2 explained at the bottom)
    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle){
        Set<String> allWindowsHandles = driver.getWindowHandles();
        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        //Assert: Title contains expectedInTitle
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    //Accept a String "expectedTitle" and Assert if it is true
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    //Creating a utility method for ExplicitWait so we don't have to repeat the lines
    public static void waitForInvisibilityOf(WebElement webElement){
//        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);     // turning off the Driver class implicitWait(10) to 0.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));

    }

}
/*
day7, TC #2: Create utility method
1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called, it should switch window and verify title.
Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
 */

// Why static? Because I don't wanna create object, just call the methdod via class name.