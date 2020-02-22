package Tests;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartProgram {
	static WebDriver driver=null;
	private static Logger log=LogManager.getLogger(AddToCartProgram.class.getName());
	public static void main(String[] args) throws InterruptedException {
		log.debug("System setting chrome driver");
		System.setProperty("webdriver.chrome.driver", "chromedriver 3");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
	    log.info("maximizing window");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(4000);
		String[] itemsNeeded= {"Brocolli","Beetroot","Carrot"};
		addToCart(itemsNeeded);

	}

	private static void addToCart(String[] itemsNeeded) {
		List<WebElement> veggies=driver.findElements(By.xpath("//h4[@class='product-name']"));
		log.info("veggies retreived");
		 int count=0;
		 List listItemsNeeded=Arrays.asList(itemsNeeded);
         int j=listItemsNeeded.size();
         System.out.println(j);
		for(int i=0;i<veggies.size();i++)
		{
			log.debug("getting text");
			String[] name=veggies.get(i).getText().split("-");
			String formattedText=name[0].trim();
         
            if(listItemsNeeded.contains(formattedText))
            {
            	count++;
			driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
			log.debug("product clicked");
			if(count==j)
			{
				break;
			}
			
		    }
		
		

	}

}
}
