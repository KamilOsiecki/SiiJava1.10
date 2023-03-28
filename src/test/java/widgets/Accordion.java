package widgets;

import baseTest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Accordion extends BaseTest {

    @Test
    @DisplayName("Accordion")
    @Tag("Accordion")
    public void shouldHandleAccordion() {
        getChromeAddress();
        driver.findElement(By.cssSelector("#ui-id-1")).click();
        System.out.println(driver.findElement(By.cssSelector("#ui-id-2 p")).getText());
        driver.findElement(By.cssSelector("#ui-id-3")).click();
        System.out.println(driver.findElement(By.cssSelector("#ui-id-4 p")).getText());
        driver.findElement(By.cssSelector("#ui-id-5")).click();
        System.out.println(driver.findElement(By.cssSelector("#ui-id-6 p")).getText());
        driver.findElement(By.cssSelector("#ui-id-5")).click();
        System.out.println(driver.findElement(By.cssSelector("#ui-id-6 ul")).getText());
        driver.findElement(By.cssSelector("#ui-id-7")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='ui-id-8']/p[1]")).getText());
        driver.findElement(By.cssSelector("#ui-id-7")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='ui-id-8']/p[2]")).getText());
    }

    private void getChromeAddress() {
        driver.get("http://automation-practice.emilos.pl/accordion.php");
    }
}