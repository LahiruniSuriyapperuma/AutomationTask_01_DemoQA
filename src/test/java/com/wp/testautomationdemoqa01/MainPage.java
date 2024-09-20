package com.wp.testautomationdemoqa01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://demoqa.com/
public class MainPage {
    @FindBy(xpath = "//h5[text()= 'Elements']")
    public WebElement elementsMenu;

    @FindBy(xpath = "//span[text()='Text Box']")
    public WebElement textBoxMenu;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//span[text()='Check Box']")
    public WebElement checkBoxMenu;

    @FindBy(xpath = "//button[@class='rct-collapse rct-collapse-btn']")
    public WebElement expandArrow;

    @FindBy(xpath = "//span[text()='Desktop']")
    public WebElement checkboxDesktop;

    @FindBy(xpath = "//span[text()='Radio Button']")
    public WebElement radioButtonMenu;

    @FindBy(xpath = "//label[@for='yesRadio']")
    public WebElement YesRadioButton;

    @FindBy(xpath = "//span[text()='Buttons']")
    public WebElement buttonsMenu;

    @FindBy(xpath = "//button[text()='Click Me']")
    public WebElement clickMeButton;

    @FindBy(xpath = "//h5[text()='Widgets']")
    public WebElement widgetsMenu;

    @FindBy(xpath = "//span[text()='Date Picker']")
    public WebElement datePickerMenu;

    @FindBy(xpath = "//input[@id='datePickerMonthYearInput']")
    public WebElement datePickerInputField;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and text()='15']")
    public WebElement date;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertFrameWindowsMenu;

    @FindBy(xpath = "//span[text()='Modal Dialogs']")
    public WebElement modalDialogsMenu;

    @FindBy(xpath = "//button[text()='Small modal']")
    public WebElement smallModelButton;

    @FindBy(xpath = "//button[text()='Close']")
    public WebElement popupCloseButton;

    @FindBy(xpath = "//span[text()='Links']")
    public WebElement linksMenu;

    @FindBy(xpath = "//a[@id='simpleLink']")
    public WebElement homeLink;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
