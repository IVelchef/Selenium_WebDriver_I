package Searches_with_Google;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ValidateTitleFirstResult {



    // Chrome Version 129.0.6668.71 (Official Build) (arm64).

    public static final String SEARCH_INPUT = "Telerik Academy Alpha";
    public static final String EXPECTED_RESULT = "IT Career Start in 6 Months - Telerik Academy Alpha";

    @Test
    public void validateFirstTitle (){

    WebDriver driver = new ChromeDriver();

    driver.get("https://www.google.com");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();

    WebElement cookieButton = driver.findElement(By.id("L2AGLb"));
    cookieButton.click();

    WebElement searchBox = driver.findElement(By.id("APjFqb"));
    searchBox.sendKeys(SEARCH_INPUT + Keys.ENTER);

    WebElement searchResultsBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

    List<WebElement> resultLinks = driver.findElements(By.xpath("//h3"));
        var firstResult = resultLinks.get(0);

    Assertions.assertEquals(EXPECTED_RESULT, firstResult.getText(), "This result discrepancy has been reported to Telerik Academy");


       driver.quit();

    }
}
