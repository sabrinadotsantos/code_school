let prompt = require("prompt-sync")()


// 5. Faça um programa receba dois valores e imprima qual é o maior
// número digitado.


let valor1 = parseInt (prompt("Digite um numero "));
let valor2 = parseInt (prompt("Digite um numero "));


if (valor1 > valor2) {

    console.log("O primeiro numero digitado é o maior")

}else{
    console.log("O segundo numero digitado é o maior")
}
