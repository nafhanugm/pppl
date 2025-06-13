package org.example.uas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TokenPage extends BasePage {

    private final By tokenInput = By.xpath("/html/body/div/div/div/div/div/form/div/input");
    private final By submitButton = By.xpath("/html/body/div/div/div/div/div/form/button");
    private final By failedMessage = By.xpath("/html/body/div/div/div/div/div/form/div/p");

    public TokenPage(WebDriver driver) {
        super(driver);
    }

    public TokenPage enterToken(String token) {
        enterText(tokenInput, token);
        return this;
    }

    public HomePage clickSubmitButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(waitForElementVisible(submitButton)).click().perform();
        return new HomePage(driver);
    }

    public HomePage submitToken(String token) {
        enterToken(token);
        return clickSubmitButton();
    }

    public boolean isFailedMessageDisplayed() {
        return isElementDisplayed(failedMessage) &&
                getElementText(failedMessage).contains("Invalid or already used product token");
    }

    public boolean isTokenInputDisplayed() {
        return isElementDisplayed(tokenInput);
    }
}
