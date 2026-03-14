package org.example.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

//instead of infobars you can use this method
public class setExperimentalOption_methods {
    @Test
    public void setExperimentalOption_methods() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Hides 'Chrome is being controlled by automated test software'
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // Optional: remove 'webdriver' property detection
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.flipkart.com/");
        driver.quit();

    }
}
