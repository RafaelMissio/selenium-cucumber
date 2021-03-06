#language: pt
Funcionalidade: Cadastro de contas

  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  Contexto:
    Dado que estou acessando a aplicação
    Quando informo o usuário "mi@m"
    E a senha "mi"
    E seleciono entrar
    Então visualizo a página inicial

  @issue=1
  Cenário: Deve inserir uma conta com sucesso
    Quando seleciono Contas
    E seleciono Adicionar
    E informo a conta "Conta de Teste"
    E seleciono Salvar
    Então a conta é inserida com sucesso

  @issue=2
  Cenário: Não deve inserir uma conta sem nome
    Quando seleciono Contas
    E seleciono Adicionar
    E seleciono Salvar
    Então sou notificar que o nome da conta é obrigatório

  @issue=3
  Cenário: Não deve inserir uma conta com nome já existente
    Quando seleciono Contas
    E seleciono Adicionar
    E informo a conta "Conta mesmo nome"
    E seleciono Salvar
    Então sou notificado que já existe uma conta com esse nome