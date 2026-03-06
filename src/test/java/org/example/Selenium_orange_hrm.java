package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium_orange_hrm {
    @Test
    public void test_hrm() {
        WebDriver driver= new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        driver.quit();
    }
}
