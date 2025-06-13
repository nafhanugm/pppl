package org.example.uas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final String PAGE_URL = "https://nutriplate.id/app/login";
    private final By emailField = By.xpath("//*[@id=\":R5mfnlttb:-form-item\"]");
    private final By passwordField = By.xpath("//*[@id=\":R9mfnlttb:-form-item\"]");
    private final By loginButton = By.xpath("/html/body/div/div/div/div[2]/form/button");
    private final By loginFailedMessage = By.xpath("/html/body/div/div/div/div[2]/form/div[1]/p");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isElementLoaded() {
        return isElementDisplayed(emailField) && isElementDisplayed(passwordField) && isElementDisplayed(loginButton);
    }

    public LoginPage navigateTo() {
        driver.get(PAGE_URL);
        return this;
    }

    public LoginPage enterEmail(String email) {
        enterText(emailField, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enterText(passwordField, password);
        return this;
    }

    public TokenPage clickLoginButton() {
        click(loginButton);
        return new TokenPage(driver);
    }

    public TokenPage loginWithCredentials(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        return clickLoginButton();
    }

    public HomePage loginAndNavigateToHome(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        return new HomePage(driver);
    }

    public boolean isLoginFailedMessageDisplayed() {
        return isElementDisplayed(loginFailedMessage) &&
                getElementText(loginFailedMessage).contains("Invalid email or password");
    }

    public TokenPage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        return clickLoginButton();
    }
}
