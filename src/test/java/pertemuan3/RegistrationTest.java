package pertemuan3;

import org.example.pertemuan2.pages.AccountPage;
import org.example.pertemuan2.pages.HomePage;
import org.example.pertemuan2.pages.RegistrationPage;
import org.example.pertemuan2.pages.SignupLoginPage;
import org.example.pertemuan2.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testUserRegistration() {
        String name = TestUtil.UserData.NAME;
        String email = TestUtil.generateRandomEmail();

        homePage.navigateTo();
        assertTrue("Home page should be loaded", homePage.isPageLoaded());

        SignupLoginPage signupLoginPage = homePage.clickSignupLoginLink();
        assertTrue("Signup section should be displayed", signupLoginPage.isSignupSectionDisplayed());

        RegistrationPage registrationPage = signupLoginPage.signup(name, email);
        assertTrue("Account info section should be displayed", registrationPage.isAccountInfoSectionDisplayed());

        AccountPage accountPage = registrationPage.completeRegistration(
                TestUtil.UserData.PASSWORD,
                TestUtil.UserData.DAY,
                TestUtil.UserData.MONTH,
                TestUtil.UserData.YEAR,
                TestUtil.UserData.FIRST_NAME,
                TestUtil.UserData.LAST_NAME,
                TestUtil.UserData.COMPANY,
                TestUtil.UserData.ADDRESS1,
                TestUtil.UserData.ADDRESS2,
                TestUtil.UserData.COUNTRY,
                TestUtil.UserData.STATE,
                TestUtil.UserData.CITY,
                TestUtil.UserData.ZIPCODE,
                TestUtil.UserData.MOBILE_NUMBER
        );

        assertTrue("Account created message should be displayed", accountPage.isAccountCreatedMessageDisplayed());

        HomePage loggedInHomePage = accountPage.clickContinueButton();

        try {
            assertTrue("User should be logged in", loggedInHomePage.isUserLoggedIn(name));

            AccountPage deletedAccountPage = loggedInHomePage.deleteAccount();
            assertTrue("Account deleted message should be displayed", deletedAccountPage.isAccountDeletedMessageDisplayed());
        } catch (Exception e) {
            System.out.println("Issue with login verification or account deletion: " + e.getMessage());
        }
    }
}