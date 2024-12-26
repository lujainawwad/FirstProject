package firstprojectt;

import java.awt.Desktop.Action;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {

	WebDriver driver = new ChromeDriver();
	WebDriver driver2 = new ChromeDriver();
	//lujain

	String mywebsite = "https://automationteststore.com/";
	String [] firsttnames= {"ahmad","omar","yousef","abd","issa","sara","amal"};
	String [] Lastnames= {"afnan","ammeera","farh","mohammed"};
	Random rand = new Random();
	Actions action =new Actions (driver );
	String globalfirstname;
	String globallogininformation;
	String passwoord="Ilovelujain1234.";
		
	
	
	@BeforeTest
	public void mySetup() {
		driver.manage().window(). maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(mywebsite);


	}

	@Test(priority = 2 , enabled = false)
	public void signup() throws InterruptedException {
		Thread.sleep(3000);
		WebElement Loginorregister =driver.findElement(By.linkText("Login or register"));
		Loginorregister.click();
		//Thread.sleep(5000); 
		WebElement signupbutton =driver.findElement(By.xpath("//button[@title='Continue']"));
		signupbutton.click();
		int Randomfirstname=rand.nextInt(firsttnames.length);
		String randomfirstnameinput =firsttnames[Randomfirstname];
		WebElement firsttname =driver.findElement(By.id("AccountFrm_firstname"));
		firsttname.sendKeys(randomfirstnameinput);
		globalfirstname=randomfirstnameinput;
		
		int randomlastname=rand.nextInt(Lastnames.length);
		String randomlastnameinput=Lastnames[randomlastname];
		WebElement lastname  =driver.findElement(By.id("AccountFrm_lastname"));
		lastname.sendKeys(randomlastnameinput);
		
		
		int randomemail=rand.nextInt(585857);
		String domain ="@gmail.com";
		String emaill= randomfirstnameinput + randomlastnameinput + randomemail + domain;
		WebElement email  =driver.findElement(By.id("AccountFrm_email"));
		email.sendKeys(emaill);
		
		WebElement Address  =driver.findElement(By.id("AccountFrm_address_1"));
		Address.sendKeys("albnyat");
		WebElement city  =driver.findElement(By.id("AccountFrm_city"));
		city.sendKeys("jordan");
		
		WebElement country =driver.findElement(By.id("AccountFrm_country_id"));
		Select selector =new Select(country);
		int randomcountry = rand.nextInt(1,240); 		
       selector.selectByIndex(randomcountry);
         
        Thread.sleep(3000);
        

 		WebElement add =driver.findElement(By.id("AccountFrm_zone_id"));
 		Select selector2 =new Select(add);
 		int randomadd = rand.nextInt(1,6); 		
          selector2.selectByIndex(randomadd);
         WebElement postcode =driver.findElement(By.id("AccountFrm_postcode"));
         postcode.sendKeys("1113");
         
          Thread.sleep(3000);
          

          String logininfo=randomfirstnameinput+randomlastnameinput+randomemail;
         
          WebElement loginname =driver.findElement(By.id("AccountFrm_loginname"));
          loginname.sendKeys(logininfo);
          globallogininformation=logininfo;
          
        
          
        WebElement password =driver.findElement(By.id("AccountFrm_password"));
          password.sendKeys("Ilovelujain1234.");
          WebElement passconfirm =driver.findElement(By.id("AccountFrm_confirm"));
          passconfirm.sendKeys("Ilovelujain1234.");
         
          WebElement clickk =driver.findElement(By.id("AccountFrm_agree"));
          clickk.click();
          WebElement contiou =driver.findElement(By.xpath("//button[@title='Continue']"));
          contiou.click();		
	}
	
	
	
	@Test(priority = 3 , enabled = false)
	public void logout() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement logout =driver.findElement(By.id("customernav"));
		Actions action =new Actions (driver );
		action.moveToElement(logout).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Not "+ globalfirstname+"? Logoff")).click();
		
	}
	
	
	@Test(priority = 4  , enabled = false)
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		WebElement logintomyacc=driver.findElement(By.linkText("Login or register"));
		logintomyacc.click();
		
		WebElement username=driver.findElement(By.id("loginFrm_loginname"));
		username.sendKeys(globallogininformation);
		
		
		WebElement loginpassword=driver.findElement(By.id("loginFrm_password"));
		loginpassword.sendKeys(passwoord);
		
		WebElement loginbutton =driver.findElement(By.xpath("//button[@title='Login']"));
		loginbutton.click();		
		}
	
	@Test(priority = 5)	
public void addtocart() throws InterruptedException {
		
		driver.get(mywebsite);
		String [] WebSiteForItems = {"https://automationteststore.com/index.php?rt=product/category&path=68",
				"https://automationteststore.com/index.php?rt=product/category&path=36",
				"https://automationteststore.com/index.php?rt=product/category&path=43",
				"https://automationteststore.com/index.php?rt=product/category&path=49",
				"https://automationteststore.com/index.php?rt=product/category&path=58",
				"https://automationteststore.com/index.php?rt=product/category&path=52",
				"https://automationteststore.com/index.php?rt=product/category&path=65"};
		
	
	int randomitems=rand.nextInt(WebSiteForItems.length);	
	driver.get(WebSiteForItems[randomitems]);
	
	
	WebElement Listofitems= driver.findElement(By.cssSelector(".thumbnails.row"));
	
	int TotalNumberOfItems= Listofitems.findElements(By.tagName("li")).size();
	int randomli =rand.nextInt(TotalNumberOfItems);
	
	Thread.sleep(5000);
	
	 Listofitems.findElements(By.tagName("li")).get(randomli).click();	
	 
	 WebElement Contanier= driver.findElement(By.cssSelector(".thumbnails.grid.row.list-inline"));
	 int list= Contanier.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12")).size();
	 int randomcontainer=rand.nextInt(list);
	 Contanier.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12")).get(randomcontainer).click();
	 	
	}
		
		
		
	

	@AfterTest
	public void myAterTest() {
	}
}
