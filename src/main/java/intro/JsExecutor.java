package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JsExecutor extends BaseTest{

    @Test
    public void test1(){
        browserHelper.openURL("https://www.etsy.com/");

        WebElement career= driver.findElement(By.xpath("//span[text()='Вакансии']"));
        Helper.jsClick(driver,career);
        Helper.pause(5000);

        Helper.scrollDawnThePage(driver,"250");
        Helper.pause(5000);
        Helper.scrollDawnThePage(driver,"500");
        Helper.pause(5000);




    }
}
