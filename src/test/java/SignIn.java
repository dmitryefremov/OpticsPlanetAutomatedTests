import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {
    private final By SIGN_IN_BUTTON = By.id("sign-in-popup-button");
    private final By SIGN_IN_EMAIL_INPUT = By.id("signInEmailInput");
    private final By SIGN_IN_PASSWORD_INPUT = By.id("signInPasswordInput");
    private final By SIGN_IN_SUBMIT_BTN = By.xpath(".//*/button[@type='submit']");
    private final By CUSTOMER_AUTHORIZED_PROOF = By.id("authorized-customer-greeting");

    private WebDriverWait wait;
    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.opticsplanet.com/gun-parts.html");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void signIn() { //Signing in as an existing customer
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_BUTTON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_EMAIL_INPUT)).sendKeys("dvorbehat@gmail.com"); //You can change e-mail for login
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_PASSWORD_INPUT)).sendKeys("qweqwe13"); //You can change password for login
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_SUBMIT_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(CUSTOMER_AUTHORIZED_PROOF));
        driver.quit();
    }
}
