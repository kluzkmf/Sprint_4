import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class ATest {
    public WebDriver driver;

    @Before
    public void setChromeDriver() { driver = new ChromeDriver(); }

    @After
    public void tearDown() {
        driver.quit();
    }
}
