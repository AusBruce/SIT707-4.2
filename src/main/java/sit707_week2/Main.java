package sit707_week2;

/**
 * Hello world!
 * @author yuheng wang
 */
//public class Main
//{
//    public static void main( String[] args )
//    {
//     //SeleniumOperations.officeworks_registration_page("https://auth.target.com.au/login?state=hKFo2SB3LV9LM0s4bXlCdEhxc203Q3JsWlNxOGJLRmc0SmVraKFupWxvZ2luo3RpZNkgc2pvazVfQ284ZzZFV0dfc29SbE45U0lxRDVzMGk1SDejY2lk2SBYajVuQ1dsaEdiMHJGcFhuazh0VWVRZDVYS01NdjZUVA&client=Xj5nCWlhGb0rFpXnk8tUeQd5XKMMv6TT&protocol=oauth2&redirect_uri=https%3A%2F%2Fwww.target.com.au%2Fauth%2Fcallback&audience=https%3A%2F%2Ftarget.com.au%2Fapi&scope=openid%20email%20offline_access&response_type=code");
//     SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
//    }
//}
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        // Set the system property for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/yuhengwang/Desktop/IT material/2024 T1/SIT707 software testing/chromedriver-mac-x64/chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Perform the login operation using the SeleniumOperations class
            String loginResult = SeleniumOperations.bunningsLoginPage(driver, "https://www.bunnings.com.au/login", "your-email@example.com", "yourPassword");
            System.out.println("Login result: " + loginResult);
        } finally {
            // Ensure the driver  closed after the test
            driver.quit();
        }
    }
}