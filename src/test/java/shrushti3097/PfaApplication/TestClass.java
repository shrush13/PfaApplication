package shrushti3097.PfaApplication;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import shrushti3097.PfaApplication.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
	WebDriver driver;


	@Test
	public void verify() throws InterruptedException {
	
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\shrus_yza955e\\OneDrive\\Desktop\\Automation\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	

		driver.get("https://numadic.com/careers/");
	
		
		HomePage hp= new HomePage(driver);
		String actualHeaderText=hp.getActualHeaderText();
		Assert.assertEquals(actualHeaderText,"JOIN OUR CREW");
		hp.selectJobType("Internship");
		String actualText =hp.getActualText();

		Assert.assertEquals(actualText, "There are no available job positions that match your filters.");
		hp.selectJobType("Full time");
		hp.clickOnQaEngineer();
		
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, "https://numadic.com/careers/qa-engineer.php");
		hp.applyHereNow();
		
		hp.apply();
		hp.sendFirstName("Shrushti");
		hp.sendLastName("Agnihotri");
		hp.sendEmail("shrush1330@gmail.com");
		hp.sendPhone("8421630897");
		hp.sendHomeTown("Nagpur");
		hp.sendDOB("30/08/1997");
		hp.sendCity("Pune");
		hp.selectGraduationDegree("BE");
		hp.sendGraduationCourse("Engineering");
		hp.sendGraduationCollege("RTMNU,Nagpur");
		hp.sendGraduationPercentage("76");
		hp.clickOnNextButton();
		driver.close();

	}

}
