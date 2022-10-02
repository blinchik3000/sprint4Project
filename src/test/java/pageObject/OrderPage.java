package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class OrderPage {
    private WebDriver driver;

    //Order fields first page

    //name field xpath
    private By orderFirstPageFieldName = By.xpath(".//input[@placeholder='* Имя']");
    //Surname field xpath
    private By orderFirstPageFieldSurname = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']");
    //address field xpath
    private By orderFirstPageFieldAddress = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']");
    //subway station field xpath
    private By orderFirstPageFieldSubwayStation = By.className("select-search__input");
    //subway station list xpath
    private By orderFirstPageFieldSubwayStationList = By.xpath(".//div[@class='select-search__select'][1]");
    //phone number xpath
    private By orderFirstPageFieldPhoneNumber = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Телефон: на него позвонит курьер']");

    //Order fields second page
    //order date xpath
    private By orderSecondPageFieldOrderDate = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Когда привезти самокат']");
    //order date selected after send keys xpath
    private By orderSecondPageFieldOrderDateSelected = By.xpath(".//div[@class='react-datepicker__month-container']//div[contains(@class, 'selected')]");
    //rental period xpath
    private By orderSecondPageFieldRentalPeriod = By.className("Dropdown-placeholder");
    //rental period sublist variable
    private By orderSecondPageFieldRentalPeriodSublist ;
    //black colour checkbox xpath
    private By orderSecondPageFieldBlackColourCheckbox =By.id("black");
    //white colour checkbox xpath
    private By orderSecondPageFieldWhiteColourCheckbox =By.id("gray");
    //comment xpath
    private By orderSecondPageFieldComment = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='Комментарий для курьера']");
    //Buttons
    private By orderFirstPageNextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");
    private By orderSecondPageOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private By orderSecondPageBackButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Назад'");
    private By orderSecondPageModalYesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private By orderSecondPageModalNoButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Нет'");
    private By successOrderForm = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Buttons click
    public void orderFirstPageNextButtonClick(){
        driver.findElement(orderFirstPageNextButton).click();
    }
    public void orderSecondPageOrderButtonClick(){
        driver.findElement(orderSecondPageOrderButton).click();
    }
    public void orderSecondPageBackButtonClick(){
        driver.findElement(orderSecondPageBackButton).click();
    }
    public void orderSecondPageModalYesButtonClick(){
        driver.findElement(orderSecondPageModalYesButton).click();
    }
    public void orderSecondPageModalNoButtonClick(){
        driver.findElement(orderSecondPageModalNoButton).click();
    }

    //setFields first page
    public void setOrderFirstPageFieldName(String name){
        driver.findElement(orderFirstPageFieldName).sendKeys(name);
    }
    public void setOrderFirstPageFieldSurname(String surname){
        driver.findElement(orderFirstPageFieldSurname).sendKeys(surname);
    }
    public void setOrderFirstPageFieldAddress(String address){
        driver.findElement(orderFirstPageFieldAddress).sendKeys(address);
    }
    public void setOrderFirstPageFieldSubwayStation(String subwayStation){
        driver.findElement(orderFirstPageFieldSubwayStation).sendKeys(subwayStation);
        driver.findElement(orderFirstPageFieldSubwayStationList).click();
    }
    public void setOrderFirstPageFieldPhoneNumber(String phoneNumber){
        driver.findElement(orderFirstPageFieldPhoneNumber).sendKeys(phoneNumber);
    }

    //setFields second page
    public void setOrderSecondPageFieldOrderTime(String orderDate){
        driver.findElement(orderSecondPageFieldOrderDate).sendKeys(orderDate);
        driver.findElement(orderSecondPageFieldOrderDateSelected).click();
    }
    public void setOrderSecondPageFieldRentalPeriod(String rentalPeriod){
        driver.findElement(orderSecondPageFieldRentalPeriod).click();
        String xpathOrderSecondPageFieldRentalPeriodSublist = ".//div[@class='Dropdown-menu']/div[contains(text(),'"+rentalPeriod+"')]";
        orderSecondPageFieldRentalPeriodSublist = By.xpath(xpathOrderSecondPageFieldRentalPeriodSublist);

        driver.findElement(orderSecondPageFieldRentalPeriodSublist).click();


    }
    public void setOrderSecondPageFieldBlackColour(){
        driver.findElement(orderSecondPageFieldBlackColourCheckbox).click();
    }
    public void setOrderSecondPageFieldWhiteColour(){
        driver.findElement(orderSecondPageFieldWhiteColourCheckbox).click();
    }
    public void setOrderSecondPageFieldComment(String comment){
        driver.findElement(orderSecondPageFieldComment).sendKeys(comment);
    }
    public boolean isOrderSucceed(){
        return driver.findElement(successOrderForm).isEnabled();
    }

    //common set fields methods
    public void setOrderFieldsFirstPage(String name,String surname,String address, String subwayStation, String phoneNumber ){
        setOrderFirstPageFieldName(name);
        setOrderFirstPageFieldSurname(surname);
        setOrderFirstPageFieldAddress(address);
        setOrderFirstPageFieldSubwayStation(subwayStation);
        setOrderFirstPageFieldPhoneNumber(phoneNumber);
    }

    public void setOrderFieldsSecondPage(String orderDate,String rentalPeriod, String colour,String comment){
        setOrderSecondPageFieldOrderTime(orderDate);
        setOrderSecondPageFieldRentalPeriod(rentalPeriod);
        if(Objects.equals(colour, "black")){setOrderSecondPageFieldBlackColour();}
        else if(Objects.equals(colour, "white")){setOrderSecondPageFieldWhiteColour();}
        setOrderSecondPageFieldComment(comment);
    }

    public void setAllOrderFields(String name,String surname,String address, String subwayStation, String phoneNumber,String orderDate,String rentalPeriod,String colour,String comment){
        setOrderFieldsFirstPage(name,surname,address,subwayStation,phoneNumber);
        orderFirstPageNextButtonClick();
        setOrderFieldsSecondPage(orderDate,rentalPeriod,colour,comment);
    }



}
