package intro;

import intro.elements.AlertHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
   public WebDriver driver;
   public BrowserHelper browserHelper;
   public AlertHelper alertHelper;

    @BeforeClass
    public void test(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        browserHelper=new BrowserHelper(driver);
        alertHelper=new AlertHelper(driver);
    }




}
