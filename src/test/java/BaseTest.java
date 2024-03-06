import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.module.Configuration;

public abstract class BaseTest {
    public WebDriver driver;

    @Before
    public void setUp() throws Exception {
        String browser = System.getProperty("browser");
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            System.out.println("chrome");
        } else {
            throw new Exception("Incorrect Browser");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
