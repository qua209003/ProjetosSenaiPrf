algoritmo "DesafioP1"
var
n1,n2,resp : real
operacao : caractere
inicio
//escreva("Numero 01")
leia(n1)
//escreva("Operação ?")
leia(operacao)
//escreva("Numero 02")
leia(n2)
se (operacao = "+") entao
   escreva(n1+n2)
senao
   se (operacao = "-") entao
      escreva(n1-n2)
   senao
      se (operacao = "*") entao
         escreva(n1*n2)
      senao
         se (operacao = "/") entao
            escreva(n1/n2)
         senao
            escreva("Operador invalido")
         fimse
      fimse
   fimse
fimse

fimalgoritmo
