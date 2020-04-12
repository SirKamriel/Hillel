package org.kamriel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.management.Descriptor;
import javax.xml.bind.Element;
import java.util.concurrent.TimeUnit;

public class Lpa {
    WebDriver driver; // создаем переменную драйвер
   String lpaUrl = "https://15457.lpa.apt-petrosoftinc.com:12501/lpa/status/";

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(lpaUrl);
        Thread.sleep(7000);

    }

     // Открываем страницу, еслинужно логиниться, логинимся
    public void loginTests() throws InterruptedException {

        Thread.sleep(3000);
        String curentUrl = driver.getCurrentUrl();


        if ( curentUrl.contains("https://kc.petrosoft.cloud/"))
        {
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys("o.karpishyn@petrosoftinc.com");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("Kamriel#2380");
            driver.findElement(By.id("kc-login")).click();
            Thread.sleep(7000);
        }
        else {
           // curentUrl.contains("https://kc.petrosoft.cloud/") &&

        }



//        driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[2]/button")).click();
//        driver.switchTo().alert().accept();
//        Thread.sleep(5000);
//
//        String text = driver.findElement(By.id("result")).getText();
//        Assert.assertEquals(text, "You clicked: Ok");
//        driver.close();

    }


    @Test // Проверка имени станции станции
    public void checkStationNameTest () throws InterruptedException {

        loginTests();


        String station = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div[1]")).getText();
        Assert.assertEquals(station, "Station: ODLab_DCBox-501_3");
       // driver.close();

    }
    @Test // Проверка имени станции станции
    public void checkAccountNameTest () throws InterruptedException {

        loginTests();


        String account = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div[2]")).getText();
        Assert.assertEquals(account, "Account: QwickserveQA");
        //driver.close();

    }
    @Test // Проверка имени станции станции
    public void checkAnableCameraOneTest () throws InterruptedException {

        loginTests();


            driver.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div[1]/div/div/div[2]/div/div/div[1]/div/div/div[1]/div[1]/video"));
       // driver.close();

    }
    @Test
    public void checkAnableCameraTwoTest () throws InterruptedException {

        loginTests();


        driver.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div[1]/div/div/div[2]/div/div/div[1]/div/div/div[2]/div[1]/video"));
       // driver.close();
    }
    @Test
    public void checkAnableCameraThreeTest () throws InterruptedException {

        loginTests();


        driver.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div[1]/div/div/div[2]/div/div/div[1]/div/div/div[3]/div[1]/video"));
       // driver.close();
    }
    @Test
    public void checkAnableCameraFourTest () throws InterruptedException {

        loginTests();


        driver.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div[1]/div/div/div[2]/div/div/div[1]/div/div/div[4]/div[1]/video"));
        //driver.close();
    }





}
