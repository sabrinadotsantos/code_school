// 3. Faça um programa que imprima os números ímpares de 0 a 50;

// for (let index = 1; index < 50; index += 2) {
//     console.log(index)
// }

import promptSync from "prompt-sync";

const prompt = promptSync();

export function imprimirImpares(){
    console.log("3. Faça um programa que imprima os números ímpares de 0 a 50");

        
        for (let index = 1; index < 50; index += 2) {
            console.log(index)
        }

}