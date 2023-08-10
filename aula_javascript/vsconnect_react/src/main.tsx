import React from 'react';
import ReactDOM from 'react-dom/client';

//componentes
import Home from './pages/Home/index';
// import ListaServicos from './pages/ListaServicos/index';
import Header from './components/Header';
import Footer from './components/Footer';

//estilizaçào global
import "./index.css" // css padrão para todas as paginas

//rotas
// import { Route, BrowserRouter, Routes } from 'react-router-dom'

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <Header />
    <Home />
    {/* <ListaServicos/> */}
    <Footer/>
  </React.StrictMode>,
)
