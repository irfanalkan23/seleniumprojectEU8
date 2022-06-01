package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Config_Practice {

    public WebDriver driver;

    //TC #4: Google search
    //1- Open a chrome browser
    //2- Go to: https://google.com
    //3- Write “apple” in search box
    //4- Verify title:
    //Expected: apple - Google Search
    //Use `configuration.properties` for the following:
    //1. The browser type
    //2. The URL
    //3. The search keyword
    //4. Make title verification dynamic. If search value changes, title
    //assertion should not fail.

    @BeforeMethod
    public void setupMethod(){

        //Get the browserType dynamically from the configuration.properties file
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
    }

    @Test
    public void google_search_test(){

        //3- Write “apple” in search box
        WebElement googleSearchBox = driver.findElement(By.xpath("//input[@name='q']"));

        googleSearchBox.sendKeys("apple" + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Google Search
        String expectedTitle = "apple - Google Search";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }

}
