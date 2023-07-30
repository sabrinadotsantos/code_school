// let prompt = require("prompt-sync")()


// 4. Faça um programa que imprima na tela a tabuada de um número qualquer escolhido pelo usuário até o 10.

// let numero = (prompt("Digite um numero para calcular a tabuada: "));



// for (let index = 1; index <= 10; index ++) {

//     const multi = index * numero

//     console.log(`${index} multiplicado por ${numero} é igual a:  ${multi}`)
// }


import promptSync from "prompt-sync";

const prompt = promptSync();

export function tabuada() {
    console.log("4. Faça um programa que imprima na tela a tabuada de um número qualquer escolhido pelo usuário até o 10.");

    let numero = (prompt("Digite um numero para calcular a tabuada: "));

    for (let index = 1; index <= 10; index++) {

        const multi = index * numero

        console.log(`${index} multiplicado por ${numero} é igual a:  ${multi}`)
    }

}