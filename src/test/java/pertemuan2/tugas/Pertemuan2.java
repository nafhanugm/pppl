package pertemuan2.tugas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class Pertemuan2 {
    private WebDriver wd;
    private Actions action;

    @Before
    public void setup(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        action = new Actions(wd);
    }

    @After
    public void teardown(){
        if (wd != null){
            wd.quit();
        }
    }

    @Test
    public void testSauce(){
        wd.get("https://www.saucedemo.com/v1/");

        WebElement userInput = wd.findElement(By.id("user-name"));
        userInput.sendKeys("standard_user");

        WebElement passInput = wd.findElement(By.id("password"));
        passInput.sendKeys("secret_sauce");

        WebElement btnSubmit = wd.findElement(By.id("login-button"));
        btnSubmit.click();

        assertEquals("Swag Labs", wd.getTitle());
        assertEquals("https://www.saucedemo.com/v1/inventory.html", wd.getCurrentUrl());
    }

    @Test
    public void testSauceCheckout(){
        testSauce();
        WebElement addToCartBtn = wd.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
        addToCartBtn.click();

        WebElement itemCount = wd.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        assertEquals("1", itemCount.getText());

        WebElement addToCartBtn2 = wd.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button"));
        addToCartBtn2.click();

        itemCount = wd.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        assertEquals("2", itemCount.getText());

        WebElement cartIcon = wd.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        cartIcon.click();
        new WebDriverWait(wd, Duration.ofSeconds(1));

        testHeader("Your Cart");

        WebElement checkoutBtn = wd.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]"));
        checkoutBtn.click();

        new WebDriverWait(wd, Duration.ofSeconds(1));

        testHeader("Checkout: Your Information");

        WebElement firstNameInput = wd.findElement(By.xpath("//*[@id=\"first-name\"]"));
        WebElement lastNameInput = wd.findElement(By.xpath("//*[@id=\"last-name\"]"));
        WebElement zipInput = wd.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        firstNameInput.sendKeys("TungTungTung");
        lastNameInput.sendKeys("Sahur");
        zipInput.sendKeys("513333");

        WebElement btnSubmit = wd.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input"));
        btnSubmit.click();

        testHeader("Checkout: Overview");

        WebElement btnFinish = wd.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]"));

        btnFinish.click();
        testHeader("Finish");
    }

    private void testHeader(String expected){
        assertEquals(expected, wd.findElement(By.xpath("//*[@id=\"contents_wrapper\"]/div[2]")).getText());
    }
}
