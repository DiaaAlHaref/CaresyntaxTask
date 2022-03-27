package POM;





/**
 * CreateAccountPage Class represents the homepage that URL Navigate to
 * Contains Element locators for Create Account Form
 */

import FileReader.PropertiesFile;
import Utilities.UiActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Create Account Page Class represents functions for the Create Account Form
 * Contains Element locators for Sign in inputs and interaction on it
 */

/**
 * @author Diaa AlHaref
 */
public class CreateAccountPage {
    UiActions uiActions = new UiActions();

    private String[] view = PropertiesFile.propertiesFileReader(new String[]{"HoverLink","SignInButton","StartHereButton"
    , "CreateAccountPageTitle","NameInputField","Email_Locator","Password_Locator","ConfirmPassword","Email_ContinueButton"});
    private By HoverLink = By.id(view[0]);
    private By SignInButton = By.xpath(view[1]);
    private By StartHereButton = By.xpath(view[2]);
    private By CreateAccountPageTitle = By.xpath(view[3]);
    private By NameInputField = By.id(view[4]);
    private By Email_Locator = By.id(view[5]);
    private By Password_Locator = By.id(view[6]);
    private By ConfirmPassword = By.id(view[7]);
    private By Email_ContinueButton= By.id(view[8]);

    /**
     * Function to Hover on Menu bar
     */
    public void HoverOnMenu(){
        Actions actions = new Actions(uiActions.driver);
        WebElement menuOption = uiActions.FindElement(HoverLink);
        uiActions.WaitForElement("Visible",HoverLink);
        actions.moveToElement(menuOption).perform();
    }
    /**
     * Function to Click On Start Here Link
     */
    public void ClickOnStartHere(){
        uiActions.ClickOnElement(StartHereButton);
    }

    /**
     * Function to Return Page Title
     * @return
     */
    public String ReturnPageTitle(){
        return uiActions.WaitForElement("Visible",CreateAccountPageTitle).
                GetTextValue(CreateAccountPageTitle);
    }

    /**
     * Function To Enter the Name
     */
    public void EnterYourName(){
        uiActions.FindElement(NameInputField);
        uiActions.SendKeysToInputField("Diaa");
    }

    /**
     * Function to Enter Email
     */
    public void EnterYourEmail(){
        uiActions.FindElement(Email_Locator);
        uiActions.SendKeysToInputField("diaa.alharef@gmail.com");
    }

    /**
     * Function To Enter Password
     */
    public void EnterYourPassword(){
        uiActions.FindElement(Password_Locator);
        uiActions.SendKeysToInputField("Qwert");
    }

    /**
     * Function To Confirm Passord
     */
    public void ConfirmYourPassword(){
        uiActions.FindElement(ConfirmPassword);
        uiActions.SendKeysToInputField("Qwert");
    }

    /**
     * Function to Click on Continue Button
     */
    public void ClickOnContinueButton(){
        uiActions.ClickOnElement(Email_ContinueButton);    }
}
