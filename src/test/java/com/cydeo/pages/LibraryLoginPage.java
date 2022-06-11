package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//normally we name it just "LoginPage"
//but for now we name "LibraryLoginPage, so that we differentiate from "CRMLoginPage" etc.
//this class is for each page of the application
public class LibraryLoginPage {

    //#1- initialize the driver instance and object of the class
    public LibraryLoginPage(){

        //initElements method will reate connection in between the current
        // driver session (instance) and the object of the current class
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //#2- use @FindBy annotation to locate web elements
    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputUsername;

    @FindBy(id="inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

//    @FindBy(xpath = "//div[.='This field is required.']/div")
    @FindBy(xpath = "//div[text()='This field is required.']")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[text()='Please enter a valid email address.']")
    public WebElement enterValidEmailErrorMessage;

    @FindBy(xpath = "//div[text()='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordErrorMessage;


}
