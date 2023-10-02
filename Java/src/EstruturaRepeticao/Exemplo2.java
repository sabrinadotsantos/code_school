package EstruturaRepeticao;

import java.util.Scanner;

public class Exemplo2 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        //comparar duas strings em java utilizar equals - se for diferente !

        String senha;

        do {
            //o que for lido na linha salva na variavel senha
            System.out.println("Digite sua senha:");
            senha = leitor.nextLine();

            if (!senha.equals(("123"))){
                System.out.println("A senha está incorreta");
            }

        }while (!senha.equals("123")); //enquanto a senha for diferente de 123 continue executando
    }
}
