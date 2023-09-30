import "./style.css"

import CardDev from "../../components/CardDev";

import { useState } from "react";




function ListaDevs() {

  // state devs
  const [devs, setDevs] = useState<any[]>([
    {
      img_perfil: "https://github.com/sabrinadotsantos.png",
      nome: "Sabrina",
      email: "sabrina@email.com",
      skills: ["PYTHON", "VUE", "React"]
    },
    {
      img_perfil: "https://github.com/Hosmairys.png",
      nome: "Hosmairys",
      email: "hosmairys@email.com",
      skills: ["PYTHON", "VUE", "React"]
    },

    {
      img_perfil: "https://github.com/alanmmartins.png",
      nome: "Alan M Martins",
      email: "alanmmartins@email.com",
      skills: ["PYTHON", "VUE", "React"]
    },
    {
      img_perfil: "https://github.com/Thiago-Nascimento.png",
      nome: "Thiago Nascimento",
      email: "thiago@email.com",
      skills: ["HTML", "CSS", "React"]
    },
    {
      img_perfil: "https://github.com/JessicaSanto.png",
      nome: "Jessica Franzon",
      email: "jessica@email.com",
      skills: ["HTML", "CSS", "React"]
    },
    {
      img_perfil: "https://github.com/odirlei-assis.png",
      nome: "Odirlei Sabella",
      email: "odirlei@email.com",
      skills: ["HTML", "CSS", "React"]
    },
    {
      img_perfil: "https://github.com/alexiamelhado18.png",
      nome: "Aléxia Vitória",
      email: "alexia@email.com",
      skills: ["PYTHON", "VUE", "React"]
    },


  ]);

  //Hooks são funções JavaScript que permitem que você use recursos do React
  // state é como uma “variável” dentro de um componente.
  // useState é um hook que permite ao componente funcional ter um estado / ele serve para criar essa “variável”.
  // setState é para mudar o valor do estado. mudar o valor da “variável”.





  const [listaDevsFiltrados, setListaDevsFiltrados] = useState<any[]>(devs);

  const [skillDigitado, setSkillDigitado] = useState<string>("");

  function verificarCampoSkill(event: any) {
    if (event.target.value === "") {
      setListaDevsFiltrados(devs);
    }
    setSkillDigitado(event.target.value);
  }

  function buscarDevPorSkill(event: any) {
    //não recarrega a pagina
    event.preventDefault();

    //filtrar devs pela skill digitada no campo buscar
    const devsFiltrados = devs.filter((dev: any) => dev.skills.includes(skillDigitado.toLocaleUpperCase()));

    if (devsFiltrados.length === 0) {
      alert("Nenhum desenvolvedor(a) com essa skill :(")
    } else {
      //atribui valor de devs filtrado, ao state ListaDevsFiltrados 
      setListaDevsFiltrados(devsFiltrados);
    }


  }


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
              listaDevsFiltrados.map((dev: any, indice: number) => {
                return <li key={indice}>
                  <CardDev
                    foto={dev.img_perfil}
                    nome={dev.nome}
                    email={dev.email}
                    listaTechs={dev.skills} />
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