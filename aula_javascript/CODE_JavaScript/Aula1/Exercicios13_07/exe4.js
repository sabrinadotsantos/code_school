let prompt = require("prompt-sync")()

// Exercício 4: Verificação de idade
// Escreva um programa que solicita o ano de nascimento de uma pessoa e verifica se ela é maior
// de 18 anos. Exiba uma mensagem indicando se a pessoa é maior de idade ou não.

let anoNasc = (prompt("Digite ano de nascimento e diremos se é maior de 18  ou não: "))

const dataAtual = new Date();

const anoAtual = dataAtual.getFullYear();



idade = anoAtual - anoNasc


if ( idade => 18) {
    console.log(" Sua idade é " + idade + " Voce é maior de idade!");

}else{
    console.log("Voce nao é maior de idade!");
}
