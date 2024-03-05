package model;

import org.openqa.selenium.By;

public enum EOrderButtonBy {
    HEADER(By.className("Button_Button__ra12g")),
    LENDING(By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM"));

    private By orderButtonBy;

    EOrderButtonBy(By by) { this.orderButtonBy = by; }

    public By getOrderButtonBy() { return orderButtonBy; }

}
