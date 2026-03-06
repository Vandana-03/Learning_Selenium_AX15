package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Selenium02 {
    public static void main(String[] args) {
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://ww.google.com");

        FirefoxDriver d1=new FirefoxDriver();
        d1.get("https://www.toolsqa.com/rest-assured-tutorial/");

        EdgeDriver d2=new EdgeDriver();
        d2.get("https://www.udemy.com/course/rest-api-automation-testing-rest-assured/learn/lecture/17541428#overview");

        RemoteWebDriver d9=new ChromeDriver();
        d9=new FirefoxDriver();


    }
}
