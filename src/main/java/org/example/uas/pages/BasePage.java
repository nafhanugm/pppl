package org.example.uas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean waitForElementNotDisplayed(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitForElementVisible(locator).click();
    }

    protected void enterText(By locator, String text) {
        waitForElementVisible(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForElementVisible(locator).getText();
    }

    protected boolean isElementDisplayed(By locator) {
        return waitForElementVisible(locator).isDisplayed();
    }

    protected void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void scrollToElement(By locator) {
        WebElement element = waitForElementVisible(locator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void selectByVisibleText(By locator, String text) {
        Select select = new Select(waitForElementVisible(locator));
        select.selectByVisibleText(text);
    }

    protected void selectByValue(By locator, String value) {
        Select select = new Select(waitForElementVisible(locator));
        select.selectByValue(value);
    }

    protected String getElementText(By locator) {
        return waitForElementVisible(locator).getText();
    }

    protected void clearText(By locator) {
        WebElement element = waitForElementVisible(locator);
        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
    }

    protected void waitForElementCleared(By locator) {
        wait.until(ExpectedConditions.textToBe(locator, ""));
    }

    protected void waitForElementUpdated(By locator, String expectedText) {
        wait.until(ExpectedConditions.textToBe(locator, expectedText));
    }
}