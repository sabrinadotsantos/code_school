import "./style.css"

import CardServicos from "../../components/CardServicos";


import { useEffect, useState } from "react";

import api from "../../utils/api";

function ListaServicos() {


    //state servicos
    const [servicos, setServicos] = useState<any[]>([]);
    const [techsDigitado, setTechsDigitado] = useState<string>("");

    function verificarCampoTechs(event: any) {
        if (event.target.value === "") {
            // setListaServicosFiltrados(servicos);
            listarServicos();
        }
        setTechsDigitado(event.target.value);
        
    }

    function buscarServicoPorTechs(event: any) {

        event.preventDefault();

        const techsFiltrados = servicos.filter((servicos: any) => servicos.techs.includes(techsDigitado.toLocaleUpperCase()));

        // console.log(techsDigitado);

        if (techsFiltrados.length === 0) {
            alert("Nenhum serviço com essa skill :(")
        } else {
            setServicos(techsFiltrados);
        }

    }
   

function listarServicos() {
    api.get("servicos")
      .then((response: any) => {
        setServicos(response.data)
      })

      .catch((error: any) => {
        console.log("Error ao realizar uma requisição", error);

      })

  }




useEffect(() => {
    listarServicos();
    

}, []);

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
                                    servicos.map((servicos: any, indice: number) => {
                                        return <li key={indice}>
                                            <CardServicos
                                                titulo={servicos.nome}
                                                valor={servicos.valor}
                                                descricao={servicos.descricao}
                                                listaTechs={servicos.techs} />
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