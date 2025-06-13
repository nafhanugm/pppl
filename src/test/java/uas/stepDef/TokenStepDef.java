package uas.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.uas.pages.LoginPage;
import org.example.uas.pages.TokenPage;
import org.example.uas.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class TokenStepDef {
    WebDriver driver;
    LoginPage loginPage;
    TokenPage tokenPage;
    HomePage homePage;

    @Given("user sudah berhasil login dan berada di halaman pengisian token")
    public void userSudahBerhasilLoginDanBeradaDiHalamanPengisianToken() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.navigateTo();

        loginPage.loginWithCredentials("Cek12345@gmail.com", "Cek12345@gmail.com");

        tokenPage = new TokenPage(driver);
        assertTrue("Token input page is not loaded", tokenPage.isTokenInputDisplayed());
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("user mengisi token yang invalid {string}")
    public void userMengisiTokenYangInvalid(String invalidToken) {
        tokenPage.enterToken(invalidToken);
    }

    @When("user klik tombol \"Submit\"")
    public void userKlikTombolSubmit() {
        tokenPage.clickSubmitButton();
    }

    @Then("pesan kesalahan \"Token tidak valid\" muncul")
    public void pesanKesalahanTokenTidakValid() {
        assertTrue("Error message for invalid token is not displayed",
                tokenPage.isFailedMessageDisplayed());
    }

    @Given("user mengisi token yang valid {string}")
    public void userMengisiTokenYangValid(String validToken) {
        tokenPage.enterToken(validToken);
    }

    @Then("token akan terverifikasi dan user berhasil masuk ke halaman utama")
    public void tokenAkanTerverifikasiDanUserBerhasilMasukKeHalamanUtama() {
        homePage = tokenPage.clickSubmitButton();
        assertTrue("Home page is not loaded", homePage.isHomePageLoaded());
    }
}
