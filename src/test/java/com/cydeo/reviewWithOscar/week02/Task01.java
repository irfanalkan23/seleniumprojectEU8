package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task01 {

    public static void main(String[] args) {

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //        go to https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

        HandleWait.staticWait(1);

        //        then click on "forgot_password" link
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
        forgotPasswordLink.click();

        HandleWait.staticWait(1);

        //        enter any email
        WebElement emailBox = driver.findElement(By.name("email"));

        String expectedEmail = "abc@gmail.com";
        emailBox.sendKeys(expectedEmail);

        //        verify that email is displayed in the input box
//        String actualEmail = emailBox.getText();    //let's see if it works?
        // it doesn't work; because not in the text of the element,
        // it is at the 'value' attribute of the webElement
        String actualEmail = emailBox.getAttribute("value");

        System.out.println("actualEmail = " + actualEmail);

        if(actualEmail.equalsIgnoreCase(expectedEmail)){
            System.out.println("PASS email verification");
        } else {
            System.out.println("FAILED email verification");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }

        //        click on Retrieve password
//        driver.findElement(By.id("form_submit")).click();
//        driver.findElement(By.tagName("button")).click();
//        driver.findElement(By.tagName("//button")).click();
//        driver.findElement(By.cssSelector("#form_submit")).click();

        //use Retrieve word to locate with XPATH
        driver.findElement(By.xpath("//i[contains(text(),'Retrieve')]")).click();

        HandleWait.staticWait(1);

        //        verify that confirmation message says 'Your e-mail's been sent!'
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = driver.findElement(By.name("confirmation_message")).getText();

        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASSED message test!");
        } else {
            System.out.println("FAILED message test!");
        }

        driver.close();

    }
}
