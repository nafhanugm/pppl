package org.example.pertemuan2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final String PAGE_URL = "https://www.automationexercise.com/";
    private final By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By loggedInAsText = By.xpath("//a[contains(text(),' Logged in as')]");
    private final By deleteAccountLink = By.xpath("//a[contains(text(),' Delete Account')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage navigateTo() {
        driver.get(PAGE_URL);
        return this;
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("Automation Exercise");
    }

    public SignupLoginPage clickSignupLoginLink() {
        click(signupLoginLink);
        return new SignupLoginPage(driver);
    }

    public boolean isUserLoggedIn(String username) {
        try {
            String loggedInText = getText(loggedInAsText);
            return loggedInText.contains(username);
        } catch (Exception e) {
            return false;
        }
    }

    public AccountPage deleteAccount() {
        click(deleteAccountLink);
        return new AccountPage(driver);
    }
}