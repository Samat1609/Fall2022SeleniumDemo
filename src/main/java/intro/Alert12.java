package intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alert12 extends BaseTest{

    @Test
    public void testAlerts(){
        driver.get("https://demoqa.com/alerts");
        WebElement clickMe1=driver.findElement(By.xpath("//button[@id='alertButton']"));
        clickMe1.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();

        WebElement clickMe2=driver.findElement(By.id("timerAlertButton"));
        clickMe2.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();


        WebElement clickMe3= driver.findElement(By.xpath("//button[@id='confirmButton']"));
        clickMe3.click();
        Alert alert1=driver.switchTo().alert();
        alert1.dismiss();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText(),"You selected Cancel");
        Helper.pause(3000);


        WebElement clickMe4= driver.findElement(By.xpath("//button[@id='promtButton']"));
        clickMe4.click();
        Alert alert2=driver.switchTo().alert();
        alert2.sendKeys("Samat");
        alert2.accept();
        Helper.pause(4000);


    }
}
