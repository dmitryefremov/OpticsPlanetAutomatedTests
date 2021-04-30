import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {
    private final By SIGN_IN_BUTTON = By.id("sign-in-popup-button");

    @Test
    public void signInAction() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("https://opticsplanet.com");
        WebDriverWait wait = new WebDriverWait(browserWindow, 10);

        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_BUTTON)).click();
    }

}
