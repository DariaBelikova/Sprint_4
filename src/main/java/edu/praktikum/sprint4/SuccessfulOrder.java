package edu.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulOrder {

    private WebDriver webDriver;

    private By successfulOrderMassage = By.xpath("//div[contains(@class, 'Order_ModalHeader')]");

    public SuccessfulOrder(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public boolean checkOrderMassage() {
        return webDriver.findElements(successfulOrderMassage).size() > 0;
    }
}
