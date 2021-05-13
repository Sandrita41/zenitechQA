package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ApplicationPage {
	WebDriver driver;
	private String row = ".main .mainGrid .row";
	

	public ApplicationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List <WebElement> getRow() {
		return driver.findElements(By.className(row));
	}
}
