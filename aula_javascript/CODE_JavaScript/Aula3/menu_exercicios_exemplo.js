import promptSync from "prompt-sync";

import { verificarMaiorIdade } from "../Aula2/Exercicios17_07/WHILEexe3.js";  //importando o arquivo



const prompt = promptSync();

//menu para escolher qual exercicio o usuario escolher - (proprio arquivo)

let exercicio;
let continuar;

do {

    exercicio = parseInt( prompt("Digite um numero que represente um exercicio de 1 a 4: "))
    
        switch (exercicio) {
            case 1:
                //chamando função helloWorld();
                helloWorld("Hello, world!");
                break;

            case 2:
                //objeto
               let aluno = {
                nome: "Sabrina",
                idade: 19,
                hardSkils: ["figma","HTML", "CSS", "web responsivo"] 
               }
               console.log(aluno.nome, aluno.idade, aluno.hardSkils);
            //    console.log("Objeto aluno", aluno);
            //    console.log("Olá", aluno.nome);
                break;

            case 3:
                verificarMaiorIdade();
                break;

            default:
                console.log("Digite um numero de 1 a 4: ");
                break;
        }

        continuar = prompt("Deseja continuar? Digite s para sim ou n para nao: ")


} while (continuar.toLocaleLowerCase() === "s");  //toLocaleLowerCase() - funçao que força a string ser minuscula "s" != "S'  === compara valor e tipo 
 


function helloWorld(frase){
    console.log(frase);
}
