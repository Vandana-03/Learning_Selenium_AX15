package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium_Webtables {
//DYNAMIC XPATH for STATIC WEBTABLE

    @Test
    public void webtable()
        {
            ////table[@id='customers']/tbody/tr[5]/td[2]
            WebDriver driver=new ChromeDriver();
            driver.get("https://awesomeqa.com/webtable.html");
            driver.manage().window().maximize();


            String firstpart="//table[@id='customers']/tbody/tr[";
            String secondpart="]/td[";
            String thirdpart="]";

            Integer row=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
            Integer col=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

            for(int i =2; i<=row; i++)
            {
                for(int j=1;j<=col;j++)
                {
                    String final_xpath=firstpart+i+secondpart+j+thirdpart;
                    System.out.println(final_xpath);
                    String data=driver.findElement(By.xpath(final_xpath)).getText();
                    System.out.println(data);
                    if(data.contains("Helen"))
                    {
                        String company_path=final_xpath+"//preceding-sibling::td";
                        String company_path_text=driver.findElement(By.xpath(company_path)).getText();
                        String country_path=final_xpath+"//following-sibling::td";
                        String country_path_text=driver.findElement(By.xpath(country_path)).getText();

                        System.out.println("Helen is in " + company_path_text + " " +country_path_text);

                    }
                }

            }
            driver.quit();
        }
}
