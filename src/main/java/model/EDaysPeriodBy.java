package model;

import org.openqa.selenium.By;

public enum EDaysPeriodBy {
    ONE(By.xpath(".//div[text()='сутки']")),
    SEVEN(By.xpath(".//div[text()='семеро суток']"));

    private By daysPeriod;

    EDaysPeriodBy(By by) {
        this.daysPeriod = by;
    }

    public By getByDaysPeriod() { return daysPeriod; }
}
