import React from 'react';
import ReactDOM from 'react-dom/client';

//componentes
import Header from './components/Header';
import Home from './pages/Home/index';
import ListaServicos from './pages/ListaServicos';
import ListaDevs from './pages/ListaDevs';
import Perfil from './pages/PerfilUsuario';
import Servico from './pages/VisualizarServico';
import CadastroUsuario from './pages/CadastroUsuario';
import CadastroServico from './pages/CadastroServico';
import Login from './pages/Login'
import Footer from './components/Footer';

//estilizaçào global
import "./index.css" // css padrão para todas as paginas

//rotas
import { Route, BrowserRouter, Routes } from 'react-router-dom'
import secureLocalStorage from 'react-secure-storage'

//verificando se o usuario esta logado ou nao
function logado() {
  if (secureLocalStorage.getItem("user")) {

    const objetoUsuario: any = secureLocalStorage.getItem("user");
    // trim tira espaços, split divide a string (" ") / quebra as palavra que tiver o espaço / vira um array dos nomes
    const nome: string = objetoUsuario.user.nome.trim().split(" ")[0];

    return { logado: true, nomeUsuario: nome }
  }
  else {
    return { logado: false, nomeUsuario: null }
  }

}


ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(



  // React.StrictMode agrupador de itens / div pai  React.fragment
  <React.StrictMode> {/*mostra erros*/}
    <BrowserRouter> {/*Indica que a aplicaçao terá rotas */}
      <Header usuario={logado()}/>  {/*Chamando usuario logado */}
      <Routes> {/*Indica uma lista de rotas */}
        <Route path='/' element={<Home />} /> {/* Indica o caminho do componente e o nome da roda dele | Path = nome do caminho da rota */}
        <Route path='lista-servicos' element={<ListaServicos />} />
        <Route path='lista-devs' element={<ListaDevs />} />
        <Route path='perfil/:idUsuario' element={<Perfil />} /> {/*:idUsuario (parametro da rota) pegas as informaçoes do usuario*/}
        <Route path='visualizarServico/:idServico' element={<Servico />} />
        <Route path='cadastro-usuario' element={<CadastroUsuario />} />
        <Route path='cadastro-servico' element={<CadastroServico />} />
        <Route path='login' element={<Login />} />
      </Routes>


      <Footer />
    </BrowserRouter>

  </React.StrictMode>





)
