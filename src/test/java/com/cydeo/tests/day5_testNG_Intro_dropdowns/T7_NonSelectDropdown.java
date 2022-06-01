package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T7_NonSelectDropdown {

    WebDriver driver;

    //TC #7: Selecting value from non-select dropdown
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod(){
//        driver.close();
    }

    @Test
    public void test(){
        //3. Click to non-select dropdown
        WebElement nonSelectDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
//        WebElement nonSelectDropdown = driver.findElement(By.className("btn btn-secondary dropdown-toggle"));
        nonSelectDropdown.click();

        //4. Select Facebook from dropdown
//        Select select = new Select(driver.findElement(By.xpath("//a[text()='Facebook']")));
        driver.findElement(By.xpath("//a[text()='Facebook']")).click();

        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(actualTitle, expectedTitle);

    }

}
