package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DoubleClickPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DoubleClick {

    @Test
    public void T1_double_click_test(){
        //TC #1: Double Click Test
        //1. Go to
        //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");

        //3. Double click on the text “Double-click me to change my text color.”
        DoubleClickPage doubleClickPage = new DoubleClickPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(doubleClickPage.textDoubleClick).perform();

        //4. Assert: Text’s “style” attribute value contains “red”.
        System.out.println("doubleClickPage.textDoubleClick.getAttribute(\"style\") = "
                + doubleClickPage.textDoubleClick.getAttribute("style"));

        String actualStyleAttributeValue = doubleClickPage.textDoubleClick.getAttribute("style");
        String expectedInStyleAttribute = "red";
        Assert.assertTrue(actualStyleAttributeValue.contains(expectedInStyleAttribute));

    }
}
