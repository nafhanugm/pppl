import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    private WebDriver driver;

    @Test
    public void testChromeTedi() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tedi.sv.ugm.ac.id/id/muka/");
        assertEquals("Website Departemen Teknik Elektro dan Informatika (TEDI), Sekolah Vokasi, UGM – TEDI SV UGM", driver.getTitle());
        assertEquals("https://tedi.sv.ugm.ac.id/id/muka/", driver.getCurrentUrl());

        driver.quit();
    }

    @Test
    public void testSafariTedi () {
        driver = new SafariDriver();
        driver.get("https://tedi.sv.ugm.ac.id/id/muka/");
        assertEquals("Website Departemen Teknik Elektro dan Informatika (TEDI), Sekolah Vokasi, UGM – TEDI SV UGM", driver.getTitle());
        assertEquals("https://tedi.sv.ugm.ac.id/id/muka/", driver.getCurrentUrl());

        driver.quit();
    }
}
