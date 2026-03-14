package org.example.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
/*
Useful for responsive testing.
*/

public class disable_password_save_popup {

    @Test
    public void disable_password_save_popup() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-save-password-bubble"); //options.addArguments("--disable-save-password-bubble");

        Thread.sleep(3000);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.youtube.com/watch?v=YSCiLNM3zSs&list=RDYSCiLNM3zSs&index=3");
        Thread.sleep(3000);
        driver.quit();

    }
}
