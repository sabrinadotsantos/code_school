Comandos React

Criação do projeto em React + TypeScript –  npm init vite@latest nome-do-projeto -- --template react-ts 

cd helloWorld/

Instalar as dependências do projeto - npm install

Inicializar o projeto - npm run dev


ARQUIVO - tsconfig.json
/* Bundler mode */
    "moduleResolution": "node", / alterar para node
    // "allowImportingTsExtensions": // true, comentar a segunda linha
    "resolveJsonModule": true,
    "isolatedModules": true,
    "noEmit": true,
    "jsx": "react-jsx",

acrescentar acima do bundler:

"esModuleInterop": true,
"allowSyntheticDefaultImports": true,

////////////////////////////////////////
apagar a extensão tsx arquivo mais.tsx - import App from './App'



1 - criar o projeto
2 - baixar as dependencias
3 - inicializar o projeto

-------------------------------------
apagar index.css - retirar o import css do main.tsx

COMPONENTE PRINCIPAL - App.tsx
 - limpar codigo - retirar todo o html
 - apagar const e imports

apagar o codigo no app.css

criar pasta images na pasta assets

apagar arquvio svg

apagar vite.svg na public
________________________________
index.html pagina principal
 - apagar / comentar imagem da guia
 - mudar a linguagem para pt-br
- mudar o titulo
- nova pasta no src - pages 
- criar cada pagina uma pasta 
- style.css css dentro da home
- index.tsx dentro da pasta home
- nome da class em react className
- fechar tags img e br /
- react utiliza {} chaves
- importar arquivo css - import "./style.css";
- importar imagens - import imgLogo from "../../assets/images/logo.svg";
- <img className="header_logo" src={imgLogo} alt=""/> // chamando a imagem

componente - function

main.tsx:

importar a função

index.css:
importar na main
_________________________________________________
