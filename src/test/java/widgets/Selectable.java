package widgets;

import baseTest.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

@Execution(ExecutionMode.CONCURRENT)
public class Selectable extends BaseTest {
    Random random = new Random();

    @Test
    @DisplayName("Select random speed")
    @Tag("Widgets")
    public void shouldSelectRandomSpeedValue() {
        getChromeAddress();
        driver.findElement(By.cssSelector("#speed-button")).click();
        List<WebElement> speedValue = driver.findElements(By.cssSelector("#speed-menu li"));
        int speedIndex = random.nextInt(speedValue.size());
        speedValue.get(speedIndex).click();
        String actualMenuValue = driver.findElement(By.cssSelector("#speed-menu")).getText();
        Assertions.assertThat(speedValue.get(speedIndex).getText()).isEqualTo(actualMenuValue);
    }

    @Test
    @DisplayName("Select a file by text")
    @Tag("Widgets")
    public void shouldSelectSelectFileByText() {
        getChromeAddress();
        driver.findElement(By.cssSelector("#files-button")).click();
        driver.findElement(By.xpath("//div [.='ui.jQuery.js']")).click();
        String selectedFileName = driver.findElement(By.xpath("//div [.='ui.jQuery.js']")).getText();
        String actualFile = driver.findElement(By.cssSelector("#files-menu")).getText();
        Assertions.assertThat(selectedFileName).isEqualTo(actualFile);
    }

    @Test
    @DisplayName("Select a number by index")
    @Tag("Widgets")
    public void shouldSelectSelectNumberByIndex() {
        getChromeAddress();
        driver.findElement(By.cssSelector("#number-button")).click();
        driver.findElement(By.xpath("//*[@id='number-menu']/li[11]")).click();
        String selectedNumber = driver.findElement(By.xpath("//*[@id='number-menu']/li[11]")).getText();
        String actualNumber = driver.findElement(By.cssSelector("#number-menu")).getText();
        Assertions.assertThat(selectedNumber).isEqualTo(actualNumber);
    }

    @Test
    @DisplayName("Select a random title")
    @Tag("Widgets")
    public void shouldSelectSelectRandomTitle() {
        getChromeAddress();
        driver.findElement(By.cssSelector("#salutation-button")).click();
        List<WebElement> salutationOption = driver.findElements(By.cssSelector("#salutation-menu li"));
        int salutationOptionIndex = random.nextInt(1, salutationOption.size());
        salutationOption.get(salutationOptionIndex).click();
        String selecteSalutationValue = driver.findElement(By.cssSelector("#salutation-menu")).getText();
        Assertions.assertThat(salutationOption.get(salutationOptionIndex).getText()).isEqualTo(selecteSalutationValue);
    }

    private void getChromeAddress() {
        driver.get("http://automation-practice.emilos.pl/selectmenu.php");
    }
}