package org.example.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
/*
What it does:
Chrome normally runs in a sandbox mode to isolate processes and improve security.
--no-sandbox disables this isolation, which can help in certain environments like Docker containers, CI/CD pipelines, or Linux servers, where sandboxing might prevent Chrome from starting.
Important: Disabling the sandbox reduces security, so it’s safe only in controlled testing environments, not for general browsing.
*/

public class Disable_browser_sandbox {

    @Test
    public void disable_browser_sandbox() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");


        Thread.sleep(3000);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.youtube.com/watch?v=YSCiLNM3zSs&list=RDYSCiLNM3zSs&index=3");
        Thread.sleep(3000);
        driver.quit();

    }
}
