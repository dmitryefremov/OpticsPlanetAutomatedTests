import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductGrid {
    private final By ALL_PRODUCTS_IN_GRID = By.xpath(".//*[@id='list-page-right']//div/div/a");
    private final By SORT_BY_BTN = By.xpath(".//span[@class='e-dropdown-list-btn__text']");
    private final By DROP_DOWN_SORT_LOW_TO_HIGH = By.xpath(".//li[@data-value='lowest-price']");
    private final By DROP_DOWN_SORT_HIGH_TO_LOW = By.xpath(".//li[@data-value='highest-price']");
    private final By DROP_DOWN_SORT_PER_COUNT_LOW_TO_HIGH = By.xpath(".//li[@data-value='lowest-price-per-count']");
    private final By DROP_DOWN_SORT_PER_COUNT_HIGH_TO_LOW = By.xpath(".//li[@data-value='highest-price-per-count']");
    private final By DROP_DOWN_SORT_SAVING = By.xpath(".//li[@data-value='highest-savings']");
    private final By DROP_DOWN_SORT_RATING = By.xpath(".//li[@data-value='highest-rating']");
    private final By DROP_DOWN_SORT_MOST_REVIEWED = By.xpath(".//li[@data-value='most-reviews']");
    private final By DROP_DOWN_SORT_A_TO_Z = By.xpath(".//li[@data-value='alphabetically']");
    private final By DROP_DOWN_SORT_Z_TO_A = By.xpath(".//li[@data-value='alphabetically_desc']");
    private final By DROP_DOWN_SORT_NEWEST = By.xpath(".//li[@data-value='newest']");

    private final Logger LOGGER = LogManager.getLogger(ProductGrid.class);

    private WebDriverWait wait;
    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        LOGGER.info("Opening Gun Parts Category Page");
        driver.get("https://www.opticsplanet.com/gun-parts.html");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void checkingSorting() {
        LOGGER.info("Checking sorting on Product Grid");
        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_LOW_TO_HIGH)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_HIGH_TO_LOW)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_LOW_TO_HIGH)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_PER_COUNT_LOW_TO_HIGH)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_PER_COUNT_HIGH_TO_LOW)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_SAVING)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_RATING)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_MOST_REVIEWED)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_A_TO_Z)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_Z_TO_A)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_NEWEST)).click();
    }

//    @AfterEach
//    public void closeBrowser() {
//        driver.close();
//    }
}