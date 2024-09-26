package fireFoxTests.Searches_with_Google;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static configuration.testConstants.*;

public class ValidateTitle_Firefox_Google {


    // Firefox version: 130.0.1 (64-bit)


    @Test
    public void validateTitleFirstResult() {

        WebDriver driver = new FirefoxDriver();
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