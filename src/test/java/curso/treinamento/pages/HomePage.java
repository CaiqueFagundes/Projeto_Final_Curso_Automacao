package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import curso.treinamento.setup.Hooks;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//a [@ class='option-login']")
    WebElement botaoLogn;
	
	@FindBy (xpath="//span[@class='nav-header-username']")
    WebElement nomeUsuario; 
	
	@FindBy (xpath="//nav [@id= 'nav-header-menu']/div [@class = 'nav-header-user']/label/a[@class='nav-header-user-myml']")
    WebElement menuPrincipal; 
	
	@FindBy (xpath="//nav [@class='nav-header-user-layer user-menu user-menu--hidden']")
    WebElement submenuPrincipal;
	
	////div [@class='nav-header-user']/nav [@class='nav-header-user-layer user-menu']/div[@class='user-menu__main']/div [@class='user-menu__shortcuts ']/a [@data-id='logout']
	
	@FindBy (xpath="//*[@id=\"nav-header-menu\"]/div/nav/div[1]/div[2]/a[5]")
    WebElement botaoSair; 
		
	
//Métodos 
	
	public void Efetuarlogout() {
		
		Actions act = new Actions (Hooks.getDriver());
		act.keyDown(Keys.SHIFT).moveToElement(menuPrincipal).click(botaoSair).build().perform();		
		act.click(botaoSair).build().perform();
		//botaoSair.click();
		
		System.out.println("Parabens você realisou o teste de Login com sucesso !!!!");
	}
	
	public boolean checkAposLogin(String perfilUsuario) {
		return nomeUsuario.getText().equals(perfilUsuario);
	}
	
	public void ClickBotaoLogin() {
		botaoLogn.click();
		WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2 [@class='auth-title']")));		
	}
	
}
