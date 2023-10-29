package edu.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private final WebDriver webDriver;

    private By orderScooterButton = By.xpath(".//button[text() = 'Заказать']");
    private By secondOrderButton = By.xpath(".//button[1][text() = 'Заказать']");
    private By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    private By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metrostationField = By.xpath("//input[@class='select-search__input']");
    private By metrostation = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[2]");
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");

    //Вторая страница
    private By dateField = By.xpath("//div[@class = 'react-datepicker__input-container']/input");
    private By previosMonth = By.xpath("//div[contains(@class, 'react-datepicker')]//button[contains(text(), 'Previous Month')]");

    private By nextMonth = By.xpath("//div[contains(@class, 'react-datepicker')]//button[contains(text(), 'Next Month')]");
    private By periodDuration= By.xpath("//div[@class='Dropdown-root']");
    private By blackColor = By.id("black");
    private By greyColor = By.id("grey");

    private By commentOrder = By.xpath("//input[@placeholder ='Комментарий для курьера']");

    private By orderButton = By.xpath(".//button[text()='Заказать']");
    private By yesButton = By.xpath(".//button[text()='Да']");

    private SuccessfulOrder successfulOrder;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        successfulOrder = new SuccessfulOrder(webDriver);
    }

    public void open() {
        webDriver.get(URL);
    }

    public void clickOrder() {
        webDriver.findElement(orderScooterButton).click();
    }

    public void clickOrderSecBut() {
        webDriver.findElement(secondOrderButton).click();
    }

    public void inputFirstName(String name) {
        webDriver.findElement(firstNameField).sendKeys(name);
    }

    public void inputLastName(String lastName) {
        webDriver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputAddress(String address) {
        webDriver.findElement(addressField).sendKeys(address);
    }

    public void selectMetroStation(){

        webDriver.findElement(metrostationField).click();
        webDriver.findElement(metrostation).click();
    }

    public void inputPhone(String phone) {
        webDriver.findElement(phoneField).sendKeys(phone);
    }

    public void clicknextButton() {
        webDriver.findElement(nextButton).click();
    }

    public void inputDateOrder(String dateTime){
        webDriver.findElement(dateField).click();
        webDriver.findElement(dateField).sendKeys(dateTime);
        webDriver.findElement(dateField).sendKeys(Keys.ENTER);
    }

    public void choosePreviosMonth(){
        webDriver.findElement(previosMonth).click();
    }

    public void chooseNextMonth(){
        webDriver.findElement(nextMonth).click();
    }

    public void inputOrderDuration(String Duration){
        webDriver.findElement(periodDuration).click();
        webDriver.findElement(By.xpath("//*[text()='"+Duration+"']")).click();
    }

    public void inputColorOrederBlack() {

        webDriver.findElement(blackColor).click();
    }

    public void inputColorOrederGrey() {

        webDriver.findElement(greyColor).click();
    }

    public void inputComments(String comment){

        webDriver.findElement(commentOrder).sendKeys(comment);
    }

    public void clickOrderButton(){
        webDriver.findElement(orderButton).click();
    }


    public void clickConfirmOrder(){
        webDriver.findElement(yesButton).click();
    }

    public SuccessfulOrder successfulOrder() {
        return successfulOrder;
    }



}
