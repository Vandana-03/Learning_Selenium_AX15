package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium_bookflight_task_march9 {

    @Test
    public void book_ticket() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));


        //close the modal pop up
        WebElement closeicon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //div[@class='e1e158e66b afdff78c97 ce103e449e fe169dc72b']")));
        closeicon.click();

        driver.findElement(By.xpath(" //a[@id='flights']")).click();
        //verify landed on flights page
        String text = driver.findElement(By.xpath("//h1[normalize-space()='Compare and book cheap flights with ease']")).getText();
        Assert.assertEquals(text, "Compare and book cheap flights with ease");
        System.out.println(text);

        //Going to xpath
        WebElement go_to = driver.findElement(By.xpath("//button[@data-ui-name='input_location_to_segment_0']"));
        go_to.click();

        WebElement dest_name = driver.findElement(By.xpath("//input[@data-ui-name='input_text_autocomplete']"));

        Actions act = new Actions(driver);
        act.moveToElement(dest_name)
                .sendKeys(dest_name, "DELHI")
                .pause(Duration.ofSeconds(3))
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .build()
                .perform();

        Thread.sleep(3000);
        WebElement explore_button=driver.findElement(By.xpath("//button[@data-ui-name='button_search_submit']"));
        explore_button.click();

        driver.quit();

    }
}
