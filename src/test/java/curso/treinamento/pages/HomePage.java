package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableBiMap.Builder;

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
	
	
	
	@FindBy (xpath="//nav [@class='nav-header-user-layer user-menu user-menu--hidden']/div [@class='user-menu__main']/div [@class='user-menu__shortcuts ']/a[@data-id='logout']")
    WebElement botaoSair; 
		
	
//Métodos 
	
	public void Efetuarlogof() {
		
		Actions act = new Actions (Hooks.getDriver());
		act.moveToElement(menuPrincipal).build();
		
		//WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 3000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav [@class='nav-header-user-layer user-menu user-menu--hidden']")));
		
		act.moveToElement(botaoSair).build().perform();
		
		//botaoSair.click();
		/*WebDriverWait wait = new WebDriverWait(Hooks.getDriver());
		Actions acao = new Actions(Hooks.getDriver());
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) menuPrincipal));
		acao.moveToElement(Hooks.getDriver().findElement((By) menuPrincipal));
		acao.moveToElement(Hooks.getDriver().findElement((By)botaoSair));
		acao.click();
		acao.perform();
		*/
		
		
		menuPrincipal.click();
		botaoSair.click();		
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
