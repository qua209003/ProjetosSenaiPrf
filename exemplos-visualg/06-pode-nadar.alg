algoritmo "semnome"
// Função : entrar piscina
// A pessoa tem que saber nadar
// E passar no exame médico
// a resposta pro nadar pode ser "sim" ou "sei"
var
nadar , exame : caractere
inicio
escreval("Você sabe nadar?")
leia(nadar)
escreval("Seu exame foi aprovado?")
leia(exame)
se ((nadar = "sei") ou (nadar = "sim")) e (exame = "sim") entao
   escreva("Piscina liberada")
senao
   escreva("Piscina bloqueada")
fimse
fimalgoritmo
