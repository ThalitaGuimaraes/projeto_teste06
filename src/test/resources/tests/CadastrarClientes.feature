#language: pt

Funcionalidade: Cadastrar clientes
  como um usuário do sistema
  eu quero cadastrar clientes
  para que eu possa gerenciar clientes
  
Esquema do Cenário: Cadastro de clientes com sucesso
  Dado Acessar a página de cadastro de clientes
  E Informar o nome do cliente
  E Informar o telefone do cliente
  E Informar a data de nascimento do cliente
  E Selecionar o plano do cliente <plano>
  E Informar as observações
  Quando Solicitar a realização do cadastro do cliente
  Então Sistema informa que o cliente foi cadastrado com sucesso 
  
  Exemplos:
  | plano                |
  | "Plano Preferencial" |
  | "Plano Empresa"      |
  | "Plano VIP"          |
  