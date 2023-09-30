import "./style.css"

import CardServicos from "../../components/CardServicos";


import { useState } from "react";

function ListaServicos() {


    //state servicos
    const [servicos, setServicos] = useState<any[]>([

        {
            titulo: "Desenvolvimento de site institucional - Gateway de Pagamento / Fintech",
            descricao: "Desenvolver um site responsivo que seja utilizado como uma plataforma de apresentação do nosso gateway de pagamento. O objetivo principal deste projeto é criar um site atraente e informativo, que demonstre as funcionalidades e benefícios do nosso gateway de pagamento para potenciais clientes.",
            proposta: 1300,
            techs: [
                "HTML",
                "CSS",
                "REACT"
            ]
        },
        {
            titulo: "Bot telegram Pagamento",
            descricao: "Preciso fazer um código em python para um bot do telegram. O bot será para solicitação de pagamento.",
            proposta: 2400,
            techs: [
                "PYTHON"
            ]
        },
        {
            titulo: "Caixa Rápido",
            descricao: "Preciso fazer um software que permita ao usuário fazer o upload de seu extrato bancário em formato( ofx). Dentro do software o mesmo poderá categorizar todas as suas receitas e despesas, tendo categorias sugeridas pelo software e permitindo também personalizações. Após o lançamento de vários extratos o software irá entender que são lançamentos parecidos e fará a categorização de maneira automática, cabendo ao usuário somente categorizar as receitas e despesas que não se repetem. Após a categorização o software irá emitir gráficos e relatórios baseados na categorização das contas.",
            proposta: 1200,
            techs: [
                "PYTHON"
            ]
        },


    ]);


    const [listaServicosFiltrados, setListaServicosFiltrados] = useState<any[]>(servicos);

    const [techsDigitado, setTechsDigitado] = useState<string>("");

    function verificarCampoTechs(event: any) {
        if (event.target.value === "") {
            setListaServicosFiltrados(servicos);
        }
        setTechsDigitado(event.target.value);

        
        
    }

    function buscarServicoPorTechs(event: any) {

        event.preventDefault();

        const techsFiltrados = servicos.filter((servicos: any) => servicos.techs.includes(techsDigitado.toLocaleUpperCase()));

        // console.log(techsDigitado);

        if (techsFiltrados.length === 0) {
            alert("Nenhum serviço com essa tech :(")
        } else {
            setListaServicosFiltrados(techsFiltrados);
        }

    }




    return (
        <div>
            <main>
                <div className="container container_lista_servicos">
                    <div className="lista_servicos_conteudo">
                        <h1>Lista de Serviços</h1>
                        <hr />
                        <form method="post" onSubmit={buscarServicoPorTechs}>
                            <div className="wrapper_form">
                                <label htmlFor="busca">Procurar serviços</label>
                                <div className="campo-label">
                                    <input type="search" name="campo-busca" id="busca" placeholder="Buscar serviços por tecnologias..." autoComplete="off"
                                        onChange={verificarCampoTechs}
                                    />
                                    <button type="submit">Buscar</button>
                                </div>
                            </div>
                        </form>
                        <div className="wrapper_lista">
                            <ul>
                                {
                                    listaServicosFiltrados.map((servico: any, indice: number) => {
                                        return <li key={indice}>
                                            <CardServicos
                                                titulo={servico.titulo}
                                                proposta={servico.proposta}
                                                descricao={servico.descricao}
                                                listaTechs={servico.techs} />
                                        </li>
                                    })
                                }

                            </ul>
                        </div>
                    </div>
                </div>
            </main>
        </div>

    );

}

// o componente home pode ser chamado em outros arquivos
export default ListaServicos;