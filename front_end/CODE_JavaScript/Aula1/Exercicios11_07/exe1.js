let prompt = require("prompt-sync")()

// // 1. Faça um programa que receba o nome, cargo e salário de um
// funcionário. Se o funcionário ganhar abaixo de 1000 reais, calcule o
// salário acrescido de 10%. Ao final exiba o nome, o cargo e o salário
// desse funcionário


let nome = (prompt("Digite o nome do funcionario: "));
let cargo = (prompt("Digite o cargo do funcionario: "));
let salario = parseFloat (prompt("Digite o salario do funcionario: "));

 

if (salario < 1000) {

    soma = (salario * 10)/100
    novoSalario = salario + soma 

    console.log("Parabéns!" + nome + " com o cargo " + cargo + " recebeu um aumento de 10% = " + novoSalario + "!!")

}else{
    console.log("O " + nome + " com o cargo " + cargo + " não recebeu um aumento de 10%")
}

