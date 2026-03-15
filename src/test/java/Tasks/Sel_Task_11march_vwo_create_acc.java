package Tasks;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.FileInputStream;
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
        options.addArguments("--disable-notifications");

        driver=new ChromeDriver(options);
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
    }
    @Test
    public void vwo() throws InterruptedException {

        String parentWindow=driver.getWindowHandle();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebDriverWait longwait=new WebDriverWait(driver,Duration.ofSeconds(40));

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

        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        WebElement email=driver.findElement(By.xpath("(//input[@name='email'])[1]"));
        email.sendKeys("palepink.94@memorimail.com");

        driver.findElement(By.xpath("//input[@id='page-free-trial-step1-cu-gdpr-consent-checkbox']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify if landed on Sign up for a full-featured trial page
        String signup_title=driver.findElement(By.xpath("//h1[normalize-space()='Sign up for a full-featured trial']")).getText();
        Assert.assertEquals(signup_title,"Sign up for a full-featured trial");

        //Enter the details of the signup page
        WebElement fname=longwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='page-v1-fname']")));
        fname.sendKeys("Navya");
        driver.findElement(By.xpath("//input[@id='page-v1-lname']")).sendKeys("Nair");
        driver.findElement(By.xpath("//input[@id='page-v1-pnumber']")).sendKeys("9876787676");
        WebElement create_account_button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Create Account']")));
        create_account_button.click();

        //verify if user landed to Curious how it works? Get a 1-on-1 demo page
        //Verify the page title name
        try {
            WebElement curious_title=driver.findElement(By.xpath("//h3[@class='M(0) Fz(--font-size-24) Fw(600)']"));
            longwait.until(ExpectedConditions.visibilityOf(curious_title));
            Assert.assertEquals(curious_title.getText(),"Curious how it works? Get a 1-on-1 demo");
        } catch (Exception e) {
            System.out.println("TEXT Curious how it works? Get a 1-on-1 demo not found!!!!!!!!");
        }

        WebElement skip_and_continue=longwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='skip & continue to app']")));
        skip_and_continue.click();
        Thread.sleep(20000);

        try {
            driver.findElement(By.xpath("//button[@vwo-async-click='vm.continueSetup()']")).click();
        }
        catch (Exception e)
        {
            System.out.println("Continue button not found so skipping the test case");
        }
        Thread.sleep(20000);
        driver.navigate().refresh();
        Thread.sleep(60000);
        //Expand Choose a data center
        try {
            driver.findElement(By.xpath("//h5[text()='Choose a data centre']")).click();
            longwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-qa='boxasuraza']"))).click();
            //Thread.sleep(60000);
        } catch (Exception e) {
            System.out.println("exception occurred near choose a data centre");
        }
        Thread.sleep(20000);
        driver.navigate().refresh();
        Thread.sleep(20000);

        try {
            WebElement svg_button=longwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@data-qa = 'cunoxonoxe']//*[local-name() = 'svg'])[2]")));
            svg_button.click();

        } catch (Exception e) {
            System.out.println("start free trial exception occurred");
        }
        Thread.sleep(20000);
        try {
            driver.findElement(By.xpath("//button[contains(text(), 'Add domain')]")).click();
        } catch (Exception e) {
            System.out.println("add domain button exception occurred");
        }
        Thread.sleep(40000);
        WebElement copy_link=driver.findElement(By.xpath("//button[@vwo-title='Copy']"));
        copy_link.click();

        // Opens a new tab and automatically switches Selenium's focus to it
        driver.switchTo().newWindow(WindowType.TAB);
        // Now you can navigate to a new URL in this new tab
        driver.get("https://www.google.com");
        //Find the actual Google Search box (its HTML name attribute is "q")
        WebElement googleSearchBox = driver.findElement(By.className("gLFyf"));

        Actions act=new Actions(driver);
        act.keyDown(Keys.CONTROL)
                .sendKeys("V")
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        String copiedtext=googleSearchBox.getAttribute("value");
        if(copiedtext.contains("visualwebsiteoptimizer"))
            System.out.println("Verification passed");
        else {
            System.out.println("failed");
        }



        //driver.close();
    }
}
