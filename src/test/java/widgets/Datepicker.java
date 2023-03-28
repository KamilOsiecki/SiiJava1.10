package widgets;

import baseTest.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Datepicker extends BaseTest {

    @Test
    @DisplayName("Datepicker")
    @Tag("Datepicker")
    public void shouldHandleDatePicker() {
        getChromeAddress();
        selectDate(Month.MARCH, 1, "2023");
        Assertions.assertThat(driver.findElement(By.cssSelector("#datepicker")).getAttribute("value")).isEqualTo("03/01/2023");
        driver.navigate().refresh();
        selectDate(Month.APRIL, 15, "2023");
        Assertions.assertThat(driver.findElement(By.cssSelector("#datepicker")).getAttribute("value")).isEqualTo("04/15/2023");
    }

    private void selectDate(Month month, int day, String year) {
        openCalendarWindow();
        goToSelectedDate(month.name(), day, year);
    }

    private void goToSelectedDate(String selectedMonth, int selectedDay, String selectedYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String monthYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();

        String actualMonth = monthYear.split(" ")[0].trim();
        String actualYear = monthYear.split(" ")[1].trim();


        if (Integer.parseInt(selectedYear) > Integer.parseInt(actualYear)) {
            while (!(actualMonth.equals(selectedMonth) && actualYear.equals(selectedYear))) {
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-datepicker-next")));
                driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
                monthYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
                actualMonth = monthYear.split(" ")[0].trim();
                actualYear = monthYear.split(" ")[1].trim();
            }
        } else if (Integer.parseInt(selectedYear) < Integer.parseInt(actualYear)) {
            while (!(actualMonth.equals(selectedMonth) && actualYear.equals(selectedYear))) {
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-datepicker-prev")));
                driver.findElement(By.cssSelector(".ui-datepicker-prev")).click();
                monthYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
                actualMonth = monthYear.split(" ")[0].trim();
                actualYear = monthYear.split(" ")[1].trim();
            }
        }
        selectDay(selectedDay);
    }

    private void getChromeAddress() {
        driver.get("http://automation-practice.emilos.pl/datepicker.php");
    }

    private void openCalendarWindow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("#datepicker")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-datepicker-calendar")));
    }

    private void selectDay(int selectedDay) {
        List<WebElement> day = driver.findElements(By.cssSelector("[class='ui-state-default'], [class*='ui-state-active']," +
                "[class*='ui-state-highlight']"));
        driver.findElement(By.xpath("//a[text()='" + day.get(selectedDay - 1).getText() + "']")).click();
    }
}