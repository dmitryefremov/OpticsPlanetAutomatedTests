package stepdefs;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicStepDefs {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I Am on {string} Page")
    public void open_page(String url) {
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
            wait = new WebDriverWait(driver, 5);

            driver.manage().window().maximize();
            driver.get(url);
        }

    @Given("I Am on HomePage")
    public void open_home_page() {
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
        wait = new WebDriverWait(driver, 5);

        driver.manage().window().maximize();
        driver.get("https://www.opticsplanet.com/");
    }

    @Given("I click on {string}")
    public void click(String locator) {
        final By LOCATOR = By.xpath(locator);

        wait.until(ExpectedConditions.elementToBeClickable(LOCATOR)).click();
    }
}
