package com.cydeo.reviewWithOscar.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToDemoBlaze {

    public static void main(String[] args) {

        // https://www.demoblaze.com/
        // verify Title "STORE"

        WebDriverManager.chromedriver().setup();    // setting the taxi driver
        // WebDriverManager comes from bonigarcia.

        WebDriver driver = new ChromeDriver();      // the car itself
        // there is polymorphism:
        // WebDriver is interface (comes from selenium library)
        // ChromeDriver is the concrete class

        driver.get("https://www.demoblaze.com/");

//        driver.navigate().to("https://www.demoblaze.com/");

        String expectedTitle = "STORE"; // comes from documentation SRS

        String actualTitle = driver.getTitle();

        if(expectedTitle.equalsIgnoreCase(actualTitle)) {
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

    }

}
