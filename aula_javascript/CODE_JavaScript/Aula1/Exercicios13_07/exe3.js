let prompt = require("prompt-sync")()

// Exercício 3: Verificação de números em ordem crescente
// Escreva um programa que solicita três números ao usuário e verifica se eles estão em ordem
// crescente. Exibindo uma mensagem indicando se os números estão em ordem crescente ou
// não.

let num1 = (prompt("Digite um numero: "))
let num2 = (prompt("Digite outro numero: "))
let num3 = (prompt("Digite outro numero: "))

if (num1 > num2 && num1 > num3 && num2 > num3 && num3 < num1 ) {
    console.log("Esta em ordem decrescente  " + num1 + " " + num2 + " " + num3);
}else if (num3 > num1 && num3 > num2 && num2 < num3 && num1 < num3) {
    console.log("Esta em ordem crescente ");
    
}else{
    console.log("Esta desordenado");
    
}
