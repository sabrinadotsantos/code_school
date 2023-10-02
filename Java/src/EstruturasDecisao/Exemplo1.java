package EstruturasDecisao;

import java.util.Arrays;
import java.util.Scanner;

public class Exemplo1 {

    // 1. Faça um programa que receba o nome, cargo e salário de um
// funcionário. Se o funcionário ganhar abaixo de 1000 reais, calcule o
// salário acrescido de 10%. Ao final exiba o nome, o cargo e o salário
// desse funcionário

    //    método = função - sempre criar método principal
    public static void main(String[] args) {

//    System.in lê os dados do console

        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o seu salário: ");

        //1 lendo e retornando string, converter para double (parecido com JS)
        //nextLine(); le a proxima linha
        //double salario = Double.parseDouble(leitor.nextLine()); / converte apenas com .

        //2 nextDouble(); não precisa converter / utiliza padrão de casa decimal local ex. 9,9
        double salario = leitor.nextDouble();

        if (salario < 1000) {
            double salarioReajustado = salario * 1.1;
            System.out.println(salarioReajustado);
        } else {
            System.out.println("Salario sem reajuste! :(");
        }

    }
}
