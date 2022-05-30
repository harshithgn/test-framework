package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Reports;

public class Home {
    WebDriver driver;

    By getProtected = By.xpath("");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHealthCard() {
        driver.findElement(getProtected).click();
        Reports.validationTest.info("");
    }
}
