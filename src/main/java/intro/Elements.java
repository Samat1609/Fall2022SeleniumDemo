package intro;

import mockDataGenerator.MockDataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Elements extends BaseTest {

    @Test
    public void testTexBox(){
        driver.get("https://demoqa.com/text-box");

        String fullName= MockDataGenerator.mockFullNameGenerator();
        WebElement fullNameInput= driver.findElement(By.xpath("//input[@id='userName']"));
        fullNameInput.sendKeys(fullName);

        String email=MockDataGenerator.mockEmailGenerator();
        WebElement emailInput= driver.findElement(By.xpath("//input[@id='userEmail']"));
        emailInput.sendKeys(email);

        String currentAddress=MockDataGenerator.mockCurrentAddressGenerator();
        WebElement currentAddressInput= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddressInput.sendKeys(currentAddress);

        String permanentAddress=MockDataGenerator.mockPermanentAddressGenerator();
        WebElement permanentAddressInput=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddressInput.sendKeys(permanentAddress);

        WebElement submitButton=driver.findElement(By.xpath("//button[@id='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        submitButton.click();

        WebElement actualFullName=driver.findElement(By.xpath("//p[@id='name']"));
        Assert.assertEquals(actualFullName.getText().substring(5),fullName);

        WebElement actualEmail=driver.findElement(By.xpath("//p[@id='email']"));
        Assert.assertEquals(actualEmail.getText().substring(6),email);

        WebElement actualCurrentAddress=driver.findElement(By.xpath("//p[@id='currentAddress']"));
        Assert.assertEquals(actualCurrentAddress.getText().substring(17),currentAddress);

        WebElement actualPermanentAddress=driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        Assert.assertEquals(actualPermanentAddress.getText().substring(20),permanentAddress);

        Assert.assertTrue(submitButton.isDisplayed());

        Assert.assertEquals(fullNameInput.getAttribute("value"),fullName);
        System.out.println(fullNameInput.getAttribute("value"));
        Assert.assertEquals(emailInput.getAttribute("value"),email);


    }

    @Test
    public void testCheckBox(){
        driver.get("https://demoqa.com/checkbox");

        WebElement toggle1Home=driver.findElement(By.xpath("//button[@title='Toggle']"));
        toggle1Home.click();

        WebElement desktopButton=driver.findElement(By.xpath("//span[text()='Desktop']"));
        Assert.assertEquals(desktopButton.getText(),"Desktop");

        WebElement toggleDesktop= driver.findElement(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[2]"));
        toggleDesktop.click();

        WebElement commandsButton=driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[4]"));
        commandsButton.click();

        WebElement actualCommandsText= driver.findElement(By.xpath("//span[text()='commands']"));
        Assert.assertEquals(actualCommandsText.getText(),"commands");

    }
    @Test
    public void testRadioButton(){
        driver.get("https://demoqa.com/radio-button");

        WebElement yesSelect= driver.findElement(By.xpath("//label[text()='Yes']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        yesSelect.click();
        WebElement actual= driver.findElement(By.xpath("//span[text()='Yes']"));
        Assert.assertEquals(actual.getText(),"Yes");


    }


}
