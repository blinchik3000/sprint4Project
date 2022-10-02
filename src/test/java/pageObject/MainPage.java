package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    //Question button xpath's
    private String xpathHowMuchDropdownList = ".//div[contains(@id,'accordion__heading') and text()='Сколько это стоит? И как оплатить?']";
    private String xpathCanSeveralScootersDropdownList = ".//div[contains(@id,'accordion__heading') and text()='Хочу сразу несколько самокатов! Так можно?']";
    private String xpathWhatRentalTimeDropdownList = ".//div[contains(@id,'accordion__heading') and text()='Как рассчитывается время аренды?']";
    private String xpathCanOrderTodayDropdownList = ".//div[contains(@id,'accordion__heading') and text()='Можно ли заказать самокат прямо на сегодня?']";
    private String xpathCanProlongRentalTimeDropdownList = ".//div[contains(@id,'accordion__heading') and text()='Можно ли продлить заказ или вернуть самокат раньше?']";
    private String xpathIsChargingAddedDropdownList = ".//div[contains(@id,'accordion__heading') and text()='Вы привозите зарядку вместе с самокатом?']";
    private String xpathCanCancelOrderDropdownList = ".//div[contains(@id,'accordion__heading') and text()='Можно ли отменить заказ?']";
    private String xpathCanMakeOrderOutsideMoscowDropdownList = ".//div[contains(@id,'accordion__heading') and text()='Я жизу за МКАДом, привезёте?']";//жиВу
    //Question buttons By
    private By howMuchDropdownList = By.xpath(xpathHowMuchDropdownList);
    private By canSeveralScootersDropdownList = By.xpath(xpathCanSeveralScootersDropdownList);
    private By whatRentalTimeDropdownList = By.xpath(xpathWhatRentalTimeDropdownList);
    private By canOrderTodayDropdownList = By.xpath(xpathCanOrderTodayDropdownList);
    private By canProlongRentalTimeDropdownList = By.xpath(xpathCanProlongRentalTimeDropdownList);
    private By isChargingAddedDropdownList = By.xpath(xpathIsChargingAddedDropdownList);
    private By canCancelOrderDropdownList = By.xpath(xpathCanCancelOrderDropdownList);
    private By canMakeOrderOutsideMoscowDropdownList = By.xpath(xpathCanMakeOrderOutsideMoscowDropdownList);

    //Order buttons By
    private By headerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private By homeOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Order buttons click
    public void clickHeaderOrderButton(){
        driver.findElement(headerOrderButton).click();
    }
    public void clickHomeOrderButton(){
        driver.findElement(homeOrderButton).click();
    }

    //Question list click
    public void clickHowMuchDropdownList(){
        WebElement element = driver.findElement(howMuchDropdownList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(howMuchDropdownList).click();
    }
    public void clickCanSeveralScootersDropdownList(){
        WebElement element = driver.findElement(canSeveralScootersDropdownList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);


        driver.findElement(canSeveralScootersDropdownList).click();
    }
    public void clickWhatRentalTimeDropdownList(){
        WebElement element = driver.findElement(whatRentalTimeDropdownList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(whatRentalTimeDropdownList).click();
    }
    public void clickCanOrderTodayDropdownList(){
        WebElement element = driver.findElement(canOrderTodayDropdownList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(canOrderTodayDropdownList).click();
    }
    public void clickCanProlongRentalTimeDropdownList(){
        WebElement element = driver.findElement(canProlongRentalTimeDropdownList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(canProlongRentalTimeDropdownList).click();
    }
    public void clickIsChargingAddedDropdownList(){
        WebElement element = driver.findElement(isChargingAddedDropdownList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(isChargingAddedDropdownList).click();
    }
    public void clickCanCancelOrderDropdownList(){
        WebElement element = driver.findElement(canCancelOrderDropdownList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(canCancelOrderDropdownList).click();
    }
    public void clickCanMakeOrderOutsideMoscowDropdownList(){
        WebElement element = driver.findElement(canMakeOrderOutsideMoscowDropdownList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(canMakeOrderOutsideMoscowDropdownList).click();
    }

    //get question id by question xpath method
    public String getQuestionId(String questionXpath){
        return driver.findElement(By.xpath(questionXpath)).getAttribute("id");
    }
    //get answer xpath by question id method
    public String getAnswerXpath(String questionId){
        return ".//div[@aria-labelledby='"+questionId+"']";
    }

    //get text by question xpath methods
    public String getHowMuchDropdownListAnswer(){
        String questionXpathId = getQuestionId(xpathHowMuchDropdownList);
        String answerXpath = getAnswerXpath(questionXpathId);

        return driver.findElement(By.xpath(answerXpath)).getText();
    }
    public String getCanSeveralScootersDropdownListAnswer(){
        String questionXpathId = getQuestionId(xpathCanSeveralScootersDropdownList);
        String answerXpath = getAnswerXpath(questionXpathId);

        return driver.findElement(By.xpath(answerXpath)).getText();
    }
    public String getWhatRentalTimeDropdownListAnswer(){
        String questionXpathId = getQuestionId(xpathWhatRentalTimeDropdownList);
        String answerXpath = getAnswerXpath(questionXpathId);

        return driver.findElement(By.xpath(answerXpath)).getText();
    }
    public String getCanOrderTodayDropdownListAnswer(){
        String questionXpathId = getQuestionId(xpathCanOrderTodayDropdownList);
        String answerXpath = getAnswerXpath(questionXpathId);

        return driver.findElement(By.xpath(answerXpath)).getText();
    }
    public String getCanProlongRentalTimeDropdownListAnswer(){
        String questionXpathId = getQuestionId(xpathCanProlongRentalTimeDropdownList);
        String answerXpath = getAnswerXpath(questionXpathId);

        return driver.findElement(By.xpath(answerXpath)).getText();
    }
    public String getIsChargingAddedDropdownListAnswer(){
        String questionXpathId = getQuestionId(xpathIsChargingAddedDropdownList);
        String answerXpath = getAnswerXpath(questionXpathId);

        return driver.findElement(By.xpath(answerXpath)).getText();
    }
    public String getCanCancelOrderDropdownListAnswer(){
        String questionXpathId = getQuestionId(xpathCanCancelOrderDropdownList);
        String answerXpath = getAnswerXpath(questionXpathId);

        return driver.findElement(By.xpath(answerXpath)).getText();
    }
    public String getCanMakeOrderOutsideMoscowDropdownListAnswer(){
        String questionXpathId = getQuestionId(xpathCanMakeOrderOutsideMoscowDropdownList);
        String answerXpath = getAnswerXpath(questionXpathId);

        return driver.findElement(By.xpath(answerXpath)).getText();
    }



}
