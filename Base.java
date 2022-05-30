package runner;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.Home;
import pom.Login;
import utilities.Reports;
import utilities.Utils;

import java.util.concurrent.TimeUnit;

import static utilities.Reports.extentReports;

public class Base {
    Home home;
    Login login;

    public static WebDriver driver;

    @BeforeClass
    public static void loadExtentReports() {
        Reports.createAndSetupExtentReports();
    }

    @BeforeMethod
    public static void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Practice\\IIFL\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ExtentTest generic = extentReports.createTest("Generic");
        generic.info("Browser Launched");
    }

    @Test
    public void validateAge() {
        Reports.validationTest = extentReports.createTest("Facebook");

        //Hit URL
        driver.get("https://facebook.com");
        Reports.validationTest.info("Navigated to Facebook Home page");

        Utils.waitTillSeconds(3);

        home = new Home(driver);
        home.navigateToHealthCard();

        Utils.waitTillSeconds(2);

        driver.close();
    }

    @AfterMethod
    public static void tearUp() {
        extentReports.flush();
    }
}
