import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        ArrayList<PessoaJuridica> listaPj = new ArrayList<>();


        //metodos globais / nao armazena dados
        PessoaFisica metodoPf = new PessoaFisica();
        PessoaJuridica metodoPj = new PessoaJuridica();
        // array no java não pode ser alterado - arraylist permite alteração


        System.out.println("Bem vindo ao sistema de cadastro de Pessoas Fisicas e Juridicas");

        Scanner leitor = new Scanner(System.in);


        String opcao;

        do {

            System.out.println("Escolha uma opção 1 - Pessoa Física / 2 - Pessoa Jurídica / 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":

                    String opcaoPf;
                    do {
                        System.out.println("Digite uma opção: 1 - Cadastrar PF / 2 - Listar PF / 0 - Voltar");
                        opcaoPf = leitor.nextLine();

                        switch (opcaoPf) {

                            case "1":

                                PessoaFisica novaPf = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.println("Digite o nome: ");
                                novaPf.nome = leitor.nextLine();

                                System.out.println("Digite o cpf");
                                novaPf.cpf = leitor.nextLine();

                                System.out.println("Digite o rendimento");
                                novaPf.rendimento = leitor.nextFloat();

                                System.out.println("Digite a data de nascimento: (dd/mm/aaaa)");
                                novaPf.dataNasc = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")); //convertendo tipo data / DateTimeFormatter.ofPattern("") > definindo padrao da data

                                //pegando data atual
                                // between pega duas datas e verifica a diferença entre elas
                                Period idade = Period.between(novaPf.dataNasc, LocalDate.now());

                                //pegando o ano dentro da variavel e comparar
                                if (idade.getYears() >= 18) {
                                    System.out.println("Idade Válida!");
                                } else {
                                    System.out.println("Idade Inválida");
                                    break;
                                }

                                System.out.println(("Digite o logradouro"));
                                novoEndPf.logradouro = leitor.next();


                                System.out.println("Digite o numero");
                                novoEndPf.numero = Integer.parseInt(leitor.nextLine());

                                System.out.println("É endereço comercial? S/N");

                                String endCom = leitor.next();

                                if (endCom.equals("S") || endCom.equals("s")) {
                                    novoEndPf.endComercial = true;
                                } else {
                                    novoEndPf.endComercial = false;
                                }

                                novaPf.endereco = novoEndPf;

                                listaPf.add(novaPf);

                                System.out.println("Cadastro realizado com sucesso! :)");

                                break;
                            case "2":
                                //verificar se a lista esta vazia - validação
                                if (listaPf.size() > 0) {

                                    //para cada PF da lista PF
                                    for (PessoaFisica cadaPf : listaPf) {
                                        System.out.println("Nome " + cadaPf.nome);
                                        System.out.println("CPF " + cadaPf.cpf);
                                        System.out.println("Data de nascimento " + cadaPf.dataNasc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago " + metodoPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println("Endereco " + cadaPf.endereco.logradouro + " - " + cadaPf.endereco.numero);
                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar");
                                        leitor.nextLine();
                                    }

                                } else {
                                    System.out.println("A lista vazia");
                                }
                                break;
                            case "0":
                                System.out.println("volta");
                                break;
                            default:
                                System.out.println("Opção invalida");
                                break;
                        }
                    } while (!opcaoPf.equals("0"));

                    break;

                case "2":

                    String opcaoPJ;
                    do {
                        System.out.println("Digite uma opção: 1 - Cadastrar PJ / 2 - Listar PJ / 0 - Voltar");
                        opcaoPJ = leitor.nextLine();

                        switch (opcaoPJ) {


                            case "1":

                                PessoaJuridica novaPj = new PessoaJuridica();
                                Endereco novoEndPj = new Endereco();


                                System.out.println("Digite a razao social");
                                novaPj.razaoSocial = leitor.nextLine();

                                System.out.println("Digite o cnpj");
                                novaPj.cnpj = leitor.nextLine();

                                System.out.println("Digite o rendimento");
                                novaPj.rendimento = Float.parseFloat(leitor.nextLine());

                                System.out.println(("Digite o logradouro"));
                                novoEndPj.logradouro = leitor.nextLine();


                                System.out.println("Digite o numero");
                                novoEndPj.numero = Integer.parseInt(leitor.nextLine());

                                System.out.println("É endereço comercial? S/N");
                                String endCom = leitor.next();

                                if (endCom.equals("S") || endCom.equals("s")) {
                                    novoEndPj.endComercial = true;
                                } else {
                                    novoEndPj.endComercial = false;
                                }

                                novaPj.endereco = novoEndPj;

                                listaPj.add(novaPj);

                                System.out.println("Cadastro realizado com sucesso! :)");
                                break;
                            case "2":
                                //verificar se a lista esta vazia - validação
                                if (listaPj.size() > 0) {

                                    //para cada PF da lista PF
                                    for (PessoaJuridica cadaPj : listaPj) {
                                        System.out.println("Razao Social " + cadaPj.razaoSocial);
                                        System.out.println("CNPJ " + cadaPj.cnpj);
                                        System.out.println("Imposto a ser pago " + metodoPj.CalcularImposto(cadaPj.rendimento));
                                        System.out.println("Endereco " + cadaPj.endereco.logradouro + " - " + cadaPj.endereco.numero);
                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar");
                                        leitor.nextLine();
                                    }

                                } else {
                                    System.out.println("A lista vazia");
                                }
                                break;

                            case "0":

                                break;

                            default:

                                break;
                        }

                    } while (!opcaoPJ.equals("0"));
                    break;
            }
        }while (!opcao.equals("0"));
    }
}