package desktop.pageobject.components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import desktop.pageobject.Local_env;
import desktop.pageobject.pages.BaseFunc;
import desktop.pageobject.pages.ProductGridPage;

public class SignIn {
    private final By SIGN_IN_BUTTON = By.id("sign-in-popup-button");
    private final By SIGN_IN_EMAIL_INPUT = By.id("signInEmailInput");
    private final By SIGN_IN_PASSWORD_INPUT = By.id("signInPasswordInput");
    private final By SIGN_IN_SUBMIT_BTN = By.xpath(".//*/button[@type='submit']");
    private final By CUSTOMER_AUTHORIZED_PROOF = By.id("authorized-customer-greeting");

    private final By IGNORE_THIS_WARNING_BTN = By.xpath(".//*[contains(text(),'Ignore this warning')]");

    private final Logger LOGGER = LogManager.getLogger(ProductGridPage.class);

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void signIn() { //Signing in as an existing customer
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("Clicking Sign In Button");
        baseFunc.click(SIGN_IN_BUTTON);
        LOGGER.info("Providing customer e-mail and password");
        baseFunc.type(SIGN_IN_EMAIL_INPUT, Local_env.signInEmail);
        baseFunc.type(SIGN_IN_PASSWORD_INPUT, Local_env.signInPassword);
        LOGGER.info("Trying to Sign In");
        baseFunc.click(SIGN_IN_SUBMIT_BTN);

        //This step will not get triggered if your password is not compromised
        LOGGER.info("Compromised password flow");
        baseFunc.click(IGNORE_THIS_WARNING_BTN);

        LOGGER.info("Checking customer is really signed in");
        baseFunc.isVisible(CUSTOMER_AUTHORIZED_PROOF);
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}
