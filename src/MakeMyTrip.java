import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhavyakhanna\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		OpenBrowser browser = new OpenBrowser();
		browser.Launch(driver);
		SearchTrip trip = new SearchTrip();
		trip.Search(driver);
		SelectTrip select = new SelectTrip();
		select.trip(driver);
		
	}
	
}

class OpenBrowser {
	public void Launch(WebDriver drive){
		drive.get("https://www.makemytrip.com/");
	}
}

class SearchTrip {
	public void Search(WebDriver drive) {
		drive.findElement(By.cssSelector("#hp-widget__sTo")).sendKeys("goa");
		drive.findElement(By.xpath("//span[contains(text(),'Goa, India ')]")).click();
		drive.findElement(By.xpath("//input[@mt-id='returnDate']")).click();
		drive.findElement(By.xpath("//*[contains(@class,'dateFilterReturn ')]/div/div[1]/table/tbody/tr[4]/td[5]")).click();
		drive.findElement(By.xpath("//button[@id = 'searchBtn']")).click();
	}
}

class SelectTrip {
	public void trip(WebDriver drive) {
		drive.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		drive.findElement(By.xpath("//div[@class='row wrap-dep']/div[2]/div/div/div[4]")).click();
		drive.findElement(By.xpath("//div[@class='row wrap-ret']/div[2]/div/div/div[5]")).click();
		drive.findElement(By.xpath("//span[@class='clearfix']/a")).click();
	}
}