import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		HashMap<String, Object> coordinates =new  HashMap<String, Object>();
		coordinates.put("latitude", 41);
		coordinates.put("longitude", 2);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);		
		driver.get("Https://google.com");
		driver.findElement(By.name("q")).sendKeys("Netflix",Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String Title= driver.findElement(By.xpath("//*[@data-uia='nmhp-card-hero-text-title']")).getText();
		System.out.println(Title);		

	}

}
