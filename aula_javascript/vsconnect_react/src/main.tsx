import React from 'react';
import ReactDOM from 'react-dom/client';

//componentes
// import Home from './pages/Home/index';
import ListaServicos from './pages/ListaServicos/index';

//estilizaçào global

import "./index.css" // css padrão para todas as paginas

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <ListaServicos/>
  </React.StrictMode>,
)
