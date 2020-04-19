package org.kamriel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonFirstTest {

    WebDriver driver; // создаем переменную драйвер
    @BeforeClass

    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }



@Test
    public void jsButtonAcceptTests() throws InterruptedException {




        //тест 1

        driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click();
       driver.switchTo().alert().accept();
       Thread.sleep(5000);

       String text = driver.findElement(By.id("result")).getText();
       Assert.assertEquals(text, "You clicked: Ok");


    }
    @Test
    public void jsButtonCancelTests() throws InterruptedException {




        //тест 1

        driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        Thread.sleep(5000);

        String text = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(text, "You clicked: Cancel");


    }
    @Test
    public void promptButtonAcceptTests() throws InterruptedException {




        //тест 1

        driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();

        driver.switchTo().alert().sendKeys("555");
        driver.switchTo().alert().accept();
        String text = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(text, "You entered: 555");

        Thread.sleep(5000);



    }
    @Test
    public void promptButtonDissmissTests() throws InterruptedException {




        //тест 1

        driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();

        driver.switchTo().alert().sendKeys("555");
        driver.switchTo().alert().dismiss();
        String text = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(text, "You entered: null");

        Thread.sleep(5000);



    }
    @AfterClass
    public  void afterClass() {
        if (driver !=null){
            driver.close();
        }

    }
}
