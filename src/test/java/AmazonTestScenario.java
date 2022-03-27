import POM.CreateAccountPage;
import POM.LandingPage;
import POM.LoginPage;
import POM.SearchPage;
import Utilities.UiActions;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TestScenario Class Demonstrates test steps run and assertions
 */
public class AmazonTestScenario extends BaseTest{
    UiActions uiActions = new UiActions();

    LandingPage landingPage = new LandingPage(); //Instantiation of LandPage object
    CreateAccountPage createAccountPage = new CreateAccountPage(); //Instantiation of CreateAccountPage object
    LoginPage loginPage = new LoginPage(); //Instantiation of LoginPage object
    SearchPage searchPage = new SearchPage(); //Instantiation of SearchPage object

    @Description("Test Create Account Form")
    @Test
    public void CreateAccount(){
        Log.log4PropertiesConfiguration();
        Log.runTestCase("test_CreateAccountAndVerifyTheFlow");
        createAccountPage.HoverOnMenu();
        Log.info("Hove on Menu bar");
        createAccountPage.ClickOnStartHere();
        Log.info("Click On Start Here");


        String CreateAccountPageTitle = createAccountPage.ReturnPageTitle();
        Assert.assertEquals(CreateAccountPageTitle,"Create account");
        Log.info("Verify Create Account Page Title is "+CreateAccountPageTitle);

        createAccountPage.EnterYourName();
        Log.info("Name Entered Successfully");
        createAccountPage.EnterYourEmail();
        Log.info("Email Entered Successfully");
        createAccountPage.EnterYourPassword();
        Log.info("Password Entered Successfully");
        createAccountPage.ConfirmYourPassword();
        Log.info("Confirm Password Entered Successfully");
        createAccountPage.ClickOnContinueButton();
        Log.info("Click on Continue Button");
        Log.endTestCase("test_CreateAccountAndVerifyTheFlow");
    }
    @Description("Test Login with user Flow , Select Products")
    @Test
    public void LoginWithAccount(){
        Log.log4PropertiesConfiguration();
        Log.runTestCase("test_LoginWithUserAndVerifyLoggedInFlow");

        Log.info("All Cookies Deleted");

        landingPage.HoverOnSignInLink();
        Log.info("Hover On Sign In Link");
        landingPage.ClickOnSignInButton();
        Log.info("Click On Sign In Button");


        loginPage.TypeEmail();
        Log.info("Email Typed Successfully");
        loginPage.ClickOnContinueButton();
        Log.info("Continue Button Pressed Successfully");

        loginPage.TypePassword();
        Log.info("Password Typed Successfully");
        loginPage.ClickOnSubmitButton();
        Log.info("Submit Button Pressed Successfully");

        String UserLoginName = loginPage.VerifyLoginUserPage();
        Assert.assertEquals(UserLoginName,"Hello, Diaa");
        Log.info("Verify Sign In User");
        System.out.println("The Sign in Name is : "+""+UserLoginName);

        Log.endTestCase("test_LoginWithUserAndVerifyLoggedInFlow");
        Log.runTestCase("test_SearchForProduct");
        searchPage.SearchForProduct();
        Log.info("Search For Product :"+"Drucker");
        uiActions.ScrollToButtonPage("window.scrollTo(0,200);");
        Log.info("Scroll Down to Products");
        searchPage.SelectFirstProduct();
        Log.info("Select First Product Result");
        searchPage.AddProductToCart();
        Log.info("Add Product to Cart");
        //searchPage.ClickCloseButton();
        // Go back to Search Result
        searchPage.GoBack();
        Log.info("Go Back in the Browser");


        searchPage.SelectSecondProduct();
        Log.info("Select Second Product Result");
        uiActions.driver.navigate().refresh();
        Log.info("Refresh the page");

        searchPage.AddProductToCart();
        Log.info("Add the Product to Cart");
        uiActions.driver.navigate().refresh();
        Log.info("Refresh the page");
        JavascriptExecutor ClickElement = (JavascriptExecutor) uiActions.driver;
        ClickElement.executeScript("document.querySelector('#add-to-cart-button')?.click()");
        Log.info("Click on Add to Cart Button");
        //searchPage.ClickCloseButton();
        //Go to Shopping basket
        searchPage.GoToShoppingBasket();
        Log.info("Go To Shopping Basket");

        // Validate added items are visible on “Shopping basket” list
        int NumberOfItems = uiActions.driver.findElements(By.xpath("//div[@class='a-fixed-left-grid']")).size();
        Assert.assertEquals(NumberOfItems,2);
        System.out.println("Number of items= "+NumberOfItems);
        Log.fatal("Validate added items are visible on “Shopping basket” list");


        //  Validate that user able to save the product for later purchase by clicking on “Save for later” button.
        uiActions.driver.navigate().refresh();
        Log.info("Refresh the Page");
        searchPage.SaveTheProductsLater();
        Log.info("First Product Saved for Later Purchase");
        searchPage.SaveTheProductsLater();
        Log.info("Second Product Saved for Later Purchase");
        uiActions.ScrollToButtonPage("window.scrollTo(0,500);");
        Log.info("Scroll to the buttom");
        String ItemsSaved = searchPage.CheckSavedProducts();
        Assert.assertEquals(ItemsSaved,"Saved for later (2 items)");
        Log.fatal(" Validate that user able to save the product for later purchase by clicking on “Save for later” button");

        // Validate that user can move the product back to basket by clicking on “Move to Basket”
        searchPage.MoveBackToBasket();
        Log.info("Move to Basket");
        searchPage.MoveBackToBasket();
        Log.info("Move to Basket");
        uiActions.ScrollToButtonPage("window.scrollTo(0,100);");
        Log.info("Scroll to upwards");
        int NumberOfItemsBack = searchPage.NumberOfItemsInBasket();
        Assert.assertEquals(NumberOfItemsBack,2);
        System.out.println("NumberOfItemsBack is: " + NumberOfItemsBack);
        Log.fatal("Validate that user can move the product back to basket by clicking on “Move to Basket”");

        Log.endTestCase("test_LoginWithUserAndVerifyLoggedInFlow");
    }
}
