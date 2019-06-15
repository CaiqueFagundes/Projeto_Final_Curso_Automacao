# language: pt

	Funcionalidade: Login

  @Login
  Cenário: Realizar login
    Dado que eu esteja na tela de login
    Quando faço login com o usuário "kaiq.sg1@gmail.com" e senha "aol17rfl"
    Então sou autenticado com sucesso com o usuario "Caique"
    E efetuo o logout da minha conta 