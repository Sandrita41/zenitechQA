package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ApplicationPage;

public class ApplicationTest {
	public WebDriver driver;
	ApplicationPage po;

	@Test(enabled = true)
	public void Should_Be_Able_To_Select_Items_InThe_Outer_Perimeter() {

		po = new ApplicationPage(driver);

		List<WebElement> row = driver.findElements(By.cssSelector(".main .mainGrid .row"));

		for (int i = 0; i < row.size(); i++) {
			List<WebElement> column = row.get(i).findElements(By.cssSelector(".icon"));
			for (int j = 0; j < column.size(); j++) {
				if (i == 0) {
					column.get(j).click();
				} else if (i == column.size() - 1) {
					column.get(j).click();
				}
			}
			if (i != 0 && i != row.size() - 1) {
				column.get(0).click();
				column.get(column.size() - 1).click();
			}
		}

		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();

		/*for (int i = 0; i < row.size(); i++) {
			List<WebElement> column = row.get(i).findElements(By.cssSelector(".icon"));
			for (int j = 0; j < column.size(); j++) {
				if (i == 0) {
					column.get(j).click();
				} else if (i == column.size() - 1) {
					column.get(j).click();
				}

			}
			if (i != 0 && i != row.size() - 1) {
				column.get(0).click();
				column.get(column.size() - 1).click();
			}

		}*/

	}

	@BeforeClass
	public void beforeClass() {
		Path sampleFile = Paths.get("files\\QAtask.html");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(sampleFile.toUri().toString());
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
