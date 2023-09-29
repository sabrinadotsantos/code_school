let prompt = require("prompt-sync")()

// 2. Uma empresa decide dar aumento de 30% aos funcionários cujo
// salário é inferior a 500 reais. Escreva um programa que receba o
// salário de um funcionário e imprima o valor do salário reajustado ou
// uma mensagem caso o funcionário não tenha direito a aumento.



let salario = parseFloat (prompt("Digite o salario do funcionario: "));

 

if (salario < 500) {

    soma = (salario * 30)/100
    novoSalario = salario + soma 

    console.log("Parabéns! Voce recebeu um aumento de 30% = " + novoSalario + "!!")

}else{
    console.log("Infelizmente voce nao tem direito ao aumento de 30%")
}
