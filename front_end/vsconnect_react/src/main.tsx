import React from 'react';
import ReactDOM from 'react-dom/client';

//componentes
import Header from './components/Header';
import Home from './pages/Home/index';
import ListaServicos from './pages/ListaServicos';
import ListaDevs from './pages/ListaDevs/index';
import Footer from './components/Footer';

//estilizaçào global
import "./index.css" // css padrão para todas as paginas

//rotas
import { Route, BrowserRouter, Routes } from 'react-router-dom'




ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  


  // React.StrictMode agrupador de itens / div pai  React.fragment
   <React.StrictMode> {/*mostra erros*/}
    <BrowserRouter> {/*Indica que a aplicaçao terá rotas */}
      <Header />
      <Routes> {/*Indica uma lista de rotas */}
        <Route path='/' element={<Home />}/> {/* Indica o caminho do componente e o nome da roda dele | Path = nome do caminho da rota */}
        <Route path='lista-servicos' element={<ListaServicos />}/>
        <Route path='lista-devs' element={<ListaDevs />}/>


      </Routes>
      <Footer/>
    </BrowserRouter>

  </React.StrictMode>
 




)
