package org.example.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
/*
open:
http://localhost:9222/json
Copy the webSocketDebuggerUrl for the tab you want.
Example:
ws://localhost:9222/devtools/page/1EA8F5861EDBB1135DAB561C68354080
Open Chrome or another DevTools client and connect to it.
Or just go to the DevTools frontend URL provided in devtoolsFrontendUrl field:
https://chrome-devtools-frontend.appspot.com/serve_rev/.../inspector.html?ws=localhost:9222/devtools/page/1EA8F5861EDBB1135DAB561C68354080
That will open the full DevTools interface for that Selenium-controlled tab.

*/

public class enable_remote_debugging {

    @Test
    public void enable_remote_debugging() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-debugging-port=9222");


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.youtube.com/watch?v=YSCiLNM3zSs&list=RDYSCiLNM3zSs&index=3");
        Thread.sleep(60000);
       // driver.quit();

    }
}
