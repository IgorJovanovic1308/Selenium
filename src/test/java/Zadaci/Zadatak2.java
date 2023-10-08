package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) {
        //Zadatak 2
//Otvoriti browser i jos 5 tabova
//Na svakom tabu otvoriti URL po zelji
//Zatvoriti sve tabove osim onog gde je otvoren Google

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        //Prethodno smo otvorili jos 5 tabova
        //Sledeci korak nam je da smestimo tabove u listu kako bi mogli da menjamo tabove

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        //Za svaki poseban tab moramo da odradimo switchTo().window() kako bismo presli na zeljeni tab i uneli URL
        driver.switchTo().window(listaTabova.get(0));
        driver.navigate().to("https://www.github.com");

        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://www.youtube.com");

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.linkedin.com");

        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("https://www.joberty.com");

        driver.switchTo().window(listaTabova.get(4));
        driver.navigate().to("https://www.stackoverflow.com");

        driver.switchTo().window(listaTabova.get(5));
        driver.navigate().to("https://www.google.com");

        //Ako hocemo da koristimo najbolji nacin da zatvorimo tabove koji nisu Google
        //Onda moramo da prodjemo kroz sve tabove, izvucemo URL svakog taba
        //i proverimo ga da li je Google
        //u slucaju da nije, onda zatvaramo taj tab

        //Koristimo FOR petlju jer znamo unapred koliko tabova imamo

        for (int i = 0; i < listaTabova.size(); i++) {
            driver.switchTo().window(listaTabova.get(i));
            if (!driver.getCurrentUrl().equals("https://www.google.com/")) {
                driver.close();
            }
        }

        //Ispod je drugi nacin kako mozemo da zatvorimo sve tabove ali je "hardkodovano" jer smo striktno odredili
        //da index 0 ostane otvoren

        /*driver.close();
        driver.switchTo().window(listaTabova.get(4));
        driver.close();
        driver.switchTo().window(listaTabova.get(3));
        driver.close();
        driver.switchTo().window(listaTabova.get(2));
        driver.close();
        driver.switchTo().window(listaTabova.get(1));
        driver.close();*/




    }
}