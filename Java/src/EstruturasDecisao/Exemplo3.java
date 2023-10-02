package EstruturasDecisao;

import java.util.Scanner;

public class Exemplo3 {

    // 5. Faça um programa receba dois valores e imprima qual é o maior
// número digitado.

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o primeiro valor");
        double valor1 = leitor.nextDouble();

        System.out.println("Digite o segundo valor");
        double valor2 = leitor.nextDouble();


        if (valor1 > valor2) {
            System.out.println("O primeiro numero digitado é o maior");
        } else if (valor2 > valor1) {
            System.out.println("É um numero negativo");
        } else {
            System.out.println("Os numeros sao iguais");
        }
    }

}
