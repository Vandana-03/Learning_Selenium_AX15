package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium_input_radio {

    @Test
    public void checkradio(){

        WebDriver driver=new ChromeDriver();
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();

        //Enter first name
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("The testing academy");
        //Enter last name
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Nayana");
        //click on radio button
        driver.findElement(By.xpath("//input[@id='sex-1']")).click();

        //click on YOE
        driver.findElement(By.xpath("//input[@id='exp-5']")).click();
//
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until

    }
}
