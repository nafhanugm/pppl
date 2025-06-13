package pertemuan2.tugas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testRegistration() {
        driver.get("https://www.automationexercise.com/");

        assertTrue(driver.getTitle().contains("Automation Exercise"));

        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        WebElement signupText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'New User Signup!')]")));
        assertTrue(signupText.isDisplayed());

        WebElement nameField = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        String name = "Test User";
        String email = "testuser" + System.currentTimeMillis() + "@example.com";

        nameField.sendKeys(name);
        emailField.sendKeys(email);

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        WebElement accountInfoText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//b[contains(text(),'Enter Account Information')]")));
        assertTrue(accountInfoText.isDisplayed());

        driver.findElement(By.id("id_gender1")).click();

        driver.findElement(By.id("password")).sendKeys("password123");

        Select daySelect = new Select(driver.findElement(By.id("days")));
        daySelect.selectByValue("15");

        Select monthSelect = new Select(driver.findElement(By.id("months")));
        monthSelect.selectByValue("6");

        Select yearSelect = new Select(driver.findElement(By.id("years")));
        yearSelect.selectByValue("1990");

        driver.findElement(By.id("newsletter")).click();

        driver.findElement(By.id("optin")).click();

        driver.findElement(By.id("first_name")).sendKeys("Test");
        driver.findElement(By.id("last_name")).sendKeys("User");
        driver.findElement(By.id("company")).sendKeys("Test Company");
        driver.findElement(By.id("address1")).sendKeys("123 Test St");
        driver.findElement(By.id("address2")).sendKeys("Apt 456");

        Select countrySelect = new Select(driver.findElement(By.id("country")));
        countrySelect.selectByVisibleText("United States");

        driver.findElement(By.id("state")).sendKeys("California");
        driver.findElement(By.id("city")).sendKeys("Los Angeles");
        driver.findElement(By.id("zipcode")).sendKeys("90001");
        driver.findElement(By.id("mobile_number")).sendKeys("1234567890");

        driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();

        WebElement accountCreatedText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//b[contains(text(),'Account Created!')]")));
        assertTrue(accountCreatedText.isDisplayed());

        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();

        try {
            WebElement loggedInText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[contains(text(),' Logged in as')]")));
            assertTrue(loggedInText.getText().contains(name));
        } catch (Exception e) {
            System.out.println("Navigation issue after account creation: " + e.getMessage());
        }

        try {
            driver.findElement(By.xpath("//a[contains(text(),' Delete Account')]")).click();

            WebElement accountDeletedText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//b[contains(text(),'Account Deleted!')]")));
            assertTrue(accountDeletedText.isDisplayed());
        } catch (Exception e) {
            System.out.println("Issue with account deletion: " + e.getMessage());
        }
    }
}