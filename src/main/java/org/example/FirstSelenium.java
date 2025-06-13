package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.*;

public class FirstSelenium {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.google.com");
        //System.out.println(driver.getTitle());
        //driver.quit();

//        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver-mac-arm64/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Selenium");
        System.out.println(driver.getTitle());
//        driver.quit();
    }
}