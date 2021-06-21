package pageobject.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunc {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    WebDriver driver;
    WebDriverWait wait;

    public BaseFunc() {
        LOGGER.info("Starting web browser");
        try {
            String chromeDriverPath = System.getenv("chrome_driver_path");
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        } catch (NullPointerException e) {
            System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments(//Remove this if you want to enable browser: "--headless",
                "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }

    public void openPage(String url) {
        LOGGER.info("Opening page by URL: " + url);

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        driver.get(url);
    }

    public void click(By locator) {
        LOGGER.info("Clicking on element by: " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void click(WebElement element) {
        LOGGER.info("Clicking on web element");
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void isVisible(By locator) {
        LOGGER.info("Element is visible by: " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void isVisible(WebElement element) {
        LOGGER.info("Element is visible by: " + element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> findElements(By locator) {
        LOGGER.info("Getting list of elements by: " + locator);
        return driver.findElements(locator);
    }

    public List<WebElement> findElements(WebElement parent, By child) {
        LOGGER.info("Getting all child elements");
        return parent.findElements(child);
    }

    public List<WebElement> findElement(By locator) {
        LOGGER.info("Getting element text by: " + locator);
        return driver.findElements(locator);
    }

    public String getText(WebElement parent, By child) {
        LOGGER.info("Getting text for child element by locator");
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, child)).getText();
    }

    public String getText(By locator) {
        LOGGER.info("Getting text from " + locator + " locator");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public String getText(String text) {
        LOGGER.info("Getting text from " + text + " locator");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(text))).getText();
    }

    public void closeBrowser() {
        LOGGER.info("Closing browser window");
        if (driver != null) {
            driver.close();
        }
    }

    public String cutString(String result) {
        LOGGER.info("Cutting String Length");
        int startIndex = 15;
        int stopIndex = result.length();
        StringBuilder croppedString = new StringBuilder(result);
        croppedString.delete(startIndex, stopIndex);
        return result = croppedString.toString();
    }

    public void compareTwoStrings(String stringOne, String stringTwo) {
        LOGGER.info("Comparing Two Strings");
        Assertions.assertEquals(stringOne, stringTwo, "Different text detected!");
    }

    public void shouldContains(String text1, String text2) {
        LOGGER.info("Checking string contains provided text");
        int startIndex = text2.length();
        int stopIndex = text1.length();
        StringBuilder croppedString = new StringBuilder(text1);
        croppedString.delete(startIndex, stopIndex);
        text1 = croppedString.toString();
        Assertions.assertEquals(text1, text2);
    }

//    public void mouseOver(By locator) {
//        Actions action = new Actions(driver);
//        WebElement we = driver.findElement(locator));
//        action.moveToElement(we).build().perform();
//    }

    public String getUrlFromLocator(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator)).getAttribute("href");
    }

    public String getCurrentUrl() {
        LOGGER.info("Getting current URL");
        return driver.getCurrentUrl();
    }

    public void type(By locator, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
        Assertions.assertFalse(false, "Can't type text! Element isn't clickable!");
    }

    public void type(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
        Assertions.assertFalse(false, "Can't type text! Element isn't clickable!");
    }


}
