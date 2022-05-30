package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Reports;

public class Login {
    WebDriver driver;

    By getProtected = By.xpath("");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHealthCard() {
        driver.findElement(getProtected).click();
        Reports.validationTest.info("");
    }
}
