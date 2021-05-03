import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductGrid {
    private final By FIRST_PRODUCT_IN_GRID = By.xpath(".//*[@id='list-page-right']//div/div/a");
    private WebDriverWait wait;
    private WebDriver browserWindow;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("https://www.opticsplanet.com/riflescopes.html");
        wait = new WebDriverWait(browserWindow, 10);
    }

    @Test
    public void addSignleVariantToCart() {
        List<WebElement> allProducts = browserWindow.findElements(FIRST_PRODUCT_IN_GRID);
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getText().contains("models"));
            else wait.until(ExpectedConditions.elementToBeClickable(allProducts.get(i))).click();
        }
    }

    @Test
    public void addMultiVariantToCart() {

    }
}
