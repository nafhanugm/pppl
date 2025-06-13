package org.example.pertemuan2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends BasePage {
    private final By signupText = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private final By nameField = By.xpath("//input[@data-qa='signup-name']");
    private final By emailField = By.xpath("//input[@data-qa='signup-email']");
    private final By signupButton = By.xpath("//button[@data-qa='signup-button']");

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignupSectionDisplayed() {
        return isElementDisplayed(signupText);
    }

    public SignupLoginPage enterSignupDetails(String name, String email) {
        enterText(nameField, name);
        enterText(emailField, email);
        return this;
    }

    public RegistrationPage clickSignupButton() {
        click(signupButton);
        return new RegistrationPage(driver);
    }

    public RegistrationPage signup(String name, String email) {
        enterSignupDetails(name, email);
        return clickSignupButton();
    }
}