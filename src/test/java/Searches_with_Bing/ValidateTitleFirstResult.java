package Searches_with_Bing;
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
    public static final String BING_URL = "https://www.bing.com";

    @Test
public void validateFirstResult(){

    WebDriver driver = new ChromeDriver();

    driver.get(BING_URL);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    driver.manage().window().maximize();


    WebElement acceptButtonIsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bnp_btn_accept")));
    WebElement acceptButton = driver.findElement(By.id("bnp_btn_accept"));
    acceptButton.click();

    WebElement searchBox = driver.findElement(By.id("sb_form_q"));
    searchBox.sendKeys(SEARCH_INPUT + Keys.ENTER);

    WebElement searchResultsBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b_tween_searchResults")));

    List<WebElement> resultLinks = driver.findElements(By.xpath("//h2/a"));
        var firstResult = resultLinks.get(0);

     Assertions.assertEquals(EXPECTED_RESULT, firstResult.getText(), ERROR_MESSAGE);


    driver.close();
}
}
