package com.bookstore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest extends TestSetupTearDown {

    @Test
    public void testValidLogin() {
        // Verify that user is able to login with valid user credentials
        driver.get("https://demoqa.com/login");
        // Scroll down the web page before entering username and password
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Binguni");
        loginPage.enterPassword("Binguni1234!");
        loginPage.clickLogin();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://demoqa.com/profile")) {
            System.out.println("Test Case 01 Pass");
        } else {
            System.out.println("Test Case 01 Fail");
        }
    }

    @Test
    public void testInvalidLogin1() {
        // Verify that user is unable to login with invalid username
        driver.get("https://demoqa.com/login");
        // Scroll down the web page before entering username and password
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("Binguni");
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"name\"]")));
        String expectedErrorMessage = "Invalid username or password!";
        if (errorMessage.getText().equals(expectedErrorMessage)) {
            System.out.println("Test Case 02 Pass");
        } else {
            System.out.println("Test Case 02 Fail");
        }
    }

    @Test
    public void testInvalidLogin2() {
        // Verify that user is unable to login with invalid password
        driver.get("https://demoqa.com/login");
        // Scroll down the web page before entering username and password
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("Binguni");
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"name\"]")));
        String expectedErrorMessage = "Invalid username or password!";
        if (errorMessage.getText().equals(expectedErrorMessage)) {
            System.out.println("Test Case 03 Pass");
        } else {
            System.out.println("Test Case 03 Fail");
        }
    }


}
