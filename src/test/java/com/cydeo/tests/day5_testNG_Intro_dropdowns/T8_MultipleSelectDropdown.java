package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8_MultipleSelectDropdown {

    WebDriver driver;

    //TC #8: Selecting value from multiple select dropdown
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
        driver.close();
    }

    @Test
    public void test(){
        //3. Select all the options from multiple select dropdown.
        Select select = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> languages = driver.findElements(By.xpath("//select[@name='Languages']//option"));
        for (WebElement eachLanguage : languages) {
            select.selectByVisibleText(eachLanguage.getText());
            ReviewUtils.staticWait(1);
        }
        ReviewUtils.staticWait(1);

        //4. Print out all selected values.
        for (WebElement eachLanguage : languages) {
            if (eachLanguage.isSelected()){
                System.out.println(eachLanguage.getText());
            }
        }
        ReviewUtils.staticWait(1);

        //5. Deselect all values.
        for (WebElement eachLanguage : languages) {
            select.deselectAll();
        }
        ReviewUtils.staticWait(1);
    }

}
