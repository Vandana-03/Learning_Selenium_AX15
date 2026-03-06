package org.example;
import static org.assertj.core.api.Assertions.*;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTask_01 {


    @Owner("Vandana")
    @TmsLink("https://aprateek040.atlassian.net/browse/SCRUM-7")
    @Severity(SeverityLevel.MINOR)
    @Description ("Verify  navigate to katalon page")
    @Test
    public void Katalon_launch(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com");
        driver.manage().window().maximize();

        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");

//        assertThat(driver.getTitle())
//                    .isNotBlank()
//                    .isNotBlank()
//                    .isNotNull()
//                            .isEqualTo("CURA Healthcare Service");
        WebElement e1=driver.findElement(By.id("btn-make-appointment"));
//        System.out.println("e1=" + e1);
//        System.out.println("e1=" + e1.getText());
//        System.out.println("e1=" + e1.getTagName());


        e1.click();
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        //driver.quit();
    }}

//
//
//        //enter the user cred
//        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
//        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
//        driver.findElement(By.id("btn-login")).click();
//



