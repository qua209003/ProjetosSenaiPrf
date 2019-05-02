algoritmo "PrimeiroExemplo"
// Função : Saida e entrada de dados
// Autor : Eu
// Data : 03/04/2019
// Seção de Declarações
var
nome : caractere
idade , aniversario , ano : inteiro
inicio
// Seção de Comandos
escreval("Boa noite.")
escreva("Digite o seu nome: ")
leia(nome)
escreval("Bem vindo(a) " + nome)
escreva("Digite sua idade: ")
leia(idade)
escreval("Já fez aniversário ? Sim 0, Não 1")
leia(aniversario)
// como descobrir o ano que a pessoa nasceu
ano <- 2019 - idade - aniversario
escreval("Eu sei que você nasceu em " , ano)
// Mostrar mensagem se a pessoa nasceu antes ou depois
// do Brasil ter Tetra Campeão Mundial

se (1994 < ano) entao
   escreva("O Brasil já era Tetra.")
senao
   se (1994 = ano) entao
      escreva("Você deu sorte pro Brasil.")
   senao
      escreva("O Brasil ainda não era Tetra.")
   fimse
fimse

fimalgoritmo
