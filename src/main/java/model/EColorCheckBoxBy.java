package model;

import org.openqa.selenium.By;

public enum EColorCheckBoxBy {
    GREY(By.xpath("//input[@id='grey']")),
    BLACK(By.xpath("//input[@id='black']"));

    private By byColorCheckBox;

    EColorCheckBoxBy(By by) {
        this.byColorCheckBox = by;
    }

    public By getByColorCheckBox() { return byColorCheckBox; }

}
