import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        ArrayList<Livro> listaLivro = new ArrayList<>();

//        Livro metodoIdade = new Livro();
//        Livro  novoLivro = new Livro ();

        Livro metodoLivro = new Livro();

        System.out.println(" Bem vindo ao sistema de cadastro e listagem de livros. Atenção! Este sebo que só aceita livros com mais de 5  anos de lançamento.");

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {
            System.out.println("Escolha uma opção 1 - Cadastrar Livro  / 2 - Listar Livros  / 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":

                    Livro novoLivro = new Livro();
                    Autor novoAutor = new Autor();


                    System.out.println("Digite a data de lancamento do livro: (dd/mm/aaaa)");
                    novoLivro.dataLanca = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));


                    Period idadeLivro = Period.between(novoLivro.dataLanca, LocalDate.now());


                    if (idadeLivro.getYears() >= 5) {
                        System.out.println("Data de lançamento valida! O livro tem: " + +idadeLivro.getYears() + " anos!");
                        System.out.println("");
                    } else {
                        System.out.println("Data de lançamento invalida!");
                        break;
                    }


                    System.out.println("Digite o título do livro: ");
                    novoLivro.titulo = leitor.next();

                    System.out.println("Digite o preço do livro: ");
                    novoLivro.preco = leitor.nextFloat();

                    System.out.println("Digite o nome do autor do livro: ");
                    novoAutor.nome = leitor.next();

                    System.out.println("Digite o local de nascimento do autor: ");
                    novoAutor.localNasc = leitor.next();


                    novoLivro.autor = novoAutor;

                    metodoLivro.CadastrarLivro(novoLivro);

//                    listaLivro.add(novoLivro);

//                    System.out.println("Cadastro realizado com sucesso! :)");
                    break;

                case "2":
//                    System.out.println(listaLivro);
                    if (metodoLivro.listaLivro.size() > 0) {

                        for (Livro cadaLivro : metodoLivro.listaLivro) {
                            System.out.println("Titulo: " + cadaLivro.titulo);

                            System.out.println("Data de Lançamento: " + cadaLivro.dataLanca.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println("Autor: " + cadaLivro.autor.nome + " E local de Nascimento " + cadaLivro.autor.localNasc);
                            System.out.println("Preco: " + cadaLivro.preco);
                            System.out.println();
                            System.out.println("Aperte ENTER para continuar");
                      //      leitor.nextLine();
                        }
                    } else {
                        System.out.println("A lista está vazia!");
                    }
                    break;

                case "0":
                    break;
            }

        } while (!opcao.equals("0"));

    }
}