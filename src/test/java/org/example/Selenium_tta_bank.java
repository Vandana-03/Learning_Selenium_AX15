package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium_tta_bank {
    @Test
    public void tta_op() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");
        Thread.sleep(3000);


        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
        WebElement email= driver.findElement(By.xpath("//input[@type='text']]"));
        //email.clear();
        email.sendKeys("mary@gmail.com");
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
       // password.clear();
        password.sendKeys("123");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

        //driver.quit();
    }

}
