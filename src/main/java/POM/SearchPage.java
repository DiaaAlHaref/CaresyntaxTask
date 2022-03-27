package POM;

import FileReader.PropertiesFile;
import Utilities.UiActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

/**
 * SearchPage Class represents Functions to Search for a Product
 * Contains Element locators for searchbar and String to search for
 */

public class SearchPage {
    UiActions uiActions = new UiActions();



    private String[] view = PropertiesFile.propertiesFileReader(new String[]{"Searchbar","FirstResult","AddToCart","CloseButton",
                                                "SecondResult","ShoppingBasket","ShoppingBasket2","SaveForLaterButton1",
                                                "SavedCartList","MoveToBasketButton","ShoppingBasketButton"});
    private By Searchbar = By.id(view[0]);
    private By FirstResult = By.xpath(view[1]);
    private By AddToCart = By.xpath(view[2]);
    private By CloseButton = By.id(view[3]);
    private By SecondResult = By.xpath(view[4]);
    private By ShoppingBasket = By.id(view[5]);
    private By ShoppingBasket2 = By.id(view[6]);
    private By SaveForLaterButton1 = By.xpath(view[7]);
    private By SavedCartList=By.id(view[8]);
    private By MoveToBasketButton=By.xpath(view[9]);
    private By ShoppingBasketButton=By.id(view[10]);


    /**
     * Function to Find Element and Send String to the Searchbar
     */
    public void SearchForProduct(){
        uiActions.FindElement(Searchbar).
                sendKeys("Drucker", Keys.ENTER);
    }

    /**
     * Function to Select First Product in the Search Results
     */
    public void SelectFirstProduct(){
        uiActions.ClickOnElement(FirstResult);
    }

    /**
     * Function to Add Selected Product to the Shopping Cart
     */
    public void AddProductToCart(){
        uiActions.FindElement(AddToCart);
        uiActions.WaitForElement("Presence", AddToCart);
        uiActions.WaitForElement("Clickable",AddToCart).
                ClickOnElement(AddToCart);
    }

    /**
     * Function to Close the Pop up window
     */
    public void ClickCloseButton(){
        uiActions.WaitForElement("Clickable",CloseButton).
                ClickOnElement(CloseButton);
    }

    /**
     * Function to Go back 2 steps in the browser
     */
    public void GoBack(){
        uiActions.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        uiActions.driver.navigate().back();
        uiActions.driver.navigate().back();
    }

    /**
     * Function to Select Second Product
     */
    public void SelectSecondProduct(){
        uiActions.ClickOnElement(SecondResult);
    }

    /**
     * Function to Navigate to Shopping Basket
     */
    public void GoToShoppingBasket(){
        uiActions.WaitForElement("Visible",ShoppingBasket).
                WaitForElement("Clickable",ShoppingBasket).
                ClickOnElement(ShoppingBasket);
    }

    /**
     * Function to Save the Product For Later Purchase
     */
    public void SaveTheProductsLater(){
        uiActions.WaitForElement("Visible",SaveForLaterButton1)
                .WaitForElement("Clickable",SaveForLaterButton1)
                .ClickOnElement(SaveForLaterButton1);
    }

    /**
     * Function to Return the Saved Products for Verification on it
     * @return String
     */
    public String CheckSavedProducts(){
      return uiActions.WaitForElement("Visible",SavedCartList).
              WaitForElement("Clickable",SavedCartList).
                GetTextValue(SavedCartList);
    }

    /**
     * Function to Move Back to Basket
     */
    public void MoveBackToBasket(){
        uiActions.WaitForElement("Visible",MoveToBasketButton).
                WaitForElement("Clickable",MoveToBasketButton).
                ClickOnElement(MoveToBasketButton);
    }

    /**
     * Function to Return Number of Items in the Basket
     * @return int
     */
    public int NumberOfItemsInBasket(){
      return uiActions.WaitForElement("Visible",SavedCartList)
                .getSizeOfElements();
    }
}
