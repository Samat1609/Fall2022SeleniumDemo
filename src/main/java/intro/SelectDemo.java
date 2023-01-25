package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectDemo extends BaseTest{

    @Test
    public void test1(){
        driver.get("https://demoqa.com/select-menu");

        WebElement selectValue= driver.findElement(By.xpath("//input[@id='react-select-2-input']"));
        selectValue.sendKeys("Croup 1,option 1");
        selectValue.sendKeys(Keys.ENTER);

        WebElement selectOne= driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        selectOne.sendKeys("Ms",Keys.ENTER);

        WebElement oldStyle= driver.findElement(By.id("oldSelectMenu"));
        Select select=new Select(oldStyle);
        select.selectByVisibleText("Black");

        WebElement multiSelectDropDown= driver.findElement(By.id("react-select-4-input"));
        multiSelectDropDown.sendKeys("Blue",Keys.ENTER);

        WebElement standard=driver.findElement(By.id("cars"));
        select=new Select(standard);
        select.selectByVisibleText("Opel");
        Assert.assertEquals(driver.findElement(By.xpath("//option[@value='opel']")).getAttribute("value"),"opel");


    }
}
