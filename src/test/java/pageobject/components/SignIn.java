package pageobject.components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.pages.ProductGridPage;

public class SignIn {
    private final By SIGN_IN_BUTTON = By.id("sign-in-popup-button");
    private final By SIGN_IN_EMAIL_INPUT = By.id("signInEmailInput");
    private final By SIGN_IN_PASSWORD_INPUT = By.id("signInPasswordInput");
    private final By SIGN_IN_SUBMIT_BTN = By.xpath(".//*/button[@type='submit']");
    private final By CUSTOMER_AUTHORIZED_PROOF = By.id("authorized-customer-greeting");

    private final Logger LOGGER = LogManager.getLogger(ProductGridPage.class);

    private WebDriverWait wait;
    private WebDriver driver;

    //Use this String for prefilling your e-mail
    String signInEmail = "type your e-mail here";
    //Use this String for prefilling your password
    String signInPassword = "type your password here";

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        LOGGER.info("Opening OpticsPlanet Home Page");
        driver.get("https://www.opticsplanet.com/");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void signIn() { //Signing in as an existing customer
        LOGGER.info("Clicking Sign In Button");
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_BUTTON)).click();
        LOGGER.info("Providing customer e-mail and password");
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_EMAIL_INPUT)).sendKeys(signInEmail);
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_PASSWORD_INPUT)).sendKeys(signInPassword);
        LOGGER.info("Trying to Sign In");
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_SUBMIT_BTN)).click();
        LOGGER.info("Checking customer is really signed in");
        wait.until(ExpectedConditions.elementToBeClickable(CUSTOMER_AUTHORIZED_PROOF));
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
