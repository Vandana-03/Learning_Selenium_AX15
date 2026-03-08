package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium_orange_hrm {
    @Test
    public void test_hrm() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(10000);
        WebElement Title_text=driver.findElement(By.xpath("//h6[text()='PIM']"));

        Assert.assertEquals(Title_text.getText(),"PIM");
        driver.quit();
    }
}
