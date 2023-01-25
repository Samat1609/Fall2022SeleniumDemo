package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Frames12 extends BaseTest{

    @Test
    public void test1(){
        driver.navigate().to("https://demoqa.com/frames");

        driver.switchTo().frame(2);
        WebElement text1= driver.findElement(By.id("sampleHeading"));
        System.out.println(text1.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(3);
        WebElement text2= driver.findElement(By.id("sampleHeading"));
        System.err.println(text2.getText());
        driver.switchTo().defaultContent();
        WebElement framesText=driver.findElement(By.xpath("//div[@class='pattern-backgound playgound-header']"));
        System.out.println(framesText.getText());


    }

}
