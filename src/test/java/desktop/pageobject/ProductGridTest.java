package desktop.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import desktop.pageobject.pages.BaseFunc;

public class ProductGridTest {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    public ProductGridTest(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);

//    @Test
//    public void checkingSorting() {
//        LOGGER.info("Checking sorting on Product Grid");
//        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_LOW_TO_HIGH)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_HIGH_TO_LOW)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_LOW_TO_HIGH)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_PER_COUNT_LOW_TO_HIGH)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_PER_COUNT_HIGH_TO_LOW)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_SAVING)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_RATING)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_MOST_REVIEWED)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_A_TO_Z)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_Z_TO_A)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_BTN)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN_SORT_NEWEST)).click();
//    }

}
