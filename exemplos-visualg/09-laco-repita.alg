algoritmo "semnome"
// exemplo com repita
var
senha, snhCorreta : caractere // qua209.003
qt : inteiro
inicio
snhCorreta <- "java"
repita
   escreva("Qual é a senha? ")
   leia(senha)
   se nao(senha = snhCorreta) entao
      limpatela
      escreval("Senha invalida.")
   fimse
   qt <- qt + 1
ate (senha = snhCorreta) ou (qt = 3)
// desafio mostra qual foi a quantidade de tentativas.
se senha = snhCorreta entao
   escreva("Senha OK ")
senao
   escreva("Senha bloqueada ",qt," tentativas.")
fimse
fimalgoritmo
