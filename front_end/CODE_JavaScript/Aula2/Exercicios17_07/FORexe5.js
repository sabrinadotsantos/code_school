// 5. Imprimir os primeiros 10 números da sequência de Fibonacci.

//  0,1, 1, 2, 3, 5, 8, 13, 21, 34


// let n1 = 0
// let n2 = 1
// let n3 = 0
// for (let index = 1; index <= 8; index++) {

//     let n3 = n1 + n2

//     console.log(`${n1} + ${n2} + ${n3} `);

//     n1 = n2
//     n2 = n3



// }


// for (n in 0 until  (quantidade - 2 )){
//            Fn = N1 + N2;
//            N1 = N2;
//            N2 = Fn;


import promptSync from "prompt-sync";

const prompt = promptSync();

export function seqFibonacci() {
    console.log("5. Imprimir os primeiros 10 números da sequência de Fibonacci");
    
    let n1 = 0
    let n2 = 1
    // let n3 = 0
    for (let index = 1; index <= 8; index++) {
    
        let n3 = n1 + n2
    
        console.log(`${n1} + ${n2} + ${n3} `);
    
        n1 = n2
        n2 = n3
    
    
    
    }

}