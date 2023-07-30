let prompt = require("prompt-sync")()

// 3. Faça um programa que receba um número inteiro do usuário e informe
// se este número é positivo ou negativo.


let numero = parseInt (prompt("Digite um numero "));


if (numero > 0) {

    console.log("É um numero positivo!!")

}else{
    console.log("É um numero negativo")
}
