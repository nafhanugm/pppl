package pertemuan2.tugas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HerokuappTests {
    private WebDriver driver;
    private Actions actions;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testHover() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement firstImage = driver.findElements(By.className("figure")).get(0);

        actions.moveToElement(firstImage).perform();

        WebElement caption = firstImage.findElement(By.className("figcaption"));
        assertTrue(caption.isDisplayed());
        assertTrue(caption.getText().contains("name: user1"));
    }

    @Test
    public void testDragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement divA = driver.findElement(By.id("column-a"));
        WebElement divB = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(divA, divB).perform();

        WebElement newA = driver.findElement(By.id("column-a"));
        assertEquals("Column swap failed", "B", newA.getText());
    }

    @Test
    public void testKeyPresses() {
        driver.get("https://the-internet.herokuapp.com/key_presses");

        WebElement inputField = driver.findElement(By.id("target"));

        inputField.sendKeys(Keys.SHIFT);

        WebElement resultElement = driver.findElement(By.id("result"));
        assertTrue(resultElement.getText().contains("You entered: SHIFT"));
    }
}