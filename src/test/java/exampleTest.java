import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class exampleTest {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new TrueAutomationDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void exampleTest() throws InterruptedException {
        driver.get("https://softesis.atlassian.net/secure/RapidBoard.jspa?rapidView=11&selectedIssue=TA-828");

        for (int i = 0; i < 4; i++){
            String TA_NAME = "FOR:" + i;

            driver.findElement(By.id(ta(TA_NAME,"username"))).sendKeys("dd");

            System.out.println("\n" + TA_NAME);
            Thread.sleep(1000);
        }
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
