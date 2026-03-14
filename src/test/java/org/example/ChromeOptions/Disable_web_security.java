package org.example.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
/*
What it does
Disables Same-Origin Policy (SOP) in Chrome.
Allows a webpage to make requests to different domains without being blocked.
Useful when testing CORS (Cross-Origin Resource Sharing) issues in development environments.
*/

public class Disable_web_security {

    @Test
    public void enable_remote_debugging() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.youtube.com/watch?v=YSCiLNM3zSs&list=RDYSCiLNM3zSs&index=3");
        Thread.sleep(60000);
       // driver.quit();

    }
}
