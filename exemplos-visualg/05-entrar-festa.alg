algoritmo "semnome"
// exemplos com operações lógicas
var
idade : inteiro
acompanhado : caractere
t1 , t2 , t3 : logico
inicio
escreval("Digite sua idade.")
leia(idade)
escreval("Esta acompanhado pelos Pais?")
leia(acompanhado)
// teste se a pessoa pode entrar na festa maior de 18
// ou estar acompanhado pelos pais
// as respostas podem ser sim ou s
t1 <- idade >= 18
t2 <- acompanhado = "sim"
t3 <- acompanhado = "s"
se (t1) ou (t2) ou (t3) entao
   escreva("Bem vindo a festa.")
senao
   escreva("Tente daqui a ",18-idade," anos")
fimse
fimalgoritmo
