package org.example.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
/*
What it does:
Modern websites can detect when Chrome is being controlled by automated tools (like Selenium) by checking navigator.webdriver and other internal flags.
--disable-blink-features=AutomationControlled disables the Blink engine feature that sets navigator.webdriver to true, making Selenium-driven Chrome look more like a regular user browser.
This can help bypass simple bot-detection scripts on websites.
*/

public class disable_automation_detection {

    @Test
    public void disable_automation_detection() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");  //Helps avoid websites detecting Selenium automation.

        Thread.sleep(3000);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.youtube.com/watch?v=YSCiLNM3zSs&list=RDYSCiLNM3zSs&index=3");
        Thread.sleep(3000);
        driver.quit();

    }
}
