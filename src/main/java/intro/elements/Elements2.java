package intro.elements;
import intro.BaseTest;
import intro.Helper;
import mockDataGenerator.MockDataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class Elements2 extends BaseTest {

    @BeforeMethod
    public void goToElementsPage(){
        browserHelper.openURL("https://demoqa.com/elements");
    }

    @Test
    public void testTextBox(){
        browserHelper.openURL("https://demoqa.com/text-box");


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
        Helper.scrollDawnThePage(driver,"250");
        submitButton.click();

        WebElement actualFullName=driver.findElement(By.xpath("//p[@id='name']"));
        Assert.assertEquals(actualFullName.getText().substring(5),fullName);

        Assert.assertEquals(emailInput.getAttribute("value"),email);

        WebElement actualCurrentAddress=driver.findElement(By.xpath("//p[@id='currentAddress']"));
        Assert.assertTrue(actualCurrentAddress.getText().contains(currentAddress));
    }

    @Test
    public void testCheckBox(){
        browserHelper.openURL("https://demoqa.com/checkbox");
        WebElement toggle1= driver.findElement(By.xpath("//button[@title='Toggle']"));
        Helper.jsClick(driver,toggle1);

        WebElement desktop= driver.findElement(By.xpath("(//button[@title='Toggle'])[2]"));
        desktop.click();

        WebElement commands= driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[4]"));
        commands.click();

        Assert.assertTrue(toggle1.isEnabled());
        Assert.assertTrue(desktop.isDisplayed());

    }

    @Test
    public void testRadioButton(){
        browserHelper.openURL("https://demoqa.com/radio-button");
        WebElement yesButton=driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Yes']")).getText(),"Yes");
        Assert.assertTrue(yesButton.isEnabled());

    }

    @Test
    public void testWebTables(){
        browserHelper.openURL("https://demoqa.com/webtables");

        WebElement addButton= driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        String firstName=MockDataGenerator.mockFirstNameGenerator();
        WebElement firstNameInput=driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys(firstName);

        String lastName=MockDataGenerator.mockLastNameGenerator();
        WebElement lastNameInput=driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys(lastName);

        String email=MockDataGenerator.mockEmailGenerator();
        WebElement emailInput= driver.findElement(By.id("userEmail"));
        emailInput.sendKeys(email);

        int age=MockDataGenerator.mockAgeGenerator();
        WebElement ageInput= driver.findElement(By.id("age"));
        ageInput.sendKeys(String.valueOf(age));

        int salary=MockDataGenerator.mockSalaryGenerator();
        WebElement salaryInput= driver.findElement(By.id("salary"));
        salaryInput.sendKeys(String.valueOf(salary));

        String department=MockDataGenerator.mockDepartmentGenerator();
        WebElement departmentInput=driver.findElement(By.id("department"));
        departmentInput.sendKeys(department);

        WebElement submitButton=driver.findElement(By.id("submit"));
        submitButton.click();


    }
    @Test
    public void testButtons(){
        browserHelper.openURL("https://demoqa.com/buttons");
        Actions actions=new Actions(driver);
        WebElement doubleClickMe=driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        actions.doubleClick(doubleClickMe).perform();

        WebElement rightClickMe=driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
        actions.contextClick(rightClickMe).perform();

        WebElement clickMe=driver.findElement(By.xpath("(//button[@type='button'])[4]"));
        actions.click(clickMe).perform();

        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(),"You have done a double click");
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).getText().contains("You have done a right click"));

    }
    @Test
    public void testLinks(){
        browserHelper.openURL("https://demoqa.com/links");
        WebElement home=driver.findElement(By.xpath("(//a[text()='Home'])[1]"));
        home.click();
        Helper.pause(4000);
        browserHelper.switchToParentPage();

    }

    @Test
    public void testUploadAndDownload(){
        browserHelper.openURL("https://demoqa.com/upload-download");
        WebElement download= driver.findElement(By.id("uploadFile"));
        download.sendKeys("C:\\Users\\User\\Pictures\\Sam.png");

    }
    @Test
    public void testDynamicProperties(){
        browserHelper.openURL("https://demoqa.com/dynamic-properties");
        WebElement willEnable5Seconds= driver.findElement(By.id("enableAfter"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(willEnable5Seconds));
        willEnable5Seconds.click();
        Assert.assertTrue(willEnable5Seconds.isEnabled());


        wait.until(ExpectedConditions.attributeContains(By.id("colorChange"),"class","mt-4 text-danger btn btn-primary"));
        WebElement color= driver.findElement(By.id("colorChange"));
        color.click();

        WebElement visibleAfter= driver.findElement(By.id("visibleAfter"));
        wait.until(ExpectedConditions.visibilityOf(visibleAfter));
        visibleAfter.click();

    }
}
