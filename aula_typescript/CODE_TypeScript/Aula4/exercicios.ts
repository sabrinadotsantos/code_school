import promptSync from "prompt-sync";

const prompt = promptSync();


export function numero1a10() {
    console.log("1. Imprimir números de 1 a 10 utilizando o loop for");


    for (let index: number = 1; index < 10; index++) {
        console.log(index)
    }
}



export function pares1a10() {
    console.log("2. Imprimir números pares de 1 a 10.");

    for (let index: number = 0; index < 10; index += 2) {
        console.log(index)
    }


}

export function imprimirImpares() {
    console.log("3. Faça um programa que imprima os números ímpares de 0 a 50");

    for (let index: number = 1; index < 50; index += 2) {
        console.log(index)
    }

}

export function tabuada() {
    console.log("4. Faça um programa que imprima na tela a tabuada de um número qualquer escolhido pelo usuário até o 10.");


    let numero: number = parseInt (prompt("Digite um numero para calcular a tabuada: "));

    for (let index: number = 1; index <= 10; index++) {

        const multi = index * numero

        console.log(`${index} multiplicado por ${numero} é igual a:  ${multi}`)
    }

}


export function seqFibonacci() {
    console.log("5. Imprimir os primeiros 10 números da sequência de Fibonacci");

    let n1: number = 0;
    let n2: number = 1;
    // let n3 = 0
    for (let index: number = 1; index <= 8; index++) {

        let n3: number = n1 + n2

        console.log(`${n1} + ${n2} + ${n3} `);

        n1 = n2
        n2 = n3

    }

}

export function pares0a20() {
    console.log(" 6. Imprimir números pares de 0 a 20 utilizando o loop while");


    let contador: number = 2;

    while (contador <= 20) {
        console.log(contador);

        contador += 2
    }



}

export function soma1a100() {
    console.log("7. Calcular a soma dos números de 1 a 100 utilizando a estrutura while.");


    let contador: number = 0;
    let soma: number = 0;

    while (contador < 100) {
        contador++
        soma = soma + contador

        console.log(`${contador}  ${soma}`);

    }


}


export function verificarMaiorIdade() {
    console.log("8. Faça um programa que receba o nome, idade, altura, peso do usuário, enquanto a resposta do usuário for menor que 18 anos continue a solicitar a idade e mostre uma mensagem quando a idade do usuário for maior que 18.");

    let pessoa: {nome: string, idade: number} = {
        nome: "",
        idade: 0,
    }


    // let numero

    do {
        pessoa.idade = parseInt(prompt("Digite sua idade: "));
        pessoa.nome = prompt("Digite seu nome: ");



    } while (pessoa.idade < 18 ) {
        console.log("Maior de idade!");
        console.log("Objeto", pessoa);
        console.log(`${pessoa.nome}, sua idade ${pessoa.idade}. Verificação é válida!`);
    }
}

let numero: number

export function regressiva() {

   console.log("9 - Faça um programa que receba um número do usuário e mostre no console a contagem regressiva até 0.");

   numero = parseInt( prompt ("Digite um numero: "))

   while (numero >= 0) {
      console.log(numero);
      numero--; 
   }

}

export function diferentede0() {
    console.log("10 - Faça um programa que receba um número do usuário e continue a pedir o número se o numero for diferente de 0.");
    
    let numero: number
do {
    numero = parseInt (prompt ("Digite um numero: "))
    
}while (numero != 0) {
    console.log("Numero igual a 0. Programa encerrado!");
    
}

}

