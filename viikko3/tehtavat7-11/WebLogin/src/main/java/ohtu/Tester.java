package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        WebElement element4 = driver.findElement(By.linkText("logout"));
        element4.click();
        
        sleep(2);
        
        // Invalid login
        
        WebElement element5 = driver.findElement(By.linkText("login"));
        element5.click();

        sleep(2);

        element5 = driver.findElement(By.name("username"));
        element5.sendKeys("pekka");
        element5 = driver.findElement(By.name("password"));
        element5.sendKeys("mekka");
        element5 = driver.findElement(By.name("login"));
        
        sleep(2);
        element5.submit();
        
        sleep(3);
        
        WebElement element6 = driver.findElement(By.linkText("back to home"));
        element6.click();
        
        sleep(2);
        
        // Sign up
        
        WebElement element2 = driver.findElement(By.linkText("register new user"));
        element2.click();

        sleep(2);

        element2 = driver.findElement(By.name("username"));
        Random r = new Random();
        element2.sendKeys("ramona"+r.nextInt(100000));
        element2 = driver.findElement(By.name("password"));
        element2.sendKeys("hamlet123");
        element2 = driver.findElement(By.name("passwordConfirmation"));
        element2.sendKeys("hamlet123");
        element2 = driver.findElement(By.name("signup"));
        
        sleep(2);
        element2.submit();
        
        sleep(3);
        
        // Log out
        
        WebElement element3 = driver.findElement(By.linkText("continue to application mainpage"));
        element3.click();

        sleep(2);
        
        WebElement element7 = driver.findElement(By.linkText("logout"));
        element7.click();
        
        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
