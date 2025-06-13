package org.example.uas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class StatisticPage extends BasePage {
    private static final String PAGE_URL = "https://nutriplate.id/app/statistic";
    private final By weightButton = By.xpath("/html/body/div/div[1]/div/div[2]/div[3]/div/div[4]/a/button");

    public StatisticPage(WebDriver driver) {
        super(driver);
    }

    public StatisticPage navigateTo() {
        driver.get(PAGE_URL);
        return this;
    }

    public boolean isStatisticPageLoaded() {
        return isElementDisplayed(weightButton);
    }

    public WeightPage clickWeightButton() {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 300); // Scroll down to ensure the button is visible
        actions.moveToElement(waitForElementVisible(weightButton)).click().perform();
        return new WeightPage(driver);
    }
}
