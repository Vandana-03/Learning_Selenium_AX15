package org.example.ChromeOptions;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class disableNotifications {
    @Test
    public void notificatons() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");    //Prevents notification popups from websites.

        Thread.sleep(3000);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.youtube.com/watch?v=YSCiLNM3zSs&list=RDYSCiLNM3zSs&index=3");
        Thread.sleep(3000);
        driver.quit();

    }
}
