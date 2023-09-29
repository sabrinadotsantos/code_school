let prompt = require("prompt-sync")()

// 4. Faça um programa que receba um número do usuário e informe
// se este número é par ou ímpar.

let numero = parseInt (prompt("Digite um numero: "));

let restante = numero % 2

console.log(restante)

if (restante != 0 ) {
    console.log("O numero é impar")
}else{
    console.log("o numero é par")
}