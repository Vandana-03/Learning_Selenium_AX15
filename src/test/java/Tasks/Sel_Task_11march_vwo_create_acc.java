package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v142.fedcm.model.AccountUrlType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Sel_Task_11march_vwo_create_acc {
WebDriver driver;

    @BeforeClass
    public void before_actions()
    {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("incognito");

        driver=new ChromeDriver(options);
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
    }
    @Test
    public void vwo() throws InterruptedException {

        String parentWindow=driver.getWindowHandle();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));

        //click on start free trial
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Start a FREE TRIAL']"))).click();

        //Get all tabs
        Set<String> all_tabs=driver.getWindowHandles();

        //Switch to next tab
            for(String tab : all_tabs){
            driver.switchTo().window(tab);
        }

        //verify if user landed on the create free trial account page
        String create_title=driver.findElement(By.xpath("//h1[normalize-space()='Sign up for a full-featured trial']")).getText();
        Assert.assertEquals(create_title,"Sign up for a full-featured trial");

        WebElement email=driver.findElement(By.xpath("(//input[@name='email'])[1]"));
        email.sendKeys("aiqjfubrwsyosga@bscse.okcx.edu.rs");

        driver.findElement(By.xpath("//input[@id='page-free-trial-step1-cu-gdpr-consent-checkbox']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        //Verify if landed on Sign up for a full-featured trial page
        String signup_title=driver.findElement(By.xpath("//h1[normalize-space()='Sign up for a full-featured trial']")).getText();
        Assert.assertEquals(signup_title,"Sign up for a full-featured trial");

        Thread.sleep(2000);
        //Enter the details of the signup page
        WebElement fname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='page-v1-fname']")));
        fname.sendKeys("Nayana");
        driver.findElement(By.xpath("//input[@id='page-v1-fname']")).sendKeys("Nayana");
        driver.findElement(By.xpath("//input[@id='page-v1-lname']")).sendKeys("tara");
        driver.findElement(By.xpath("//input[@id='page-v1-pnumber']")).sendKeys("9876543210");
        Thread.sleep(2300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-qa='page-su-submit']")));

        driver.findElement(By.xpath("//button[@data-qa='page-su-submit']")).click();


//        driver.findElement(By.xpath("//input[@data-qa='page-su-v1-fname']")).sendKeys("Nayana");
//        driver.findElement(By.xpath("//input[@data-qa='page-su-v1-lname']")).sendKeys("tara");
//        driver.findElement(By.xpath("//input[@data-qa='page-su-v1-pnumber']")).sendKeys("9876543210");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //verify if user landed to Curious how it works? Get a 1-on-1 demo page
        //Verify the page title name
        String curious_title=driver.findElement(By.xpath("//h3[@class='M(0) Fz(--font-size-24) Fw(600)']")).getText();
        Assert.assertEquals(curious_title,"Curious how it works? Get a 1-on-1 demo");
        driver.findElement(By.xpath("//button[normalize-space()='skip & continue to app']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-qa='boxasuraza']"))).click();



        //driver.close();
    }
}
