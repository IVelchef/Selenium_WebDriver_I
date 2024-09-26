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


    // Chrome Version 129.0.6668.71 (Official Build) (arm64)

    public static final String SEARCH_INPUT = "Telerik Academy Alpha";
    public static final String EXPECTED_RESULT = "IT Career Start in 6 Months - Telerik Academy Alpha";
    public static final String ERROR_MESSAGE = "The title of the first result did not match. This issue has already been reported to Telerik Academy";
    public static final String GOOGLE_URL = "https://www.google.com";

    @Test
    public void validateFirstTitle() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            driver.get(GOOGLE_URL);
            driver.manage().window().maximize();

            WebElement cookieButton = driver.findElement(By.id("L2AGLb"));
            cookieButton.click();

            WebElement searchBox = driver.findElement(By.id("APjFqb"));
            searchBox.sendKeys(SEARCH_INPUT + Keys.ENTER);

            WebElement searchResultsBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

            List<WebElement> resultLinks = driver.findElements(By.xpath("//h3"));
            var firstResult = resultLinks.get(0);

            Assertions.assertEquals(EXPECTED_RESULT, firstResult.getText(), ERROR_MESSAGE);

        } finally {
            driver.quit();

        }
    }
}