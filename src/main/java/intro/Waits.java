package intro;

import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits extends BaseTest{

    @Test
    public void test1ExpliciteWait(){
        driver.navigate().to("https://demoqa.com/dynamic-properties");
        WebElement enable= driver.findElement(By.xpath("//button[@id='enableAfter']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(enable));
        enable.click();

        wait.until(ExpectedConditions.attributeContains(By.id("colorChange"),"class","mt-4 text-danger btn btn-primary"));
        WebElement colrChange= driver.findElement(By.id("colorChange"));
        colrChange.click();

    }
    @Test
    public void test2(){
        driver.navigate().to("https://demoqa.com/dynamic-properties");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("visibleAfter")))).click();

    }
    @Test
    public void test3(){
        driver.navigate().to("https://www.etsy.com/");

        WebElement signInButton=driver.findElement(By.xpath("(//button[contains(text(),'Войти')])[1]"));
        signInButton.click();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement signIn=driver.findElement(By.id("join-neu-overlay-title"));
        wait.until(ExpectedConditions.visibilityOf(signIn));
    }

}
