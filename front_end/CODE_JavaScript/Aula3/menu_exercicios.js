import promptSync from "prompt-sync";

const prompt = promptSync();



import { numero1a10 } from "../Aula2/Exercicios17_07/FORexe1.js";
import { pares1a10 } from "../Aula2/Exercicios17_07/FORexe2.js";
import { imprimirImpares } from "../Aula2/Exercicios17_07/FORexe3.js";
import { tabuada } from "../Aula2/Exercicios17_07/FORexe4.js";
import { seqFibonacci } from "../Aula2/Exercicios17_07/FORexe5.js";
import { pares0a20 } from "../Aula2/Exercicios17_07/WHILEexe1.js";
import { soma1a100 } from "../Aula2/Exercicios17_07/WHILEexe2.js";
import { verificarMaiorIdade } from "../Aula2/Exercicios17_07/WHILEexe3.js";
import { regressiva } from "../Aula2/Exercicios17_07/WHILEexe4.js";
import { diferente0 } from "../Aula2/Exercicios17_07/WHILEexe5.js";

let exercicio;
let continuar;

do {

    exercicio = parseInt(prompt("Digite um numero que represente um exercicio de 1 a 10: "))

    switch (exercicio) {
        case 1:
            numero1a10();
            break;

        case 2:
            pares1a10();
            break;
            break;
        case 3:
            imprimirImpares();
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
            diferente0();
            break;
        default:
            console.log("Digite um numero de 1 a 10: ");
            break;
    }

    continuar = prompt("Deseja escolher outro exercicío? Digite s para sim ou n para nao: ")


} while (continuar.toLocaleLowerCase() === "s");  //toLocaleLowerCase() - funçao que força a string ser minuscula "s" != "S'  === compara valor e tipo 
        console.log("Programa encerrado!");
