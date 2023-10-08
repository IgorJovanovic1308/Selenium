package domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Demoqa {
        public static void main(String[] args) throws InterruptedException {

                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();

                driver.navigate().to("https://demoqa.com/text-box");

                Thread.sleep(5000);

                WebElement fullNameBox = driver.findElement(By.id("userName"));
                fullNameBox.sendKeys("Stefan");

                WebElement emailBox = driver.findElement(By.id("userEmail"));
                emailBox.sendKeys("s@g.com");

                WebElement currentAddressBox = driver.findElement(By.id("currentAddress"));
                currentAddressBox.sendKeys("Ulica");

                WebElement permanentAddressBox = driver.findElement(By.id("permanentAddress"));
                permanentAddressBox.sendKeys("Druga ulica");

                WebElement submitButton = driver.findElement(By.id("submit"));
                submitButton.click();


                String expectedUrl = "https://demoqa.com/text-box";
                Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);


                WebElement information = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]"));
                Assert.assertTrue(information.isDisplayed());

        }

}