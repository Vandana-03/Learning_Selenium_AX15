package org.example.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
/*
Useful for responsive testing.
*/

public class custom_browser_window_size {

    @Test
    public void custom_browser_window_size() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        //options.addArguments("--start-maximized");
        options.addArguments("--window-size=1920,1080");  //Useful for responsive testing.

        Thread.sleep(3000);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.youtube.com/watch?v=YSCiLNM3zSs&list=RDYSCiLNM3zSs&index=3");
        Thread.sleep(3000);
        driver.quit();

    }
}
