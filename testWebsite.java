import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class testWebsite {
    FirefoxDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void testWebsite() {
        wd.get("http://ieeeusa.com/");
        wd.findElement(By.cssSelector("map[name=\"FPMap0_I2\"] > area")).click();
        wd.findElement(By.xpath("//table[@id='main tabke']/tbody/tr[1]/td/table/tbody/tr[2]/td/map/area[3]")).click();
        wd.findElement(By.xpath("//table[@id='main tabke']/tbody/tr[1]/td/table/tbody/tr[2]/td/map/area[4]")).click();
        wd.findElement(By.xpath("//table[@id='main tabke']/tbody/tr[1]/td/table/tbody/tr[2]/td/map/area[5]")).click();
        wd.findElement(By.xpath("//table[@id='main tabke']/tbody/tr[1]/td/table/tbody/tr[2]/td/img")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Smart Brief")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.findElement(By.xpath("//table[@id='main tabke']/tbody/tr[1]/td/table/tbody/tr[2]/td/map/area[6]")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("About Today's Engineer")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.findElement(By.name("home")).click();
        wd.findElement(By.linkText("IEEE-USA")).click();
        if (!(wd.findElements(By.cssSelector("td > #table1 > tbody > tr > td > a > img")).size() != 0)) {
            System.out.println("verifyElementPresent failed");
        }
        wd.findElement(By.xpath("//table[@id='main tabke']/tbody/tr[1]/td/table/tbody/tr[2]/td/map/area[6]")).click();
        wd.findElement(By.xpath("//table[@id='main tabke']/tbody/tr[1]/td/table/tbody/tr[2]/td/map/area[8]")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("IEEE-USA Meeting Calendar (2014)")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.findElement(By.linkText("IEEE-USA Home")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Visit us on any of these sites...")) {
            System.out.println("verifyTextPresent failed");
        }
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
