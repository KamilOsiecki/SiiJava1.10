package basic;

import baseTest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tables extends BaseTest {

    @Test
    @DisplayName("Tables")
    @Tag("Tables")
    public void shouldHandleTable() {
        getChromeAddress();
        operationsOnTable(driver);
    }

    public void operationsOnTable(WebDriver driver) {
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

        for (WebElement row : rows) {
            String state = row.findElement(By.xpath("./td[3]")).getText();
            String height = row.findElement(By.xpath("./td[4]")).getText();

            if (state.contains("Switzerland") && height.startsWith("4")) {
                String rank = row.findElement(By.cssSelector("th")).getText();
                String peak = row.findElement(By.xpath("./td[1]")).getText();
                String mountainRange = row.findElement(By.xpath("./td[2]")).getText();
                System.out.println("Rank: " + rank + " | Peak: " + peak + " | Mountain range: " + mountainRange);
            }
        }
    }

    private void getChromeAddress() {
        driver.get("http://www.seleniumui.moderntester.pl/table.php");
    }
}