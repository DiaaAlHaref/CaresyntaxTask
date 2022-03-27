package POM;

import FileReader.PropertiesFile;
import Utilities.UiActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * LandingPage Class represents the homepage that URL Navigate to
 * Contains Element locators for Sign In Form
 */

/**
 * @author Diaa AlHaref
 */
public class LandingPage{
    UiActions uiActions = new UiActions();


    private String[] view = PropertiesFile.propertiesFileReader(new String[]{"HoverLink","SignInButton"});
    private By HoverLink = By.id(view[0]);
    private By SignInButton = By.xpath(view[1]);

    /**
     * Function to Hover on SignIn Link
     */
    public void HoverOnSignInLink(){
        WebElement element = uiActions.FindElement(HoverLink);
        Actions action = new Actions(uiActions.driver);
        action.moveToElement(element).perform();
    }

    /**
     * Function to Wait for the Element until Clickable then Click on it
     */
    public void ClickOnSignInButton(){
        uiActions.WaitForElement("Clickable",SignInButton)
                .ClickOnElement(SignInButton);
    }

}
