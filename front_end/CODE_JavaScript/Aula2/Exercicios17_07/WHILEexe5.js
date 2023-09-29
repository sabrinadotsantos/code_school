// 10. Faça um programa que receba um número do usuário e continue
// a pedir o número se o numero for diferente de 0.

//resoluçao professor


// const prompt = require(`prompt-sync`)()

// let numero
// do {
//     numero = prompt ("Digite um numero: ")
    
// }while (numero != "0") {
    
// }


import promptSync from "prompt-sync";

const prompt = promptSync();

export function diferente0() {
    console.log("10 - Faça um programa que receba um número do usuário e continue a pedir o número se o numero for diferente de 0.");
    
    let numero
do {
    numero = prompt ("Digite um numero: ")
    
}while (numero != "0") {
    console.log("Numero igual a 0. Programa encerrado!");
    
}

}