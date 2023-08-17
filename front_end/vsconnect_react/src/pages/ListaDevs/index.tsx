import "./style.css"

import CardDev from "../../components/CardDev";

import { useEffect, useState } from "react";

import api from "../../utils/api";


//Hooks são funções JavaScript que permitem que você use recursos do React
// state é como uma “variável” dentro de um componente.
// useState é um hook que permite ao componente funcional ter um estado / ele serve para criar essa “variável”.
// setState é para mudar o valor do estado. mudar o valor da “variável”.


function ListaDevs() {

  // state devs
  const [devs, setDevs] = useState<any[]>([]);

  // const [listaDevsFiltrados, setListaDevsFiltrados] = useState<any[]>(devs);

  const [skillDigitado, setSkillDigitado] = useState<string>("");

  function verificarCampoSkill(event: any) {
    if (event.target.value === "") {
      // setListaDevsFiltrados(devs); retorno front
      listarDesenvolvedores(); // retorno da api

    }
    setSkillDigitado(event.target.value);
  }

  function buscarDevPorSkill(event: any) {
    //não recarrega a pagina
    event.preventDefault();

    //filtrar devs pela skill digitada no campo buscar
    const devsFiltrados = devs.filter((dev: any) => dev.hardSkills.includes(skillDigitado.toLocaleUpperCase()));

    if (devsFiltrados.length === 0) {
      alert("Nenhum desenvolvedor(a) com essa skill :(")
    } else {
      //atribui valor de devs filtrado, ao state ListaDevsFiltrados 
      // setListaDevsFiltrados(devsFiltrados);
      setDevs(devsFiltrados);
    }


  }

  //obter devs da api

  function listarDesenvolvedores() {
    api.get("users")
      .then((response: any) => {
        console.log(response);
        setDevs(response.data)
      })

      .catch((error: any) => {
        console.log("Error ao realizar uma requisição", error);

      })

  }


  //monitorar componente - só sera executado dps que a tela carregar
  useEffect(() => {
    //executa ação
    listarDesenvolvedores();

  }, []);


  return (


    <main id="main_listadevs">
      <div className="container container_lista_devs">
        <div className="lista_devs_conteudo">
          <h1>Lista de Devs</h1>
          <hr />
          <form method="post" onSubmit={buscarDevPorSkill}>
            <div className="wrapper_form">
              <label htmlFor="busca">Procurar desenvolvedores</label>
              <div className="campo-label">
                <input
                  type="search"
                  name="campo-busca"
                  id="busca"
                  placeholder="Buscar desenvolvedores por tecnologias..."
                  autoComplete="off"
                  onChange={verificarCampoSkill}
                />
                <button type="submit">Buscar</button>
              </div>
            </div>
          </form>
          <div className="wrapper_lista">
            <ul>
              {
                devs.map((dev: any, indice: number) => {
                  return <li key={indice}>
                    <CardDev
                      foto={dev.user_img}
                      nome={dev.nome}
                      email={dev.email}
                      listaTechs={dev.hardSkills} />
                  </li>
                })
              }
            </ul>
          </div>
        </div>
      </div>
    </main >



  );

}
export default ListaDevs;