// 9. Faça um programa que receba um número do usuário e mostre
// no console a contagem regressiva até 0.

//resoluçao professor

// const prompt = require(`prompt-sync`)()


// numero = parseInt( prompt ("Digite um numero: "))

// while (numero >= 0) {
//    console.log(numero);
//    numero--; 
// }


import promptSync from "prompt-sync";

const prompt = promptSync();

let numero

export function regressiva() {

   console.log("9 - Faça um programa que receba um número do usuário e mostre no console a contagem regressiva até 0.");

   numero = parseInt( prompt ("Digite um numero: "))

   while (numero >= 0) {
      console.log(numero);
      numero--; 
   }

}