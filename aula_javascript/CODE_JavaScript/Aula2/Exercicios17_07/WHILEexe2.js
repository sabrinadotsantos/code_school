// 7. Calcular a soma dos números de 1 a 100 utilizando a estrutura
// while.

// let contador = 0;
// let soma = 0;

// while (contador < 100) {
//     contador ++
//     soma = soma + contador

//     console.log(`${contador}  ${soma}`);

// }


import promptSync from "prompt-sync";

const prompt = promptSync();

export function soma1a100() {
    console.log("7. Calcular a soma dos números de 1 a 100 utilizando a estrutura while.");


    let contador = 0;
    let soma = 0;

    while (contador < 100) {
        contador++
        soma = soma + contador

        console.log(`${contador}  ${soma}`);

    }


}
