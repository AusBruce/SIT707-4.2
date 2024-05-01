package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumOperations {

    public static void main(String[] args) {
        // Set up WebDriver path
        System.setProperty("webdriver.chrome.driver", "/Users/yuhengwang/Desktop/IT material/2024 T1/SIT707 software testing/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Perform login operation
            String loginResult = bunningsLoginPage(driver, "https://www.bunnings.com.au/login", "test@email.com", "testPassword");
            System.out.println("Login result: " + loginResult);
        } finally {
            // Always close the driver
            driver.quit();
        }
    }

    public static String bunningsLoginPage(WebDriver driver, String url, String email, String password) {
        System.out.println("Driver info: " + driver);

        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds

        // Locate and fill the email field using XPath
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='okta-signin-username']")));
        emailField.sendKeys(email);

        // Locate and fill the password field using XPath
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='okta-signin-password']")));
        passwordField.sendKeys(password);

        // Locate and click the sign-in button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("okta-signin-submit")));
        loginButton.click();

        // Check for error messages
        List<WebElement> errorMessages = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".okta-form-infobox-error p")));
        if (!errorMessages.isEmpty()) {
            return errorMessages.get(0).getText();
        }

        // Check for the presence of the "Shop now" button to confirm login success
        List<WebElement> shopNowButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(@title, 'Shop now')]")));
        if (!shopNowButtons.isEmpty()) {
            return "Login successful";
        }

        return "Login status unknown";
    }
}
