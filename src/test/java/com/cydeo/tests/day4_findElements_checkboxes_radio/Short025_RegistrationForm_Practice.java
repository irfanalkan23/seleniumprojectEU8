package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Short025_RegistrationForm_Practice {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/registration_form");

        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("irfan");

        WebElement lastName = driver.findElement(By.cssSelector("input[placeholder='last name']"));
        lastName.sendKeys("alkan");

        WebElement userName = driver.findElement(By.cssSelector("input[placeholder='username']"));
        userName.sendKeys("raffael");

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("123");

        WebElement genderMale = driver.findElement(By.cssSelector("input[value='male']"));
        genderMale.click();

        WebElement department = driver.findElement(By.cssSelector("select[name='department']"));
        Select departmentObj = new Select(department);
        departmentObj.selectByValue("DE");

        WebElement jobTitle = driver.findElement(By.cssSelector("select[name='job_title']"));
        Select jobTitleObj = new Select(department);
        departmentObj.selectByIndex(4);

        WebElement programmingLanguageJava = driver.findElement(By.cssSelector("#inlineCheckbox2"));
        programmingLanguageJava.click();

        WebElement signUpBtn = driver.findElement(By.cssSelector("#wooden_spoon"));
        signUpBtn.click();




    }
}
