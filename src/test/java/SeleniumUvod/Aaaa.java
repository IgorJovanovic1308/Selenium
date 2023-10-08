package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Aaaa {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");


        /*KUCAS U GUGLU SA STRINGOM
        String ime = "Никола Тесла";
        WebElement googleSearchBar = driver.findElement(By.name("q"));  q JE ISKOPIRANO IZ NAME.
        googleSearchBar.sendKeys(ime); */



        //KUCAS U GUGLU UZ POMOC ID-a
        WebElement googleSearchBox = driver.findElement(By.id("APjFqb")); //KOD U ZAGRADI DOBIJAS TAKO STO ISKOPIRAS ID
        googleSearchBox.sendKeys("Никола Тесла"); //OVDE USTVARI PISES STA HOCES

        //CEKANJE - KORISTIS DA SE UCITAJU STVARI SA STRANICE PA DA ONDA KLIKNES NA NESTO. KAD JE SLEEP CRVENO STISNI ALT + ENTER
        Thread.sleep(2000);

        //KLIK NA SEARCH (BY NAME)
        WebElement googleSearchButton = driver.findElement(By.name("btnK")); //KOD U ZAGRADI DOBIJAS TAKO STO ISKOPIRAS NAME
        googleSearchButton.click();


        //DA IZABERES WIKIPEDIU UZ POMOC CssSelektora (DOBIJENOG IZ KLASE)
        WebElement wikipedia = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md")); //KOD U ZAGRADI JE USTVARI KOPIRANA KLASA I DODATE JOJ TACKE UMESTO RAZMAKA
        wikipedia.click();

        /*LOKATORI:

        //ID - najmanje podlozan promenama i jedinstven element*
        //Name
        //Class
        //CssSelector
        //Relative Xpath
        //Absolute Xpath

        WebElement searchBoxByID = driver.findElement(By.id("APjFqb"));
        WebElement searchBoxByName = driver.findElement(By.name("q"));
        WebElement searchBoxByClass = driver.findElement(By.className("gLFyf"));
        WebElement searchBoxByCSS = driver.findElement(By.cssSelector("textarea[type='search']"));
        WebElement searchBoxByRelativeXpath = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        WebElement searchBoxByAbsoluteXpath = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea")); */






        //ASSERTACIJA - TESTIRA. OBICNO SE RADE 2-3 ASERTACIJE.



        // U OVOM SLUCAJU POREDI URL ADRESE. ISTE SU I SVE JE OK. AKO NESTO PROMENIS U OVOM WIKIPEDIA URL-u - TEST PADA
        String expectedURL = "https://sr.wikipedia.org/sr-ec/%D0%9D%D0%B8%D0%BA%D0%BE%D0%BB%D0%B0_%D0%A2%D0%B5%D1%81%D0%BB%D0%B0";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);


        // OVDE UPOREDJUJE URL I TEKST SA STRANICE. SVE JE OK. AKO BI PROMENILI NESTO U "Никола Тесла" - TEST PADA.
        WebElement pageTitle = driver.findElement(By.className("mw-page-title-main"));
        String pageTitleText = pageTitle.getText();
        String expectedTitleText = "Никола Тесла";

        Assert.assertEquals(pageTitleText, expectedTitleText);


        //OVDE GLEDA DA LI POSTOJI TESLINA SLIKA NA STRANICI.
        WebElement pageImage = driver.findElement(By.className("infobox-image"));

        Assert.assertTrue(pageImage.isDisplayed()); //AKO BI STAVIO assertFalse - TEST BI PAO JER BI OCEKIVALI DA SLIKA NE POSTOJI, A ONA POSTOJI.







        //ZA PROVERAVANJE ELEMENATA IZ HTML CTRL C PA CTR F.




        //KOD ZA SCROLL
        WebElement element = driver.findElement(By.id("id_of_element"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);





    }


}