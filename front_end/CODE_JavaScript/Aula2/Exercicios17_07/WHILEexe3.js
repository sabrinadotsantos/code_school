// 8. Faça um programa que receba a idade do usuário, enquanto a
// resposta do usuário for menor que 18 anos continue a solicitar a
// idade e mostre uma mensagem quando a idade do usuário for
// maior que 18.

// const prompt = require(`prompt-sync`)()

// let numero
// do {
//     numero = parseInt( prompt ("Digite sua idade: "))
//     if (numero < 18) {
//         console.log("Menor de idade. Tente novamente!");
//     }

// }while (numero < "18") {
//    console.log("Maior de idade!");
// }

//adicionar "export" - funçao pode ser exportada

import promptSync from "prompt-sync";

const prompt = promptSync();

export function verificarMaiorIdade(){
    console.log("8. Faça um programa que receba o nome, idade, altura, peso do usuário, enquanto a resposta do usuário for menor que 18 anos continue a solicitar a idade e mostre uma mensagem quando a idade do usuário for maior que 18.");

        let pessoa ={
            nome: "",
            idade: 0,
        }


        // let numero

        do {
            pessoa.idade = parseInt( prompt ("Digite sua idade: "));
            pessoa.nome =  prompt ("Digite seu nome: ");
        


        }while (pessoa.idade < "18") {
        console.log("Maior de idade!");
        console.log("Objeto", pessoa);
        console.log(`${pessoa.nome}, sua idade ${pessoa.idade}. Verificação é válida!`);
        }
        }