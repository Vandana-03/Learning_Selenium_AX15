package org.example.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
/*
What it does:
Chrome normally blocks or warns you when a website has an invalid, expired, or self-signed SSL certificate.
--ignore-certificate-errors tells Chrome to bypass these warnings, so your Selenium script can continue without interruptions.
This is commonly used in testing environments where self-signed certificates are used.
*/

public class ignore_ssl_certificate_err {

    @Test
    public void ignore_certificate_errors() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");           //Useful when testing non-secure environments.

        Thread.sleep(3000);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.youtube.com/watch?v=YSCiLNM3zSs&list=RDYSCiLNM3zSs&index=3");
        Thread.sleep(3000);
        driver.quit();

    }
}
