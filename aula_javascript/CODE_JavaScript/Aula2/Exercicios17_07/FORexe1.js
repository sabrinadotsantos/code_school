// 1. Imprimir números de 1 a 10 utilizando o loop for

// for (let index = 1; index < 10; index++) {
//     console.log(index)
// }

import promptSync from "prompt-sync";

const prompt = promptSync();


export function numero1a10(){
    console.log("1. Imprimir números de 1 a 10 utilizando o loop for");

    for (let index = 1; index < 10; index++) {
        console.log(index)
    }
}

