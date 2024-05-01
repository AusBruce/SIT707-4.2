package sit707_week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Ahsan Habib
 */
public class MainTest {

private WebDriver driver;
    private WebDriverWait wait;

@Before
public void setup() {
System.out.println("Before...");
}

@Test
public void testStudentIdentity() {
String studentId = "S223140522";
Assert.assertNotNull("Student ID is null", studentId);
}

@Test
public void testStudentName() {
String studentName = "yuheng wang";
Assert.assertNotNull("Student name is null", studentName);
}


@Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/yuhengwang/Desktop/IT material/2024 T1/SIT707 software testing/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.bunnings.com.au/login");
    }

    @Test
    public void testSuccessfulLogin() {
        // Input valid credentials and submit
        driver.findElement(By.id("username")).sendKeys("validUser");
        driver.findElement(By.id("password")).sendKeys("validPass");
        driver.findElement(By.id("login-button")).click();

        // Wait and check URL change
        wait.until(ExpectedConditions.urlContains("/dashboard"));
        Assert.assertTrue("URL should contain /dashboard", driver.getCurrentUrl().contains("/dashboard"));
    }

    @Test
    public void testFailedLogin() {
        // Input invalid credentials and submit
        driver.findElement(By.id("username")).sendKeys("invalidUser");
        driver.findElement(By.id("password")).sendKeys("invalidPass");
        driver.findElement(By.id("login-button")).click();

        // Wait and check for error message
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message")));
        Assert.assertTrue("Error message should be displayed", errorMessage.isDisplayed());
        Assert.assertEquals("Expected error text not found", "Invalid username or password", errorMessage.getText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

   
}