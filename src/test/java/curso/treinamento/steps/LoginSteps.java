package curso.treinamento.steps;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import curso.treinamento.pages.HomePage;
import curso.treinamento.pages.LoginPage;
import curso.treinamento.setup.Hooks;


public class LoginSteps {

	private LoginPage loginPage = new LoginPage(Hooks.getDriver());
	private HomePage  HomePage = new  HomePage(Hooks.getDriver());
	
	
	@Dado("^que eu esteja na tela de login$")
	public void queEuEstejaNaTelaDeLogin() {
		HomePage.ClickBotaoLogin();
		Assert.assertTrue("Página Login não foi apresentada", loginPage.checkPage());
	}

	@Quando("^faço login com o usuário \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void façoLoginComOUsuárioESenha(String user, String pass){
		loginPage.realizarLogin(user, pass);
	}

	@Então("^sou autenticado com sucesso com o usuario \"([^\"]*)\"$")
	public void souAutenticadoComSucessoComOUsuario(String NomePerfil){
		Assert.assertTrue("Nome do perfil diferente do esperado", HomePage.checkAposLogin(NomePerfil));
	}
	
	@E("^efetuo o logout da minha conta$")
	public void efetuoOLogoutDaMinhaConta(){
	   HomePage.Efetuarlogout();	    
	}	
}