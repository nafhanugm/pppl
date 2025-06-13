package uas.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.uas.pages.HomePage;
import org.example.uas.pages.LoginPage;
import org.example.uas.pages.StatisticPage;
import org.example.uas.pages.WeightPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class WeightStepDef {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    StatisticPage statisticPage;
    WeightPage weightPage;
    int initialCount;

    @Given("user sudah berhasil login dan berada di halaman statistik berat badan")
    public void userSudahLoginDanBeradaDiHalamanStatistikBeratBadan() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.navigateTo(); // Navigate to the login page
        homePage = loginPage.loginAndNavigateToHome("Cek12345@gmail.com", "Cek12345@gmail.com");
        assertTrue("Home page is not loaded", homePage.isHomePageLoaded());
        statisticPage = homePage.clickStatisticButton();
        assertTrue("Statistic page is not loaded", statisticPage.isStatisticPageLoaded());

        weightPage = statisticPage.clickWeightButton();
        assertTrue("Weight page is not loaded", weightPage.isWeightPageLoaded());
    }

    @And("user sudah memiliki {int} data berat badan")
    public void userSudahMemilikiDataBeratBadan(int jumlahData) {
        initialCount = jumlahData;
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit(); // Close the browser after each test scenario
        }
    }

    @Given("user klik tombol \"Tambah Data\"")
    public void userKlikTombolTambahData() {
        initialCount = weightPage.countCurrentWeightTracks();
        weightPage.clickTambahBeratButton();
    }

    @Given("user mengisi form untuk menambah rekaman data berat dan tinggi badan dengan input angka {int}")
    public void userMengisiFormUntukMenambahData(int angka) {
        if (angka == -1) {
            weightPage.tambahBerat("-1"); // Invalid input
        } else if (angka == 501) {
            weightPage.tambahBerat("501"); // Invalid input
        } else {
            weightPage.tambahBerat("50"); // Valid input
        }
    }

    @When("user klik tombol \"Submit\" pada tambah")
    public void userKlikTombolSubmit() {
        weightPage.clickAddSubmitButton();
    }

    @Then("berat badan dan tinggi badan berhasil ditambahkan")
    public void beratBadanDanTinggiBadanBerhasilDitambahkan() {
        assertTrue("Weight and height were not added successfully", weightPage.isWeightAdded("50"));
    }

    @Then("pesan kesalahan \"Data tidak valid\" muncul")
    public void pesanKesalahanDataTidakValidMuncul() {
        assertTrue("Error message is not displayed", weightPage.isFailedMessageDisplayed());
    }

    @Given("user klik tombol \"Edit\" dengan ikon pensil di data berat badan paling atas")
    public void userKlikTombolEdit() {
        weightPage.clickEditButton();
    }

    @Given("user mengisi form untuk mengedit rekaman data berat dan tinggi badan dengan input angka {int}")
    public void userMengisiFormUntukMengeditData(int angka) {
        if (angka == -1) {
            weightPage.editBerat("-1", "170"); // Invalid input
        } else {
            weightPage.editBerat("60", "170"); // Valid input
        }
    }

    @When("user klik tombol \"Submit\" pada edit")
    public void userKlikTombolSubmitEdit() {
        weightPage.clickEditSubmitButton();
    }

    @Then("data berat badan dan tinggi badan berhasil diperbarui")
    public void dataBeratBadanDanTinggiBadanBerhasilDiperbarui() {
        assertTrue("Weight and height were not updated", weightPage.isWeightHeightUpdated("60", "170"));
    }

    @Given("user klik tombol \"Hapus\" di data berat badan")
    public void userKlikTombolHapus() {
        weightPage.deleteBerat();
    }

    @When("user klik tombol \"Hapus\" pada popup konfirmasi yang muncul")
    public void userKlikTombolHapusPadaPopupKonfirmasi() {
        weightPage.confirmDelete();
    }

    @Then("data berat badan berhasil dihapus")
    public void dataBeratBadanBerhasilDihapus() {
        assertTrue("Weight was not deleted successfully", weightPage.isWeightHeightDeleted(initialCount));
    }
}
