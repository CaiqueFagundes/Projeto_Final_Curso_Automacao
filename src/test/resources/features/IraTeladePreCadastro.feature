#language: pt

Funcionalidade: Cadastro de Usuario

Contexto:
	Dado que eu esteja na tela de login
    Quando faço login com o usuário "E-mail" e senha "*******"
    Então sou autenticado com sucesso com o usuario "Caique"
    
    @IraTeladeCadastro @Cadastro
    
    Cenário: indo para tela de cadastro
    	Dado que esteja na tela Home 
    	Quando acessar submenu supplies 
    	Então chego a tela de cadastro "ADD SUPPLIER"
    	E Preencho os campos first_Name com "Caique" e Last Name com "Fagundes" e Email com "Caique@gmail.com" e Password com "123456" e Mobile Number com "098765432" e AddressPrimari com "Rua 2" e AddresSecond com "Apartamento 4" 
    	Então meu nome "Caique" é cadastrado com sucesso 
		    
    