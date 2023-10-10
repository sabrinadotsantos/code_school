public class PessoaJuridica extends Pessoa {
    public String cnpj;
    public String razaoSocial;


    public float CalcularImposto(float rendimento) {
//                Pessoa Juridica
//                até 3000 - 3 %
//                de 3000 até 6000 - 5 %
//                de 6000 até 10000 - 7 %
//                acima de 10000 - 9 %

        if (rendimento <= 3000) {
            return rendimento * .03f;
        } else if (rendimento <= 6000){
            return rendimento * .05f;
        } else if (rendimento <= 10000) {
            return rendimento * .07f;
        } else {
            return rendimento * .09f;
        }

    }

}