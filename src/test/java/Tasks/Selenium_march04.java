package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium_march04 {
    @Test
    public void vwo_login() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        //WAIT
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3000));

        driver.get("https://app.vwo.com/#/login");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@admin.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
        //driver.findElement(By.xpath("//button[@id='js-login-btn']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='js-login-btn']"))).click();



        //verify the error message
        WebElement actual_err_msg=driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));
        String expected_err_msg="Your email, password, IP address or location did not match";
        Assert.assertEquals(actual_err_msg.getText(),expected_err_msg);

        driver.quit();

    }
}
