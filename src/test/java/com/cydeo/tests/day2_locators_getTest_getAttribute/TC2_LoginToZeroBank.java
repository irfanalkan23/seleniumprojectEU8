package com.cydeo.tests.day2_locators_getTest_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_LoginToZeroBank {

    public static void main(String[] args) {
        //TC #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”
//        WebElement headerText = driver.findElement(By.className("page-header"));  //also works
        WebElement headerText = driver.findElement(By.tagName("h3"));
        String currentHeaderText = headerText.getText();
        String expectedHeaderText = "Log in to ZeroBank";

        if(currentHeaderText.equals(expectedHeaderText)){
            System.out.println("Log in to ZeroBank title verification PASSED!");
        } else {
            System.out.println("Log in to ZeroBank title verification FAILED!!!");
        }

        driver.close();
    }
}
