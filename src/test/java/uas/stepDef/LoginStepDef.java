package uas.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.uas.pages.LoginPage;
import org.example.uas.pages.TokenPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class LoginStepDef {
    WebDriver driver;
    LoginPage loginPage;
    TokenPage tokenPage;

    @Given("user sudah masuk ke halaman login")
    public void userSudahMasukKeHalamanLogin() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        assertTrue("Login page is not loaded", loginPage.isElementLoaded());
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("user berada di halaman login")
    public void userBeradaDiHalamanLogin() {
        loginPage = new LoginPage(driver);
        loginPage.navigateTo();
    }

    @When("user memasukkan email \"Cek123456@gmail.com\"")
    public void userMemasukkanEmail() {
        loginPage.enterEmail("Cek123456@gmail.com");
    }

    @When("user memasukkan password \"Cek123456@gmail.com\"")
    public void userMemasukkanPassword() {
        loginPage.enterPassword("Cek123456@gmail.com");
    }

    @When("user klik tombol \"Next\"")
    public void userKlikTombolNext() {
        tokenPage = loginPage.clickLoginButton();
    }

    @Then("data email dan password akan terverifikasi")
    public void dataEmailDanPasswordAkanTerverifikasi() {

    }

    @Then("halaman pengisian token muncul")
    public void halamanPengisianTokenMuncul() {
            assertTrue("Token input page is not displayed", tokenPage.isTokenInputDisplayed());
    }

    @Given("user berada di halaman login setelah browser dibuka kembali")
    public void userBeradaDiHalamanLoginSetelahBrowserDibukaKembali() {
        loginPage.navigateTo();
    }

    @When("user memasukkan email \"salah@domain.com\"")
    public void userMemasukkanEmailSalah() {
        loginPage.enterEmail("salah@domain.com");
    }

    @When("user memasukkan password \"passwordsalah\"")
    public void userMemasukkanPasswordSalah() {
        loginPage.enterPassword("PasswordSalahBos123");
    }

    @Then("pesan kesalahan \"Invalid email or password\" muncul")
    public void pesanKesalahanMuncul() {
        assertTrue("Error message is not displayed", loginPage.isLoginFailedMessageDisplayed());
    }
}
