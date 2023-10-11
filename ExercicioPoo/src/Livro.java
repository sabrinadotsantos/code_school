import java.time.LocalDate;
import java.util.ArrayList;

public class Livro {

    public String titulo;
    public Autor autor;
    public float preco;
    public LocalDate dataLanca;

    ArrayList<Livro> listaLivro = new ArrayList<>();

    public void CadastrarLivro (Livro novoLivro ) {
        listaLivro.add(novoLivro);

        System.out.println("Cadastro realizado com sucesso!!!");

    }
}






