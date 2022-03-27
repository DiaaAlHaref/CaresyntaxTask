import FileReader.PropertiesFile;
import Utilities.HandleExceptions;
import Utilities.Logs;
import Utilities.UiActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import java.io.ByteArrayInputStream;

public class BaseTest {
    Logs Log = new Logs();

    String[] view = PropertiesFile.propertiesFileReader(new String[]{"baseUrl"});
    protected String url = view[0];
    /**
     * loads the drivers Chrome, FireFox, InternetExplorer
     */

    @BeforeMethod
    public void StartDriver(@Optional("chrome") String browser){
        //@optional used to run test by default value passed to it ex. ("chrome")
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                UiActions.driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                UiActions.driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                UiActions.driver = new EdgeDriver();
                break;
        }

        /**
         * Navigate directly to url
         * <p>Maximize window size</p>
         */
        UiActions.driver.manage().window().maximize();
        Log.info("Browser window size maximized");
        UiActions.driver.manage().deleteAllCookies();
        UiActions.driver.navigate().to(url);
        WebElement AcceptCookies = UiActions.driver.findElement(By.id("sp-cc-accept"));
        AcceptCookies.click();
        Log.info("Navigate to url");
    }

    /**
     * Takes Screenshot on Failure
     *
     * @param result result when "Failure" exist
     */
    @AfterMethod
    @Attachment(value = "Screenshot", type = "image/png")
    public void takeScreenShotsOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            // in case of test case failure take screenshots
            System.out.println("*** Test execution *** " + " " + result.getMethod().getMethodName() + "  >>   " + " failed...");
            System.out.println("Taking Screenshot...");
            //ScreenShot.CaptureScreenshots(result.getName());
            Allure.addAttachment("Page Screenshot",
                    new ByteArrayInputStream(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)));
        }
    }

    /**
     * Exit the running browser
     */
    @AfterMethod(dependsOnMethods = {"takeScreenShotsOnFailure"})
    public void TearDown(){
        try {
            UiActions.driver.quit();
        }catch (NoSuchSessionException e) {
            HandleExceptions.NoSuchSessionExceptionHandling(e);
        }
    }
}
