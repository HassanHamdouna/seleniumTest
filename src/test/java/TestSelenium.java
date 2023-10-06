import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void initialize() {
        driver.get("https://www.google.com/");
        Assert.assertTrue(driver.findElement(By.name("q")).isDisplayed());
    }

    @Test
    public void testSearch() {
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
