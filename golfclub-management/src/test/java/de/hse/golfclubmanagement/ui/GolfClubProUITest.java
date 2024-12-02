package de.hse.golfclubmanagement.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GolfClubProUITest {

    // WebDriver instance for automating browser interactions
    private WebDriver driver;

       @BeforeEach
       public void setUp() {
           // Set up WebDriver using WebDriverManager
           WebDriverManager.chromedriver().setup();
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--headless");                      // Run in headless mode
           options.addArguments("--remote-allow-origins=*");        // Allow remote origins
           driver = new ChromeDriver(options);                      // Initialize the driver
           // driver.manage().window().maximize();                  // Maximize the browser window
       }

       @Test
       public void testLandingPage() {
           // Navigate to the login page of golfclubpro vue app
           driver.get("http://localhost:8081");

           // Find and click the login button
           WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
           loginButton.click();

           // Add assertions to verify successful login
           // For example, check if the URL is correct or if a specific element is present
           String expectedUrl = "http://localhost:8081/login";
           assertEquals(expectedUrl, driver.getCurrentUrl());
       }

       @Test
       public void testLogin() {
           // Navigate to the login page
           driver.get("http://localhost:8081/login");

           // Find the email and password fields and enter values
           WebElement emailField = driver.findElement(By.id("email"));
           WebElement passwordField = driver.findElement(By.id("password"));
           emailField.sendKeys("test@example.com");
           passwordField.sendKeys("password");

           // Find and click the login button
           WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
           loginButton.click();

           // Add assertions to verify successful login
           // For example, check if the URL is correct or if a specific element is present
           String expectedUrl = "http://localhost:8081/login";
           assertEquals(expectedUrl, driver.getCurrentUrl());
       }

       @AfterEach
       public void tearDown() {
           // Close the browser
           if (driver != null) {
               driver.quit();
           }
       }
}
