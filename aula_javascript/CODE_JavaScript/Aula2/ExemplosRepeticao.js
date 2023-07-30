let nomes = ["Alana", "Alexia", "Samanta", "Thiago", "Odirlei"]


// for (let contador = 0; contador < nomes.length; contador++) {
//     const cadaElemento = nomes[contador];

//     console.log(cadaElemento);
    
// }

// nomes.forEach((cadaElemento, posicao )=> {
//     console.log(posicao, cadaElemento);
    
// });

// nomes.forEach(cadaElemento => {
//     console.log(cadaElemento);
    
// });


const frutas = ["Pera", "Uva", "Maça", "Salada mista"]

// for (let contador = 0; contador < frutas.length; contador++) {
//     const cadaElemento = frutas[contador];
    
//     console.log(contador, cadaElemento);
// }

// frutas.forEach(cadaElemento => {
//     console.log(cadaElemento);
// })


let salario = 1000;
let contador = 0;

// while (salario < 5000) {

//     salario += 100; // salario = salario + 100;
//     contador ++;
    
    
//     console.log("O seu salario ainda é R$" + salario);
// }
// console.log(contador);


// do{
//     salario += 100;
//     contador++;
//     console.log(" DO O seu salario ainda é R$: "+ salario);
// } while (salario < 5000);

const prompt = require(`prompt-sync`)()

let numeroEscolhido 

// do{
//     numeroEscolhido = parseInt (prompt("Digite um numero: "))

//     console.log();

// }while (numeroEscolhido != 5)
//     console.log("Acertou!");

// while(numeroEscolhido !=5){
//     numeroEscolhido = prompt("Digite um numero: ")
    
// }

let senha 
do {

    senha = prompt("Digite a senha: ")
    if(senha != 123){
        console.log("Senha incorreta!");
    }
    

} while (senha != "123");
console.log("Senha correta!");