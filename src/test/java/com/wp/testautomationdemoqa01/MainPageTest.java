package com.wp.testautomationdemoqa01;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.get("https://demoqa.com/");

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void testCase01() {
        // Scroll down the page until the Elements menu displays
        WebElement ScrollUpToElements = driver.findElement(By.xpath("//h5[text()= 'Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollUpToElements);

        // Click on the element menu
        mainPage.elementsMenu.click();
        // Click on the text box menu
        mainPage.textBoxMenu.click();
        // Enter fullName value
        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("John Doe");
        // Enter email value
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("john@example.com");
        // Enter currentAddress value
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("123 Street, City");
        // Enter permanentAddress value
        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("456 Avenue, City");
        // Scroll down the page until the Submit button displays
        WebElement scrollUpToSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollUpToSubmit);
        // Click on Submit button
        mainPage.submitButton.click();

        // Validate the fullName input
        WebElement validateFullNameValue = driver.findElement(By.xpath("//p[@id='name']"));
        assertEquals(validateFullNameValue.getText(),"Name:John Doe");
        // Validate the email input
        WebElement validateEmailValue = driver.findElement(By.xpath("//p[@id='email']"));
        assertEquals(validateEmailValue.getText(),"Email:john@example.com");
        // Validate the currentAddress input
        WebElement validateCurrentAddressValue = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        assertEquals(validateCurrentAddressValue.getText(),"Current Address :123 Street, City");
        // Validate the permanentAddress input
        WebElement validatePermanentAddressValue = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        assertEquals(validatePermanentAddressValue.getText(),"Permananet Address :456 Avenue, City");

    }

    @Test
    public void testCase02() {
        // Scroll down the page until the Elements menu displays
        WebElement ScrollUpToElements = driver.findElement(By.xpath("//h5[text()= 'Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollUpToElements);

        // Click on the element menu
        mainPage.elementsMenu.click();
        // Click on the checkbox menu
        mainPage.checkBoxMenu.click();
        // Click on the expand Arrow
        mainPage.expandArrow.click();
        // Click on the 'Desktop' checkbox
        mainPage.checkboxDesktop.click();

        // Validate the 'You have selected' wording
        WebElement selectedItems = driver.findElement(By.xpath("//span[text()='You have selected :']"));
        assertEquals(selectedItems.getText(), "You have selected :");
        // Validate the selected item 01: desktop
        WebElement selectedItems01 = driver.findElement(By.xpath("//span[text()='desktop']"));
        assertEquals(selectedItems01.getText(), "desktop");
        // Validate the selected item 02: notes
        WebElement selectedItems02 = driver.findElement(By.xpath("//span[text()='notes']"));
        assertEquals(selectedItems02.getText(), "notes");
        // Validate the selected item 03: commands
        WebElement selectedItems03 = driver.findElement(By.xpath("//span[text()='commands']"));
        assertEquals(selectedItems03.getText(), "commands");

    }

    @Test
    public void testCase03() {
        // Scroll down the page until the Element menu displays
        WebElement ScrollUpToElements = driver.findElement(By.xpath("//h5[text()= 'Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollUpToElements);

        // Click on the elements menu
        mainPage.elementsMenu.click();
        // Click on the radio button menu
        mainPage.radioButtonMenu.click();
        // Select radio button 'Yes'
        mainPage.YesRadioButton.click();

        WebElement selectedOption = driver.findElement(By.xpath("//p[@class='mt-3']"));
        assertEquals(selectedOption.getText(), "You have selected Yes");
    }

    @Test
    public void testCase04() {
        // Scroll down the page until the Elements menu displays
        WebElement ScrollUpToElements = driver.findElement(By.xpath("//h5[text()= 'Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollUpToElements);

        // Click on the elements menu
        mainPage.elementsMenu.click();
        // Click on the buttons menu
        mainPage.buttonsMenu.click();

        // Get the path of the double-click button
        WebElement elementToDoubleClick = driver.findElement(By.xpath("//button[text()='Double Click Me']"));
        // Create the Action class
        Actions actions = new Actions(driver);
        // Perform the double-click action
        actions.doubleClick(elementToDoubleClick).perform();

        // Single click on the 'Click Me' button
        mainPage.clickMeButton.click();

        // Validate the double click functionality
        WebElement performedDoubleClickMessage = driver.findElement(By.xpath("//p[@id='doubleClickMessage']"));
        assertEquals(performedDoubleClickMessage.getText(), "You have done a double click");

        //Validate the single click functionality
        WebElement performedSingleClickMessage = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));
        assertEquals(performedSingleClickMessage.getText(), "You have done a dynamic click");
    }

    @Test
    public void testCase05() {
        // Scroll down the page until the Widgets menu displays
        WebElement ScrollUpToWidgets = driver.findElement(By.xpath("//h5[text()= 'Widgets']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollUpToWidgets);

        // Click on the widgets menu
        mainPage.widgetsMenu.click();
        // Click on the date picker menu
        mainPage.datePickerMenu.click();
        // Click on the date picker input field
        mainPage.datePickerInputField.click();
        // Select a date from the calendar
        mainPage.date.click();

        // Validate the selected date from the calendar
        WebElement selectedDate = driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
        assertEquals(selectedDate.getAttribute("value"),"09/15/2024");
    }

    @Test
    public void testCase06() {
        // Scroll down the page until the Alerts, Frame & Windows menu displays
        WebElement ScrollUpToAlertFrameWindows = driver.findElement(By.xpath("//h5[text()= 'Alerts, Frame & Windows']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollUpToAlertFrameWindows);

        // Click on the alert,Frame & Windows menu
        mainPage.alertFrameWindowsMenu.click();
        // Click on the model dialogs menu
        mainPage.modalDialogsMenu.click();
        // Click on the small model button
        mainPage.smallModelButton.click();

        // Scroll down the page until the Small Modal button displays
        WebElement ScrollUpToSmallModalButton = driver.findElement(By.xpath("//div[text()='Small Modal']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollUpToSmallModalButton);

        // Validate the small modal pop-up is appeared
        WebElement smallModalPopUp = driver.findElement(By.xpath("//div[text()='Small Modal']"));
        assertEquals(smallModalPopUp.getText(), "Small Modal");

        // Click on the Close button on the small modal pop-up
        mainPage.popupCloseButton.click();

        // Scroll down the page until the Modal Dialogs title displays
        WebElement ScrollUpToModalDialogsTitle = driver.findElement(By.xpath("//h1[text()='Modal Dialogs']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollUpToModalDialogsTitle);

        // Validate the selected date from the calendar
        WebElement navigatedBackToModalDialogsPage = driver.findElement(By.xpath("//h1[text()='Modal Dialogs']"));
        assertEquals(navigatedBackToModalDialogsPage.getText(), "Modal Dialogs");
    }

    @Test
    public void testCase07() {
        // Scroll down the page until the Elements menu displays
        WebElement ScrollUpToElements = driver.findElement(By.xpath("//h5[text()= 'Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollUpToElements);

        // Click on the elements menu
        mainPage.elementsMenu.click();
        // Click on the links menu
        mainPage.linksMenu.click();

        // Scroll down the page until the Home link displays
        WebElement ScrollUpToHomeLink = driver.findElement(By.xpath("//a[@id='simpleLink']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollUpToHomeLink);
        // Click on the small model button
        mainPage.homeLink.click();

        // Get all open tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // Navigate the driver to the last opened tab
        driver.switchTo().window(tabs.get(1));

        // Validate the navigation to the Home page of DEMOQA site
        WebElement homeContent = driver.findElement(By.xpath("//div[@class='home-content']"));
        assertTrue(homeContent.isDisplayed());
    }
}
