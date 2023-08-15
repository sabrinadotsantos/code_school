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


  return (


    <main id="main_listadevs">
      <div className="container container_lista_devs">
        <div className="lista_devs_conteudo">
          <h1>Lista de Devs</h1>
          <hr />
          <form method="post">
            <div className="wrapper_form">
              <label htmlFor="busca">Procurar desenvolvedores</label>
              <div className="campo-label">
                <input
                  type="search"
                  name="campo-busca"
                  id="busca"
                  placeholder="Buscar desenvolvedores por tecnologias..."
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
    </main>



  );

}
export default ListaDevs;