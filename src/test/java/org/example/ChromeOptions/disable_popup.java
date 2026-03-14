package org.example.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class disable_popup {

    @Test
        public void dis_popup() throws InterruptedException {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-popup-blocking");    //Allows popups during automation.

            WebDriver driver = new ChromeDriver(options);
            driver.get("https://www.youtube.com/watch?v=YSCiLNM3zSs&list=RDYSCiLNM3zSs&index=3");
            Thread.sleep(3000);
            driver.quit();

        }
}
