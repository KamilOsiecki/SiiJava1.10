package widgets;

import baseTest.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Autocomplete extends BaseTest {

    @Test
    @DisplayName("Autocomplete")
    @Tag("Autocomplete")
    public void shouldHandleAutocomplete() {
        getChromeAddress();
        driver.findElement(By.cssSelector("#search")).sendKeys("a");
        List<WebElement> searchValues = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
        for (WebElement searchValue : searchValues) {
            System.out.println(searchValue.getText());
        }
        Random random = new Random();
        int searchValueIndex = random.nextInt(searchValues.size());
        searchValues.get(searchValueIndex).click();
        Assertions.assertThat(driver.findElement(By.cssSelector("#search")).getText()).isEqualTo(searchValues.get(searchValueIndex).getText());
    }

    private void getChromeAddress() {
        driver.get("http://automation-practice.emilos.pl/autocomplete.php");
    }
}