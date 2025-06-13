package org.example.uas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeightPage extends BasePage{
    private static final String PAGE_URL = "https://nutriplate.id/app/statistic/berat";
    private final By tambahBeratButton = By.xpath("/html/body/div/div[1]/div/div[3]/button[1]");
    private final By inputBeratTambah = By.xpath("/html/body/div[3]/form/div[1]/input");
    private final By inputTinggiTambah = By.xpath("/html/body/div[3]/form/div[2]/input");
    private final By btnSubmitTambah = By.xpath("/html/body/div[3]/form/button");
    private final By errorTambah = By.xpath("/html/body/div[3]/form/div[1]/p");
    private final By btnCancelTambah = By.xpath("//*[@id=\"radix-:r12:\"]/button");
    private final By btnEdit = By.xpath("/html/body/div/div[1]/div/div[4]/div[1]/div[2]/div[1]/button[1]");
    private final By inputBeratEdit = By.xpath("/html/body/div[3]/form/div[1]/input");
    private final By inputTinggiEdit = By.xpath("/html/body/div[3]/form/div[2]/input");
    private final By btnSubmitEdit = By.xpath("/html/body/div[3]/form/button");
    private final By btnDelete = By.xpath("/html/body/div/div[1]/div/div[4]/div[1]/div[2]/div[1]/button[2]");
    private final By btnConfirmDelete = By.xpath("/html/body/div[3]/div[1]/button[1]");
    private final By displayCurrentWeight = By.xpath("/html/body/div/div[1]/div/div[2]/div/div[1]/div[1]/p");
    private final By displayCurrentHeight = By.xpath("/html/body/div/div[1]/div/div[4]/div[1]/div[2]/div[2]/p[2]");

    public WeightPage(WebDriver driver) {
        super(driver);
    }

    public WeightPage navigateTo() {
        driver.get(PAGE_URL);
        return this;
    }

    public boolean isWeightPageLoaded() {
        return isElementDisplayed(tambahBeratButton);
    }

    public void clickTambahBeratButton() {
//        scrollToElement(tambahBeratButton);
        click(tambahBeratButton);
    }

    public void tambahBerat(String berat) {
        enterText(inputBeratTambah, berat);
    }

    public WeightPage clickAddSubmitButton() {
        click(btnSubmitTambah);
        return this;
    }

    public WeightPage clickEditSubmitButton() {
//        click(btnSubmitTambah);
        return this;
    }

    public WeightPage editBerat(String berat, String tinggi) {

        clearText(inputTinggiEdit);
        clearText(inputBeratEdit);
        enterText(inputBeratEdit, berat);
        enterText(inputTinggiEdit, tinggi);
        click(btnSubmitEdit);
        return this;
    }

    public WeightPage clickEditButton() {
        scrollToElement(btnEdit);
        click(btnEdit);
        return this;
    }

    public WeightPage deleteBerat() {
        click(btnDelete);
        return this;
    }

    public WeightPage confirmDelete() {
        click(btnConfirmDelete);
        return this;
    }

    public String getCurrentWeight(String expectedWeight) {
        waitForElementUpdated(displayCurrentWeight, expectedWeight + " kg");
        return getElementText(displayCurrentWeight);
    }

    public String getCurrentHeight(String expectedHeight) {
        waitForElementUpdated(displayCurrentHeight, "Tinggi: "+expectedHeight);
        return getElementText(displayCurrentHeight);
    }

    public boolean isWeightAdded(String expectedWeight) {
        return getCurrentWeight(expectedWeight).equals(expectedWeight + " kg");
    }

    public boolean isWeightHeightUpdated(String expectedWeight, String expectedHeight) {
        String currentWeight = getCurrentWeight(expectedWeight);
        String currentHeight = getCurrentHeight(expectedHeight);
        return currentWeight.equals(expectedWeight + " kg") && currentHeight.equals("Tinggi: " + expectedHeight);
    }

    public boolean isWeightHeightDeleted(int initialCount) {
        int currentCount = countCurrentWeightTracks();
        System.out.println("Initial Count: " + initialCount + ", Current Count: " + currentCount);
        return currentCount - 1 == initialCount;
    }

    public boolean isElementDisplayed(By locator) {
        return super.isElementDisplayed(locator);
    }

    public boolean isFailedMessageDisplayed() {
        return isElementDisplayed(errorTambah) &&
                getElementText(errorTambah).contains("Berat badan tidak valid");
    }

    public int countCurrentWeightTracks() {
        return driver.findElement(By.xpath("/html/body/div/div[1]/div/div[4]")).findElements(By.xpath("./*")).size();
    }

    public void waitHapusButtonNotDisplayed() {
        waitForElementNotDisplayed(btnDelete);
    }
}
