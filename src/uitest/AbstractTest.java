import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    protected final static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void oneTimeSetUp() {
        File file = new File("chromedriver.exe"); //Path to driver
        System.setProperty("webdriver.chromedriver.driver", file.getAbsolutePath()); //Driver name

        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.get("https://automationexercise.com/");
    }

    @AfterClass
    public static void oneTimeTearDown() {
        driver.quit();
    }
}
