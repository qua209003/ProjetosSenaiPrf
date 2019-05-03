algoritmo "desafio"
var
vet : vetor [1..10,1..10] de inteiro
i, j, c : inteiro
palavra : caractere
inicio
palavra <- maiusc("java")
// onde a palavra vai ficar
i <- randi(9)+1
j <- randi(7)
// aqui vai incluir a palavra na matriz
para c de 1 ate compr(palavra) faca
vet[i,j+(c+1)] <- asc(copia(palavra,c,1))
fimpara
para i de 1 ate 10 faca
   para j de 1 ate 10 faca
      se vet[i,j] = 0 entao
         vet[i,j] <- randi(20)+65
      fimse
      escreva(carac(vet[i,j])," ")
   fimpara
   escreval()
fimpara
fimalgoritmo

