let prompt = require("prompt-sync")()


// Exercício 1: Verificação de login
// Escreva um programa que solicita ao usuário um nome de usuário e uma senha. Verifique se o
// nome de usuário é admin e a senha é senha123. Exiba uma mensagem indicando se o login
// foi bem-sucedido ou não.



let nome = prompt("Digite seu nome de usuario: ")
let senha = prompt("Digite sua senha: ")

if (nome == "admin" && senha == "senha123") {
    console.log(" Login bem sucedido!");
}else{
    console.log(" Login nao sucedido, tente novamente!");
}


