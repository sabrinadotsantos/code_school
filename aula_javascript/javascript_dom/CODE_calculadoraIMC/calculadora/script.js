//Algoritmo

//CALCULARIMC
//1. Pegar os valores
//2. Calcular con IMC
//3. Generar a clasificação do IMC
//4. Organizar as informações
//5. Salvat os dados na lista
//6. Ler a lista com os datos
//7. Renderizar o conteudo no HTML
//8. Botão de limpar os registros

//FUNÇÂO CALCULAR
function calcularIMC(event) {
    // event.preventDefault()

    console.log("FUNCIONANTE!!");

    let dadosUsuario = pegarValores();

    let imc = Calcular(dadosUsuario.altura, dadosUsuario.peso);

    let classificacaoImc = classificarImc();

    let usuarioAtualizado = organizarDados(dadosUsuario, imc, classificacaoImc)

    cadastrarUsuario(usuarioAtualizado);


    // console.log(classificarImc(imc));
}


//Passo 1 - Pegar valor
function pegarValores() {
    let nomeRecibido = document.getElementById("nome").value.trim();//value é para pegar o que esta dentro do nome o que o usuario coloca(valor). trim é para tirar os espaços que o usuario coloca e poder calcular a soma certa dos valores.
    let alturaRecibida = parseFloat(document.getElementById("altura").value);
    let pesoRecibido = parseFloat(document.getElementById("peso").value);

    let dadosUsuario = {
        nome: nomeRecibido,
        altura: alturaRecibida,
        peso: pesoRecibido
    }

    console.log(dadosUsuario);

    return dadosUsuario;
}

// Passo 2 - Calcular

function Calcular(altura, peso) {
    let imc = peso / (altura * altura)

    console.log(imc);

    return imc;
}

// Passo 3 - classificar
function classificarImc(imc) {
    /*
        Resultado               Situação
        Abaixo de 18,5          Filezinho!!!
        Entre 18,5 e 24,99      Deliça!!!
        Entre 25 e 29,99        Ta Top!!!
        Acima de 30             Oh la em casa!!!

    */

    if (imc < 18.5) {
        return "Filezinho!!!"
    } else if (imc < 25) {
        return "Deliça!!!"
    } else if (imc < 30) {
        return "Ta Top!!!"
    } else {
        return "Oh la em casa!!!"
    }
}

// Passo 4 - organizar informações - todas soltas para um objeto novo
function organizarDados(dadosUsuario, valorImc, classificacaoImc) {
    let dataHoraAtual = Intl.DateTimeFormat('pt-BR', { timeStyle: 'long', dateStyle: 'short' }).format(Date.now())     //Intl formataçao data, moeda

    let dadosUsuarioAtualizado = {
        ...dadosUsuario,
        imc: valorImc.toFixed(2),
        classificacao: classificacaoImc,  //... tres pontinhos q indicam que todos atributos dados usuarios / toFixed - duas casas decimais
        dataCadastro: dataHoraAtual
    }

    console.log(dadosUsuarioAtualizado);

    return dadosUsuarioAtualizado;

}

// Passo 5 - Salvar

function cadastrarUsuario(usuario) {
    let listaUsuarios = [];

    if (localStorage.getItem("usuariosCadastrados")) {
        listaUsuarios = JSON.parse(localStorage.getItem("usuariosCadastrados"));

    }

    listaUsuarios.push(usuario)

    localStorage.setItem("usuariosCadastrados", JSON.stringify(listaUsuarios))

}

//Passo 6 - Ler a lista

function carregarUsuarios() {

    let listaUsuarios = [];

    if (localStorage.getItem("usuariosCadastrados")) {
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

//7 - Renderizar dados tabela / Montar a tabela

function montarTabela(listaDeCadastrados) {
    let tabela = document.getElementById("corpo-tabela");

    let template = "";

    listaDeCadastrados.forEach(pessoa => {
        template +=   `<tr>
        <td data-cell="nome">${pessoa.nome}</td>
        <td data-cell="altura">${pessoa.altura}</td>
        <td data-cell="peso">${pessoa.peso}</td>
        <td data-cell="valor do IMC">${pessoa.imc}</td>
        <td data-cell="classificação do IMC">${pessoa.classificacao}</td>
        <td data-cell="data de cadastro">${pessoa.dataCadastro}</td>
    </tr> `
    });

    tabela.innerHTML = template;

}

// Passo 8 -  Limpar local storage

function deletarRegistros() {
    localStorage.removeItem("usuariosCadastrados")
    window.location.reload();   
}