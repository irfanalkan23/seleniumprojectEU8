package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task02 {

    public static void main(String[] args) {

        //Basic login authentication
        //- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //- Verify title equals: String expectedTitle = "Web Orders Login"
        String expectedTitleBeforeLogin = "Web Orders Login";
        String actualTitleBeforeLogin = driver.getTitle();

        if(actualTitleBeforeLogin.equals(expectedTitleBeforeLogin)){
            System.out.println("success");
        } else {
            System.out.println(-1);
        }

        //- Enter username: Tester
        WebElement userNameBox = driver.findElement(By.id("ctl00_MainContent_username"));
        userNameBox.sendKeys("Tester");

        //- Enter password: test
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");

        //- Click “Sign In” button
        WebElement signInButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        signInButton.click();

        //- Verify title equals: String expectedHomePageTitle = "Web Orders"
        String expectedHomePageTitle = "Web Orders";
        String actualHomoPageTitle = driver.getTitle();

        if(actualHomoPageTitle.equals(expectedHomePageTitle)) {
            System.out.println("PASSED");
        } else {
            System.out.println(-1);
        }

        ReviewUtils.staticWait(1);
        driver.close();
    }
}
