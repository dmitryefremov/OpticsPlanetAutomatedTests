package pageobject.components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.pages.BaseFunc;
import pageobject.pages.ProductGridPage;

public class SignIn {
    private final By SIGN_IN_BUTTON = By.id("sign-in-popup-button");
    private final By SIGN_IN_EMAIL_INPUT = By.id("signInEmailInput");
    private final By SIGN_IN_PASSWORD_INPUT = By.id("signInPasswordInput");
    private final By SIGN_IN_SUBMIT_BTN = By.xpath(".//*/button[@type='submit']");
    private final By CUSTOMER_AUTHORIZED_PROOF = By.id("authorized-customer-greeting");

    private final Logger LOGGER = LogManager.getLogger(ProductGridPage.class);

    private BaseFunc baseFunc = new BaseFunc();

    private WebDriverWait wait;
    private WebDriver driver;

    //Use this String for prefilling your e-mail
    String signInEmail = "your@email.com";
    //Use this String for prefilling your password
    String signInPassword = "password";

    @Test
    public void signIn() { //Signing in as an existing customer
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("Clicking Sign In Button");
        baseFunc.click(SIGN_IN_BUTTON);
        LOGGER.info("Providing customer e-mail and password");
        baseFunc.type(SIGN_IN_EMAIL_INPUT, signInEmail);
        baseFunc.type(SIGN_IN_PASSWORD_INPUT, signInPassword);
        LOGGER.info("Trying to Sign In");
        baseFunc.click(SIGN_IN_SUBMIT_BTN);
        LOGGER.info("Checking customer is really signed in");
        baseFunc.isVisible(CUSTOMER_AUTHORIZED_PROOF);
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}
