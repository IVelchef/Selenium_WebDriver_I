package Searches_with_Google;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateTitleFirstResult {

    public static final String SEARCH_INPUT = "Telerik Academy Alpha";

    @Test
    public void validateFirstTitle (){

    WebDriver driver = new ChromeDriver();

    driver.get("https://www.google.com");
    driver.manage().window().fullscreen();

    WebElement cookieButton = driver.findElement(By.id("L2AGLb"));
    cookieButton.click();

    WebElement searchBox = driver.findElement(By.id("APjFqb"));
    //searchBox.click();
    searchBox.sendKeys(SEARCH_INPUT + Keys.ENTER);







driver.close();




    }
}
