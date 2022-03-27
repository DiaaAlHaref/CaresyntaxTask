package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * UiActions Class Contains all common actions will be used across all Scenarios
 */

/**
 * @author Diaa AlHaref
 */
public class UiActions {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private WebElement element;
    private List<WebElement> elements;

    /**
     * Find Element
     * @param Locator  ex. by.xpath , by.id , by.name , etc...
     * @return
     */
    public WebElement FindElement(By Locator){
        try {
            element = driver.findElement(Locator);
        }catch (InvalidSelectorException e){
            HandleExceptions.InvalidSelectorExceptionHandling(e);
        }catch (NoSuchElementException e){
            HandleExceptions.NoSuchElementExceptionHandling(e);
        }catch (NullPointerException e){
            HandleExceptions.NullPointerExceptionHandling(e);
        }catch (ElementNotVisibleException e){
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        }
        return element;
    }

    /**
     *  Send keys to a text field
     * @param Keyword String or keyword to Input
     * @return
     */
    public UiActions SendKeysToInputField(String Keyword){
        try {
            element.clear();
            element.sendKeys(Keyword);
        }catch (NullPointerException e){
            HandleExceptions.NullPointerExceptionHandling(e);
        }catch (NoSuchElementException e){
            HandleExceptions.NoSuchElementExceptionHandling(e);
        }
        return this;
    }

    /**
     * Handle Checkboxes interaction
     * @param element
     * @param Locator
     * @return
     */
    public UiActions CheckboxHandling(WebElement element,By Locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        return this;
    }

    /**
     * Interact with Elements , Buttons
     * @param Locator
     * @return
     */
    public UiActions ClickOnElement(By Locator){
        FindElement(Locator).click();
        return this;
    }

    /**
     * Handle scroll Down action on the browser
     */
    public UiActions ScrollToButtonPage(String Script) {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript(Script);
        return this;
    }

    /**
     * Get Text Value
     * @param Locator
     * @return
     */
    public String GetTextValue(By Locator){
        return FindElement(Locator).getText();
    }

    /**
     *  Handle type of waits either visible or clickable
     * @param Type  type of the wait either "visible" or "clickable"
     * @param Locator  locator of element to wait for
     * @return
     */
    public UiActions WaitForElement(String Type, By Locator){
        try {
            wait = new WebDriverWait(driver,1000);
            switch (Type){
                case "Clickable":
                    wait.until(ExpectedConditions.elementToBeClickable(Locator));
                case "Visible":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
                case "Presence":
                    wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
                    break;
            }
        }catch (ElementNotVisibleException e){
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        }catch (ElementNotInteractableException e){
            HandleExceptions.ElementNotInteractableExceptionHandling(e);
        }catch (TimeoutException e){
            HandleExceptions.TimeoutExceptionHandling(e);
        }
        return this;
    }

    /**
     * Find List of Elements
     *
     * @param locator
     * @return
     */
    public UiActions findListOfElements(By locator) {
        try {
            elements = driver.findElements(locator);
        } catch (InvalidSelectorException e) {
            HandleExceptions.InvalidSelectorExceptionHandling(e);
        } catch (NoSuchElementException e) {
            HandleExceptions.NoSuchElementExceptionHandling(e);
        } catch (NullPointerException e) {
            HandleExceptions.NullPointerExceptionHandling(e);
        } catch (ElementNotVisibleException e) {
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        }
        return this;
    }

    /**
     * Get Size for list of elements have the same path
     *
     * @return elements size
     */
    public int getSizeOfElements() {
        return elements.size();
    }

}
