package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class seleniumTask27Feb {

    @Test
    public void tta_bank() throws InterruptedException {
        WebDriver driver=new ChromeDriver();;
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");
        driver.manage().window().maximize();
        //Click on signup
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
        Thread.sleep(2000);
        // verify landed on sign up page
        WebElement signup_titlename=driver.findElement(By.xpath("//h1[text()='TTA Bank']"));
        Assert.assertEquals(signup_titlename.getText(),"TTA Bank");
        Thread.sleep(1000);
        //Enter name
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Test");
        //Enter email
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Test@gmail.com");
        //Enter password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@gmail.com");
        //Click create account
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        //Verify landed on Dashboard
        driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText().equalsIgnoreCase("Dashboard");
        //Verify initial balance
        String Total_balance=driver.findElement(By.xpath("//h3[@class='mt-2 text-3xl font-bold']")).getText();

        //Click on transfer funds
        driver.findElement(By.xpath("//button[text()='Transfer Funds']")).click();
        //Verify landed on transfer page
        WebElement transfer_fund_page=driver.findElement(By.xpath("//h1[text()='Transfer Funds']"));
        Assert.assertEquals(transfer_fund_page.getText(),"Transfer Funds");


        WebElement transfer_amount=driver.findElement(By.xpath("//input[@type='number']"));
        transfer_amount.sendKeys("5000");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("passing amount");

        //Click on continue
        driver.findElement(By.xpath("//button[text()='Continue']")).click();
        //click on confirm transfer
        driver.findElement(By.xpath("//div[@class='flex gap-4']/button[2]")).click();
        //Click on dashboard button
        driver.findElement(By.xpath("//nav[@class='space-y-1 px-3']/button[1]")).click();

        //Verify if the correct amount was deducted
        String balance_amount=driver.findElement(By.xpath("//h3[@class='mt-2 text-3xl font-bold']")).getText();
        System.out.println(balance_amount);
        Assert.assertEquals(balance_amount,"$45,000.00");
        driver.quit();

    }

}
