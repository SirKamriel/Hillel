package org.kamriel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MoveObjeckt {
    WebDriver driver; // создаем переменную драйвер
    @BeforeClass

    public void beforeClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.pureexample.com/jquery-ui/basic-droppable.html");
        Thread.sleep(3000);


    }
    @Test
    public void  moveEllementTest ()
    {

       moveElement ();
    }
    public void moveElement () {


        WebDriver frame = driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ExampleFrame-94']"))); //на этой стрчоке умерли последние нервные клетки


        WebElement drageElement = frame.findElement(By.xpath("//div[@class = 'square ui-draggable']"));
        WebElement dropElement = frame.findElement(By.xpath("//div[@class = 'squaredotted ui-droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drageElement).moveToElement(dropElement).release().build().perform();

        String check = driver.findElement(By.xpath("//div[@id = 'info']")).getText();
        Assert.assertEquals(check, "dropped!");
    }

}
