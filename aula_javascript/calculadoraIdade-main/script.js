//Algoritmo

// CALCULAR IDADE

// 1. Pegar os valores
// 2. Calcular a Idade
//       a. Com base no ano
//       b. Com mês (EXTRA)
//       c. Com dia (EXTRA)

// 3. Gerar a faixa etária

//     Resultado            Faixa
//     0 à 12                Criança
//     13 à 17                Adolescente
//     18 à 65               Adulto
//     Acima de 65         Idoso

// 4. Organizar o objeto pessoa para salvar na lista
// 5. Cadastrar a pessoa na lista
// 6. Função para carregar as pessoas, carrega a lista do localStorage, chamar ao carregar a página
// 7. Renderizar o conteúdo da tabela com as pessoas cadastradas
// 8. Botão para limpar os registros;

//funçao

function calcularIdade(event) {
    // event.preventDefault()

    console.log("funcionando");

    let dadosUsuario = pegarValores();
    // let idade = calcular(dadosUsuario.ano_nascimento);
    // console.log(dadosUsuario);

    let idade = calcular(dadosUsuario.ano_nascimento);
    // console.log(idade);

    let faixaEtaria = gerarFaixaEtaria(idade);
    // console.log(faixaEtaria);

    let usuarioAtualizado = organizarDados(dadosUsuario, idade, faixaEtaria)
    // console.log(usuarioAtualizado);

    cadastrarUsuario(usuarioAtualizado);
    

}




//Passo 1 - Pegar os valores

function pegarValores() {
    let nomeRecebido = document.getElementById("nome").value.trim();
    let diaRecebido = parseInt(document.getElementById("dia_nascimento").value);
    let mesRecebido = parseInt(document.getElementById("mes_nascimento").value);
    let anoRecebido = parseInt(document.getElementById("ano_nascimento").value);

    let dadosUsuario = {
        nome: nomeRecebido,
        dia_nascimento: diaRecebido,
        mes_nascimento: mesRecebido,
        ano_nascimento: anoRecebido
    }

    console.log(dadosUsuario);

    return dadosUsuario;

}

// Passo 2 - Calcular

function calcular(ano_nascimento, dia_nascimento, mes_nascimento) {

    const anoAtual = new Date();

     let idade = anoAtual.getFullYear() - ano_nascimento;

    // let idade = parseInt(anoAtual - ano_nascimento)

    // Se o mês atual é maior que o do aniversário, então ele fez mais um ano de vida
    if (anoAtual.getMonth() > mes_nascimento) {
        idade++;
    } 
    
    // Se os meses são os mesmos mas os dias atuais são maiores ou iguais ao dia de aniversário, então ele fez mais um ano de vida
    else if (anoAtual.getMonth() == mes_nascimento && hoje.getDate() >= dia_nascimento) {
        idade++;
    }

    console.log(idade);

    return idade;


    console.log(idade);

    return idade;

}

// 3. Gerar a faixa etária

//     Resultado            Faixa
//     0 à 12                Criança
//     13 à 17                Adolescente
//     18 à 65               Adulto
//     Acima de 65         Idoso

function gerarFaixaEtaria(idade) {

    if (idade <= 12) {
        return "Criança!!!"
    } else if (idade >= 13 && idade <= 17) {
        return "Adolescente!!!"
    } else if (idade >= 18 && idade <= 65) {
        return "Adulto!!!"
    } else{
        return "Idoso!!!"
    }
        
}
    

// 4. Organizar o objeto pessoa para salvar na lista

function organizarDados(dadosUsuario, idadeAtual, faixaEtaria  ) {
    let dataHoraAtual = Intl.DateTimeFormat('pt-BR', { timeStyle: 'long', dateStyle: 'short' }).format(Date.now()) 

    let dadosUsuarioAtualizado = {
        ...dadosUsuario,
        idade: idadeAtual,
        faixa: faixaEtaria,
        dataCadastro:dataHoraAtual
    }

    console.log(dadosUsuarioAtualizado);
    return dadosUsuarioAtualizado;
    
}

// 5. Cadastrar a pessoa na lista

function cadastrarUsuario(usuario) {
    let listaUsuarios=[];

    if (localStorage.getItem("usuariosCadastrados")) {
        listaUsuarios = JSON.parse(localStorage.getItem("usuariosCadastrados"));
        
    }

    listaUsuarios.push(usuario)

    localStorage.setItem("usuariosCadastrados", JSON.stringify(listaUsuarios))
    
}

// 6. Função para carregar as pessoas, carrega a lista do localStorage, chamar ao carregar a página

function carregarUsuarios() {

    let listaUsuarios = [];

    if(localStorage.getItem("usuariosCadastrados")){
        listaUsuarios = JSON.parse(localStorage.getItem("usuariosCadastrados"));
    }

    if (listaUsuarios.length == 0) {
        let tabela = document.getElementById("corpo-tabela");
        tabela.innerHTML = `<tr class="linha-mensagem">
        <td colspan="6">Nenhum usuário cadastrado. </td>
    </tr>`
        
    }else{
        montarTabela(listaUsuarios);
    }



}

window.addEventListener("DOMContentLoaded", () => carregarUsuarios());

// 7. Renderizar o conteúdo da tabela com as pessoas cadastradas

function montarTabela(listaDeCadastrados) {
    let tabela = document.getElementById("corpo-tabela");

    let template = "";

    listaDeCadastrados.forEach(pessoa => {
        template += `<tr>
        <td data-cell="nome">${pessoa.nome}</td>
        <td data-cell="data de nascimento">${pessoa.dia_nascimento}/${pessoa.mes_nascimento}/${pessoa.ano_nascimento}</td>
        <td data-cell="idade">${pessoa.idade}</td>
        <td data-cell="faixa etária">${pessoa.faixa}</td>
    </tr> `
    })

    tabela.innerHTML = template;
    

}

// 8. Botão para limpar os registros;

function deletarRegistros() {
    localStorage.removeItem("usuariosCadastrados")
    window.location.reload();   
}