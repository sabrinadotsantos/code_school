let prompt = require("prompt-sync")()

// Exercício 5: Cálculo de desconto progressivo
// Imagine uma loja de roupas que dê um desconto ao cliente, dependendo do valor que ele
// pague. Faça um programa para loja, que solicite o valor total da compra ao usuário e assim,
// aplique um desconto de acordo com o valor total da compra. Siga a tabela:
// Valor total da compra até R$ 100,00: sem desconto.
// Valor total da compra de R$ 100,01 a R$ 200,00: desconto de 10%.
// Valor total da compra acima de R$ 200,00: desconto de 20%.
// Exiba o valor final da compra com o desconto aplicado.

let valor = parseFloat(prompt("Digite o valor total da conta: "))

if (valor >= 100 && valor <= 200) {

    soma = (valor * 10)/100 
    valor = valor - soma
    console.log(valor)
    console.log("Parabéns voce ganhou um desconto de 10%. O total da compra agora será de R$: " + valor)

}else if (valor > 200) {
    soma = (valor * 20)/100 
    valor = valor - soma
    console.log(valor)
    console.log("Parabéns voce ganhou um desconto de 20%. O total da compra agora será de R$: " + valor)
}else{
    console.log("Voce nao tem direito a desconto!");
}