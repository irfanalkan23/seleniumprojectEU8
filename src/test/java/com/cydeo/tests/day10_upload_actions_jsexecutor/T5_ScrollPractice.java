package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T5_ScrollPractice {

    @Test
    public void scroll_practice_test(){
        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        //4- Scroll using Actions class “moveTo(element)” method
        WebElement poweredByCydeo = Driver.getDriver().findElement(By.xpath("//div[text()='Powered by ']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(poweredByCydeo).perform();

        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[text()='Home']"));
        actions.moveToElement(homeLink).perform();
    }
}
