package curso.treinamento.pages;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage {


	public ValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
//Elementos da Pagina 	
	
	@FindBy(xpath = "//a [@name='pushNotification']")
	WebElement avisoApp;
		
	@FindBy(xpath = "//a [@name='sendSms']")
	WebElement avisoSMS;
	
	@FindBy(xpath = "//a [@name='makeCall']")
	WebElement ligacaoMobile;

	@FindBy(xpath = "//input [@name='verificationCode']")
	WebElement verificationCode;
	
	@FindBy(xpath = "//input [@class='ch-btn ch-btn-large']")
	WebElement botaoValidarCodigo;
	
	
	
//Metodos 
	public void ClickPush (){
		avisoApp.click();
	}
		
	public void ClickSMS (){
		avisoSMS.click();
	}
	
	public void ClickLigacao (){
		ligacaoMobile.click();
	}	
	
	public void PreencherVerificatioCod (String Codigo_verificacao) {
		verificationCode.sendKeys(Codigo_verificacao);
	}
	
	public void ClickBotaoValidarCodigo() {
		botaoValidarCodigo.click();
	}	
}
