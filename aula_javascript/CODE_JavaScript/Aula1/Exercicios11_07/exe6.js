let prompt = require("prompt-sync")()

// 6. Faça um programa que receba 4 notas de um aluno, calcule e
// imprima a média aritmética das notas e a mensagem de APROVADO
// para média superior ou igual a 7,0 RECUPERAÇÃO para notas entre
// 5.0 e 7,0 ou a mensagem de REPROVADO para média inferior a 5,0.


let nota1 = parseFloat (prompt("Digite a sua nota em Matemática "));
let nota2 = parseFloat (prompt("Digite a sua nota em Literatura "));
let nota3 = parseFloat (prompt("Digite a sua nota em Informática "));
let nota4 = parseFloat (prompt("Digite a sua nota em Sociologia "));

media = (nota1 + nota2 + nota3 + nota4) / 4

console.log(media)

if (media >= 7) {
   console.log("A sua media " + media + " é maior que 7, voce esta aprovado!!")
}else if (media > 5 && media < 7 ) {
   console.log("A sua media " + media + " esta entre 5 e 7, voce esta de recuperação!!")
   
}else{
   console.log("A sua media " + media + " esta abaixo de 5, voce esta reprovado!!")
}