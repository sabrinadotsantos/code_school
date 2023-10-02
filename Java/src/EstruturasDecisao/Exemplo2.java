package EstruturasDecisao;

import java.util.Scanner;

public class Exemplo2 {
    // 3. Faça um programa que receba um número inteiro do usuário e informe
// se este número é positivo ou negativo.

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um numero, para verificar se é positivo ou negativo");

        double numero = leitor.nextDouble();

        if (numero > 0) {
            System.out.println("O numero é positivo");
        }else if(numero < 0){
            System.out.println("É um numero negativo");
        }else {
            System.out.println("0 = 0");
        }
    }
}
