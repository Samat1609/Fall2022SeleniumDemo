package intro.elements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {

    private Alert alert;
    private WebDriver driver;

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }


    public void acceptAlert(){
        alert=driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert(){
        alert=driver.switchTo().alert();
        alert.dismiss();
    }

    public void sendKeysAlert(String str){
        alert=driver.switchTo().alert();
        alert.sendKeys(str);
    }
}
