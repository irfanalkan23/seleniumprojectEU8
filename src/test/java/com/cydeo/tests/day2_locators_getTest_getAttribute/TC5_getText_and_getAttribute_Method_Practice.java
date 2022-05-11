package com.cydeo.tests.day2_locators_getTest_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_getText_and_getAttribute_Method_Practice {

    public static void main(String[] args) {

        //TC #5: getText() and getAttribute() method practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        //3- Verify header text is as expected:
        //Expected: Registration form
        WebElement headerText = driver.findElement(By.className("page-header"));
        String actualHeaderText = headerText.getText();
        String expectedHeaderText = "Registration form";

        if(actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header text verification is PASSED!");
        } else {
            System.out.println("Header text verification is FAILED!!!");
        }

        //4- Locate “First name” input box
        WebElement inputFirstName = driver.findElement(By.name("firstname"));

        //5- Verify placeholder attribute’s value is as expected:
        //Expected: first name
        String actualInputFirstNamePlaceholder = inputFirstName.getAttribute("placeholder");
        String expectedInputFirstNamePlaceholder = "first name";

        if (actualInputFirstNamePlaceholder.equals(expectedInputFirstNamePlaceholder)){
            System.out.println("First name placeholder text verification PASSED!");
        } else {
            System.out.println("First name placeholder text verification FAILED!!!");
        }

        driver.close();

    }
}
