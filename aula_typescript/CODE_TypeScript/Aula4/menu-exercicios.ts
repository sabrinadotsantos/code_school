import promptSync from "prompt-sync";

const prompt = promptSync();



import { numero1a10, pares1a10, imprimirImpares, tabuada, seqFibonacci, pares0a20, soma1a100, verificarMaiorIdade, regressiva, diferentede0  } from "../Aula4/exercicios";

let exercicio: number;
let continuar: String;

do {

    exercicio = parseInt(prompt("Digite um numero que represente um exercicio de 1 a 10: "))

    switch (exercicio) {
        case 1:
            numero1a10();
            break;

        case 2:
            pares1a10();
            break;
        case 3:
            imprimirImpares();
            break;
        case 4:
            tabuada();
            break;
        case 5:
            seqFibonacci();
            break;
        case 6:
            pares0a20();
            break;
        case 7:
            soma1a100();
            break;
        case 8:
            verificarMaiorIdade();
            break;
        case 9:
            regressiva();
            break;
        case 10:
            diferentede0();
            break;
        default:
            console.log("Digite um numero de 1 a 10: ");
            break;
    }

    continuar = prompt("Deseja escolher outro exercicío? Digite s para sim ou n para nao: ")


} while (continuar.toLocaleLowerCase() === "s");  //toLocaleLowerCase() - funçao que força a string ser minuscula "s" != "S'  === compara valor e tipo 
console.log("Programa encerrado!");

