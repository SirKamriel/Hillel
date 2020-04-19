package org.kamriel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContexClick {
    WebDriver driver; // создаем переменную драйвер
    @BeforeClass

    public void beforeClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/context_menu");

    }
    @Test
    public void clickOnMenu ()
    {

        WebElement menu = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).contextClick().build().perform();
        checkMessage ();
    }

    public void  checkMessage ()
    {
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(message, "You selected a context menu");

    }
    @AfterClass
    public  void afterClass() {
        if (driver != null) {
            driver.close();
        }
    }


    }
