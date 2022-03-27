package POM;

import FileReader.PropertiesFile;
import Utilities.UiActions;
import org.openqa.selenium.By;

/**
 * Login Page Class represents functions for the Sign in Form
 * Contains Element locators for Sign in inputs and interaction on it
 */

/**
 * @author Diaa AlHaref
 */
public class LoginPage {

    UiActions uiActions = new UiActions();

    private String[] view = PropertiesFile.propertiesFileReader(new String[]{"Email_Locator","Email_ContinueButton",
            "Password_Locator","Password_SubmitButton","LoginUserName"});

    private By Email_Locator = By.id(view[0]);
    private By Email_ContinueButton = By.id(view[1]);
    private By Password_Locator= By.id(view[2]);
    private By Password_SubmitButton = By.id(view[3]);
    private By LoginUserName = By.xpath(view[4]);


    /**
     * Function to Find Email Input Field then Send keys to it
     */
    public void TypeEmail(){
        uiActions.FindElement(Email_Locator);
        uiActions.SendKeysToInputField("diaa.alharef@gmail.com");
    }

    /**
     * Function to Click on the Continue Button
     */
    public void ClickOnContinueButton(){
        uiActions.ClickOnElement(Email_ContinueButton);
    }
    /**
     * Function to Find Password Input Field then Send keys to it
     */
    public void TypePassword(){
        uiActions.FindElement(Password_Locator);
        uiActions.SendKeysToInputField("");
    }

    /**
     * Function to Click on the Submit Button
     */
    public void ClickOnSubmitButton(){
        uiActions.ClickOnElement(Password_SubmitButton);
    }

    /**
     * Function to return logged in User
     * @return String
     */
    public String VerifyLoginUserPage(){
        return uiActions.WaitForElement("Visible",LoginUserName).GetTextValue(LoginUserName);
    }
}
