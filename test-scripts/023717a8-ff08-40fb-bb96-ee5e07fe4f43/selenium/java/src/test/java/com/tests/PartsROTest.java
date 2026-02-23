package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.example.pages.LoginPage;
import com.example.pages.PartsDashboardPage;
import com.example.pages.ServicePartsCounterPage;
import com.example.pages.PartsOfROPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;

public class PartsROTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(description = "Verify navigation to Parts of RO page and perform actions related to selling parts to a repair order")
    @Description("Test the ability to navigate to the Parts of RO page from the Service Parts Counter section and perform actions related to selling parts to a repair order.")
    @Severity(SeverityLevel.CRITICAL)
    public void testNavigateAndSellPartsToRO() {
        // Step 1: Navigate to application URL
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo("https://app-athena-root-config.app-stage.connectcdk.com/fixedops-parts/app/320006/parts/?cid=320006");

        // Step 2: Enter valid credentials and login
        loginPage.enterUsername("validUsername");
        loginPage.enterPassword("validPassword");
        PartsDashboardPage dashboardPage = loginPage.clickLogin();

        // Step 3: Select 'Parts' from the navigation panel
        dashboardPage.selectPartsFromNavigation();

        // Step 4: Select 'Service Parts Counter'
        ServicePartsCounterPage servicePartsCounterPage = dashboardPage.selectServicePartsCounter();

        // Step 5: Scroll to Estimates Approved section and select any RO
        PartsOfROPage partsOfROPage = servicePartsCounterPage.selectAnyROFromEstimatesApproved();

        // Step 6: Hover over the + button in the Details tab
        partsOfROPage.hoverOverAddPartButton();

        // Step 7: Click on the + button to add a part
        partsOfROPage.clickAddPartButton();

        // Step 8: Enter a part number
        partsOfROPage.enterPartNumber("12345");

        // Step 9: Enter quantity and click 'Sell to RO'
        partsOfROPage.enterQuantityAndSellToRO(2);

        // Step 10: Click on 'Sell All Parts' button
        partsOfROPage.clickSellAllPartsButton();

        // Step 11: Return to the main screen
        partsOfROPage.returnToMainScreen();

        // Assert successful completion of test steps
        Assert.assertTrue(partsOfROPage.isSellOperationSuccessful(), "Sell operation should be successful");
    }
}