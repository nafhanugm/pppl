package pertemuan3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class Tugas1 {
    WebDriver driver;
    String url = "https://practicetestautomation.com/practice-test-exceptions/";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCase1_NoSuchElementException_ImmediateSearch() {
        assertThrows(NoSuchElementException.class, () -> {
            driver.findElement(By.id("add_btn")).click();

            driver.findElement(By.xpath("//div[@id='row2']"));
        });
    }

    @Test
    public void testCase1_NoSuchElementException_WithThreadSleep() throws InterruptedException {
            driver.findElement(By.id("add_btn")).click();

            Thread.sleep(10000);

            WebElement row2 = driver.findElement(By.xpath("//div[@id='row2']"));

            System.out.println("Row 2 text with Thread.sleep: " + row2.getText());
    }

    @Test
    public void testCase1_NoSuchElementException_WithImplicitWait() {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.id("add_btn")).click();

            WebElement row2 = driver.findElement(By.xpath("//div[@id='row2']"));
            System.out.println("Row 2 text with Implicit Wait: " + row2.getText());
    }

    @Test
    public void testCase1_NoSuchElementException_WithExplicitWait() {
            driver.findElement(By.id("add_btn")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement row2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='row2']")));

            System.out.println("Row 2 text with Explicit Wait: " + row2.getText());
    }

    @Test
    public void testCase3_InvalidElementStateException() {
        assertThrows(InvalidElementStateException.class, () -> {
            driver.findElement(By.id("add_btn")).click();

            WebElement inputField = driver.findElement(By.xpath("//div[@id='row1']/input"));
            inputField.clear();
            inputField.sendKeys("Test text");
        });
    }

    @Test
    public void testCase4_StaleElementReferenceException() {
        WebElement instructionsText = driver.findElement(By.xpath("//p[@id='instructions']"));
        System.out.println(instructionsText.getText());

        driver.findElement(By.id("add_btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(instructionsText));

        assertThrows(StaleElementReferenceException.class, () -> {
            System.out.println(instructionsText.getText());
        });
    }

    @Test
    public void testCase5_TimeoutException() {
            assertThrows(TimeoutException.class, () -> {
                driver.findElement(By.id("add_btn")).click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='row2']")));
            });

            assertThrows(TimeoutException.class, () -> {
                driver.navigate().refresh();
                driver.findElement(By.id("add_btn")).click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='row2']")));
            });

            assertThrows(TimeoutException.class, () -> {
                driver.navigate().refresh();
                driver.findElement(By.id("add_btn")).click();
                FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(3))
                        .pollingEvery(Duration.ofMillis(500))
                        .ignoring(NoSuchElementException.class);

                fluentWait.until(driver -> {
                     return driver.findElement(By.xpath("//div[@id='row2']"));
                });
            });
    }
}