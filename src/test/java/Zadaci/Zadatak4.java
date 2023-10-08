package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.google.com");


        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Никола Тесла ћирилица");
        searchBox.submit();


        WebElement firstResult = driver.findElement(By.cssSelector(".tF2Cxc:first-child a"));
        firstResult.click();


        driver.quit();
    }
}
