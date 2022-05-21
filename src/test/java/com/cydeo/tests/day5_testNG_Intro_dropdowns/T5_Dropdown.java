package com.cydeo.tests.day5_testNG_Intro_dropdowns;

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

public class T5_Dropdown {

    //TC #5: Selecting state from State dropdown and verifying result
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void testStateDropdown(){

        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois
        selectState.selectByIndex(13);
        ReviewUtils.staticWait(1);

        //4. Select Virginia
        selectState.selectByValue("VA");
        ReviewUtils.staticWait(1);

        //5. Select California
        selectState.selectByVisibleText("California");
        ReviewUtils.staticWait(1);

        //6. Verify final selected option is California.
        String expected = "California";
        String actual = selectState.getFirstSelectedOption().getText();
        Assert.assertEquals(expected, actual);

        //Use all Select options. (visible text, value, index)
    }


}
