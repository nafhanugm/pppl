package org.example.uas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private static final String PAGE_URL = "https://nutriplate.id/app/home";
    private final By statisticButton = By.xpath("/html/body/div/div[2]/a[2]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage navigateTo() {
        driver.get(PAGE_URL);
        return this;
    }

    public boolean isHomePageLoaded() {
        return isStatisticButtonDisplayed();
    }

    public boolean isStatisticButtonDisplayed() {
        return isElementDisplayed(statisticButton);
    }

    public StatisticPage clickStatisticButton() {
        click(statisticButton);
        return new StatisticPage(driver);
    }
}