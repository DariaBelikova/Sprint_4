package edu.praktikum.sprint4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class Order {


    private WebDriver webDriver;

    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String dateOrder;
    private String orderDuration;
    private String comment;

    public Order(String firstName, String lastName, String address, String phone, String dateOrder, String orderDuration, String comment) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.dateOrder = dateOrder;
        this.orderDuration = orderDuration;
        this.comment = comment;
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Parameterized.Parameters
    public static Object[][] getTestDataOrder() {
        return new Object[][] {
                {"Гермиона", "Гренджер", "Тисовая улица 2", "98765432198", "30.10.2023", "трое суток", "Комментарий"},
                {"Гермиона", "Гренджер", "Тисовая улица, 2", "9876543219", "01.11.2023", "двое суток"},
    };}


    @Test
    public void doOrderButtonOnFutter() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();
        mainPage.clickOrder();
        mainPage.inputFirstName(firstName);
        mainPage.inputLastName(lastName);
        mainPage.inputAddress(address);
        mainPage.selectMetroStation();
        mainPage.inputPhone(phone);
        mainPage.clicknextButton();

        mainPage.inputDateOrder(dateOrder);
        mainPage.inputOrderDuration(orderDuration);
        mainPage.inputColorOrederBlack();
        mainPage.inputComments(comment);

        mainPage.clickOrderButton();
        assertTrue("Нет перехода на страницу с информацией об успешно сделаном заказе.", mainPage.successfulOrder().checkOrderMassage());


    }

    @Test
    public void doOrderButtonOnMiddlePage() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();
        mainPage.clickOrderSecBut();
        mainPage.inputFirstName(firstName);
        mainPage.inputLastName(lastName);
        mainPage.inputAddress(address);
        mainPage.selectMetroStation();
        mainPage.inputPhone(phone);
        mainPage.clicknextButton();

        mainPage.inputDateOrder(dateOrder);
        mainPage.inputOrderDuration(orderDuration);
        mainPage.inputColorOrederBlack();
        mainPage.inputComments(comment);

        mainPage.clickOrderButton();
        assertTrue("Нет перехода на страницу с информацией об успешно сделаном заказе.", mainPage.successfulOrder().checkOrderMassage());


    }
   /* @Test
    public void doOrder_1() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();
        mainPage.clickOrder();
        mainPage.inputFirstName("Гермиона");
        mainPage.inputLastName("Гренджер");
        mainPage.inputAddress("Тисовая улица 2");
        mainPage.selectMetroStation();
        mainPage.inputPhone("98765432198");
        mainPage.clicknextButton();

        mainPage.inputDateOrder("30.10.2023");
        mainPage.inputOrderDuration("трое суток");
        mainPage.inputColorOrederBlack();
        mainPage.inputComments("Комментарий");

        mainPage.clickOrderButton();
        assertTrue("Нет перехода на страницу с информацией об успешно сделаном заказе.", mainPage.successfulOrder().checkOrderMassage());

    }

    @Test
    public void doOrder_2() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();
        mainPage.clickOrderSecBut();
        mainPage.inputFirstName("Гарри");
        mainPage.inputLastName("Поттер");
        mainPage.inputAddress("Тисовая улица, 2");
        mainPage.selectMetroStation();
        mainPage.inputPhone("98765432198");
        mainPage.clicknextButton();

        mainPage.inputDateOrder("01.11.2023");
        mainPage.inputOrderDuration("двое суток");
        mainPage.inputColorOrederGrey();

        mainPage.clickOrderButton();
        assertTrue("Нет перехода на страницу с информацией об успешно сделаном заказе.", mainPage.successfulOrder().checkOrderMassage());

    }*/

    @After

    public void tearDown() {
        webDriver.quit();
    }



}
