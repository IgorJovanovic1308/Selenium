package domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTubePlayerTest {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.youtube.com");

        WebElement searchBox = driver.findElement(By.name("search_query"));

        searchBox.sendKeys("Ipce Ahmedovski - Da Ti Guzvam Postelju");

        searchBox.submit();

        Thread.sleep(3000);

        WebElement firstResult = driver.findElement(By.cssSelector("#contents ytd-video-renderer"));
        firstResult.click();

        Thread.sleep(5000);




}

    }


