# language: pt

	Funcionalidade: Login

  @Login
  Cenário: Realizar login
    Dado que eu esteja na tela de login
    Quando faço login com o usuário "Email" e senha "********"
    Então sou autenticado com sucesso com o usuario "Nome do Perfil"
    E efetuo o logout da minha conta 