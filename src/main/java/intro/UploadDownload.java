package intro;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadDownload extends BaseTest{

    @Test
    public void test1(){
        driver.navigate().to("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\User\\Pictures\\Sam.png");
        Helper.pause(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='uploadedFilePath']")).getText(),"C:\\fakepath\\Sam.png");
    }
}
