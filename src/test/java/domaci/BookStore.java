package domaci;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookStore {
    WebDriver driver;
    WebDriverWait wait;
    WebElement userName;
    WebElement login;
    WebElement password;
    WebElement loginButton;
    Set<Cookie> cookies;

    WebElement logout;
    WebElement book1;
    WebElement book2;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.navigate().to("https://demoqa.com/");
        openCard("Book Store Application");
        Thread.sleep(1000);
        login = driver.findElement(By.id("login"));
        login.click();
        Thread.sleep(2000);
        login();
        cookies = new HashSet<>();

    }

    @BeforeMethod
    public void beforeMetoda() throws InterruptedException {
        Thread.sleep(2000);
        setCookies();
        Thread.sleep(2000);
        driver.navigate().to("https://demoqa.com/");
        driver.navigate().refresh();


    }

    public void openCard(String cardName) {
        List<WebElement> card = driver.findElements(By.className("card-body"));
        for (int i = 0; i < card.size(); i++) {
            if (card.get(i).getText().equals(cardName)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card.get(i));
                card.get(i).click();
                break;
            }
        }

    }

    public void login() {
        userName = driver.findElement(By.id("userName"));
        password = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.id("login"));
        userName.sendKeys("Igor2023");
        password.sendKeys("@Igor2023");
        loginButton.click();
    }

    public void getCookies() {
        cookies.add(driver.manage().getCookieNamed("token"));
        cookies.add(driver.manage().getCookieNamed("userID"));
        cookies.add(driver.manage().getCookieNamed("expires"));
        cookies.add(driver.manage().getCookieNamed("userName"));

    }

    public void setCookies() {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public void logout() {
        logout = driver.findElement(By.id("submit"));
        logout.click();
    }

    @Test
    public void testAdd10() throws InterruptedException {

        openCard("Book Store Application");
        Thread.sleep(2000);
        book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        book1.click();
        Thread.sleep(2000);
        WebElement add1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"));
        add1.click();
        driver.navigate().back();

        book2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        book2.click();
        WebElement add2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"));
        add2.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        goToProfileCheckPics();

    }
    @Test
    public void testAddLogoutCheckAgain20() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/");
        openCard("Book Store Application");
        Thread.sleep(1000);
        login = driver.findElement(By.id("login"));
        login.click();
        Thread.sleep(2000);
        login();
        Thread.sleep(2000);
        goToProfileCheckPics();
    }

    public void goToProfileCheckPics() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/profile");
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.linkText("Git Pocket Guide")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("Learning JavaScript Design Patterns")).isDisplayed());
    }


    @AfterMethod
    public void after() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }


    @AfterClass
    public void cleanUp() {
        driver.quit();
    }
}

