package org.example.pertemuan2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    private final By accountCreatedHeader = By.xpath("//b[contains(text(),'Account Created!')]");
    private final By accountDeletedHeader = By.xpath("//b[contains(text(),'Account Deleted!')]");
    private final By continueButton = By.xpath("//a[contains(text(),'Continue')]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedMessageDisplayed() {
        return isElementDisplayed(accountCreatedHeader);
    }

    public boolean isAccountDeletedMessageDisplayed() {
        return isElementDisplayed(accountDeletedHeader);
    }

    public HomePage clickContinueButton() {
        click(continueButton);
        return new HomePage(driver);
    }
}