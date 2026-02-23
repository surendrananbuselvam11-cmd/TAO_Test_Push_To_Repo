package base;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties settings = new Properties();

    @BeforeClass
    public void beforeClass() throws Exception {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("settings.properties")) {
            if (in != null) settings.load(in);
        }
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    protected String baseUrl() {
        String env = System.getenv("APP_BASE_URL");
        if (env == null || env.isEmpty()) env = System.getenv("TEST_BASE_URL");
        if (env != null && !env.isEmpty()) return env;
        return settings.getProperty("test.baseUrl", settings.getProperty("baseUrl", ""));
    }

}
