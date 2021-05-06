import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductPage {
    private final By ALL_PRODUCTS_IN_GRID = By.xpath(".//*[@id='list-page-right']//div/div/a");
    private final By ADD_TO_CART_BTN = By.xpath(".//*[@data-externalid='add-to-cart']");

    private WebDriverWait wait;
    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.opticsplanet.com/riflescopes.html");
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    @Test //Adding a product to the Cart from a single variant page
    public void addSingleVariantToCart() {
        List<WebElement> allProducts = driver.findElements(ALL_PRODUCTS_IN_GRID);
        //Loop to find product which doesn't contain models
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getText().contains("models")) {
                continue;
            }
            allProducts.get(i).click();
            break;
        }
    }

    @Test //Adding a product to the Cart from a multi variant page
    public void addMultiVariantToCart() {
        List<WebElement> allProducts = driver.findElements(ALL_PRODUCTS_IN_GRID);
        //Loop to find product which doesn't contain models
        for (int i = 0; i < allProducts.size(); i++) {
            if (!allProducts.get(i).getText().contains("models")) {
                continue;
            }
            allProducts.get(i).click();
            break;
        }
    }
}