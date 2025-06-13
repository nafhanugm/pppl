package org.example.pertemuan2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    private final By accountInfoHeader = By.xpath("//b[contains(text(),'Enter Account Information')]");
    private final By titleMrRadio = By.id("id_gender1");
    private final By passwordField = By.id("password");
    private final By daysDropdown = By.id("days");
    private final By monthsDropdown = By.id("months");
    private final By yearsDropdown = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By specialOffersCheckbox = By.id("optin");
    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By companyField = By.id("company");
    private final By address1Field = By.id("address1");
    private final By address2Field = By.id("address2");
    private final By countryDropdown = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountInfoSectionDisplayed() {
        return isElementDisplayed(accountInfoHeader);
    }

    public RegistrationPage selectTitleMr() {
        click(titleMrRadio);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        enterText(passwordField, password);
        return this;
    }

    public RegistrationPage selectDateOfBirth(String day, String month, String year) {
        selectByValue(daysDropdown, day);
        selectByValue(monthsDropdown, month);
        selectByValue(yearsDropdown, year);
        return this;
    }

    public RegistrationPage checkNewsletter() {
        click(newsletterCheckbox);
        return this;
    }

    public RegistrationPage checkSpecialOffers() {
        click(specialOffersCheckbox);
        return this;
    }

    public RegistrationPage fillAddressInfo(String firstName, String lastName, String company,
                                            String address1, String address2, String country,
                                            String state, String city, String zipcode, String mobileNumber) {
        enterText(firstNameField, firstName);
        enterText(lastNameField, lastName);
        enterText(companyField, company);
        enterText(address1Field, address1);
        enterText(address2Field, address2);
        selectByVisibleText(countryDropdown, country);
        enterText(stateField, state);
        enterText(cityField, city);
        enterText(zipcodeField, zipcode);
        enterText(mobileNumberField, mobileNumber);
        return this;
    }

    public AccountPage clickCreateAccountButton() {
        click(createAccountButton);
        return new AccountPage(driver);
    }

    public AccountPage completeRegistration(String password, String day, String month, String year,
                                            String firstName, String lastName, String company,
                                            String address1, String address2, String country,
                                            String state, String city, String zipcode, String mobileNumber) {
        selectTitleMr()
                .enterPassword(password)
                .selectDateOfBirth(day, month, year)
                .checkNewsletter()
                .checkSpecialOffers()
                .fillAddressInfo(firstName, lastName, company, address1, address2, country,
                        state, city, zipcode, mobileNumber);
        return clickCreateAccountButton();
    }
}