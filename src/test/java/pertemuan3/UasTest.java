package pertemuan3;

import org.example.uas.pages.HomePage;
import org.example.uas.pages.LoginPage;
import org.example.uas.pages.StatisticPage;
import org.example.uas.pages.WeightPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class UasTest {
    private WebDriver driver;
    private LoginPage loginPage;
    HashMap<String, Integer> contentSettings = new HashMap<>();
    HashMap<String, Object> profile = new HashMap<>();
    HashMap<String, Object> prefs = new HashMap<>();

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        contentSettings.put("media_stream", 1);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }

    @Test
    public void testUas() throws InterruptedException {
        loginPage.navigateTo();
        assertTrue("Home page should be loaded", loginPage.isElementLoaded());

//        HomePage homePage = loginPage.login("Cek1234@gmail.com", "Cek1234@gmail.com");
//        assertTrue("Home page should be loaded after login", homePage.isHomePageLoaded());
//
//        StatisticPage statisticPage = homePage.clickStatisticButton();
//        assertTrue("Scan page should be loaded", statisticPage.isStatisticPageLoaded());
//
//        WeightPage weightPage = statisticPage.clickWeightButton();
//        assertTrue("Weight page should be loaded", weightPage.isWeightPageLoaded());
//
//        weightPage.tambahBerat("68");
//        assertTrue("Weight should be added successfully", weightPage.isWeightAdded("68"));
//
//        weightPage.editBerat("80", "183");
//        System.out.println("Weight after edit: " + weightPage.getCurrentWeight("80"));
//        System.out.println("Height after edit: " + weightPage.getCurrentHeight("183"));
//        assertTrue("Weight should be edited successfully", weightPage.isWeightHeightUpdated("80", "183"));
//
//        weightPage.deleteBerat();
    }
}
