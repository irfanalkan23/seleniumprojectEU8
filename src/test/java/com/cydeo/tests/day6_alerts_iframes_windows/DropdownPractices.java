package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        //2. Go to http://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/dropdown");
    }

    @Test
    public void dropdown_task5(){
        //day5 TC #5: Selecting state from State dropdown and verifying result

        //locate the select dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //Use all Select options. (visible text, value, index)
        //3. Select Illinois
        ReviewUtils.staticWait(1);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia
        ReviewUtils.staticWait(1);
        stateDropdown.selectByValue("VA");

        //5. Select California
        ReviewUtils.staticWait(1);
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.
        String expectedOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOptionText, expectedOptionText);

    }

    @Test
    public void dropdown_task6(){
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        //3. Select “December 1st, 1923” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select year using : visible text
        ReviewUtils.staticWait(1);
        yearDropdown.selectByVisibleText("1923");

        //Select month using : value attribute
        ReviewUtils.staticWait(1);
        monthDropdown.selectByVisibleText("December");

        //Select day using : index number
        ReviewUtils.staticWait(1);
        dayDropdown.selectByVisibleText("1");

        //create assertions
        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear, expectedYear);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);

    }

    @AfterMethod
    public void teardownMethod(){
        driver.close();
    }


}
