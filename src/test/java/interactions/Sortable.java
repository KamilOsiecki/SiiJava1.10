package interactions;

import baseTest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Collections;
import java.util.List;

public class Sortable extends BaseTest {

    @Test
    @DisplayName("Sortable")
    @Tag("Sortable")
    public void shouldHandleSortable() {
        Actions actions = new Actions(driver);
        getChromeAddress();
        List<WebElement> items = driver.findElements(By.cssSelector("#sortable>li"));
        Collections.shuffle(items);
        for (WebElement item : items) {
            System.out.println(item.getText());
        }
        for (int i = items.size()-1; i >= 0; i--){
            WebElement item1 = items.get(i);
            WebElement item2 = items.get(i-1);
            actions.dragAndDrop(item2, item1).build().perform();
        }
    }

    private void getChromeAddress() {
        driver.get("http://automation-practice.emilos.pl/sortable.php");
    }
}