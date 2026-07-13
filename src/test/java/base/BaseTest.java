package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Log;


import java.time.Duration;

public class BaseTest {

   protected  WebDriver driver;
    public WebDriver getDriver(){

        return driver;
    }

    @BeforeClass
    public void setup(){


        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            Log.info("Closing Browser..");
            driver.quit();
        }
    }



}
