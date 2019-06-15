package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import curso.treinamento.setup.Hooks;

public class LoginPage {

	HomePage HomePage = new HomePage (Hooks.getDriver());
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


//Objetos da tela login
		
	@FindBy(xpath = "//h2 [@class='auth-title']")
	WebElement tituloPageLogin;
		
	@FindBy(xpath = "//input [@ name='user_id']")
	WebElement campoUsuario;

	@FindBy(xpath = "//input[@class='ui-button ui-button--primary auth-button auth-button--user'][@value='Continuar']")
	WebElement botaoContinuar;
	
	@FindBy(xpath = "//input [@name='password']")
	WebElement campoPassword;

	@FindBy(xpath = "//button [@id='action-complete'][@name=\"action\"]")
	WebElement botaoEntrar;


//Metodos da tela login 
	
	public boolean checkPage() {
		return tituloPageLogin.isDisplayed();
	}

	public void realizarLogin(String user, String pass) {
		campoUsuario.sendKeys(user);
		botaoContinuar.click();
		
		WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input [@name='password']")));
			
		campoPassword.sendKeys(pass);	
		botaoEntrar.click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='nav-header-username']")));
	}

}