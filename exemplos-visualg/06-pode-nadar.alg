algoritmo "semnome"
// Fun��o : entrar piscina
// A pessoa tem que saber nadar
// E passar no exame m�dico
// a resposta pro nadar pode ser "sim" ou "sei"
var
nadar , exame : caractere
inicio
escreval("Voc� sabe nadar?")
leia(nadar)
escreval("Seu exame foi aprovado?")
leia(exame)
se ((nadar = "sei") ou (nadar = "sim")) e (exame = "sim") entao
   escreva("Piscina liberada")
senao
   escreva("Piscina bloqueada")
fimse
fimalgoritmo
