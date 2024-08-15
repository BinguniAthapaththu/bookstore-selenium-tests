package com.bookstore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;

    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By usernameField = By.id("userName");
    private By passwordField = By.id("password");
    private By registerButton = By.id("register");
    private By captchaCheckbox = By.cssSelector(".recaptcha-checkbox-border");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickCaptcha() {
        // Wait for CAPTCHA checkbox to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        WebElement captchaElement = wait.until(ExpectedConditions.elementToBeClickable(captchaCheckbox));
        captchaElement.click();
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }
}