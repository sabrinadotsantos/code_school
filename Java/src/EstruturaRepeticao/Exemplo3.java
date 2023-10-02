package EstruturaRepeticao;

import java.util.Scanner;

public class Exemplo3 {

    //
    public static void main(String[] args) throws InterruptedException {

        String [] listaCarros = {"Gol", "Fusca", "Up", "Swift", "Renegade"};

        for(String cadaCarro : listaCarros){
            System.out.println(cadaCarro);
            Thread.sleep(1000);
        }
    }
}
