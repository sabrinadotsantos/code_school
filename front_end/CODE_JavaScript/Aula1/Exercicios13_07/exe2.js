let prompt = require("prompt-sync")()


// Exercício 2: Verificação de dia da semana
// Escreva um programa que solicita ao usuário um número de 1 a 7 representando um dia da
// semana e exibe o nome correspondente a esse dia. Considere que 1 representa segunda-feira,
// 2 representa terça-feira e assim por diante.


let  num = (prompt("Digite um numero de 1 a 7 para exibir um dia da semana em ingles: "))
switch (num) {
    case "1":
        console.log("Monday - Segunda-feira") 
        break;
    case "2":
        console.log("Tuesday - Terça-feira")
        break;
    case "3":
            console.log("Wednesday - Quarta-feira ")    
        break;
    case "4":
            console.log("Thursday - Quinta-feira")    
        break;
    case "5":
            console.log("Friday - Sexta-feira")    
        break;
    case "6":
            console.log("Saturday - Sábado")    
        break;
    case "7":
            console.log("Sunday - Domingo")    
        break;            
    default:
        console.log("Numero invalido!! Tente novamente")
        break;
}