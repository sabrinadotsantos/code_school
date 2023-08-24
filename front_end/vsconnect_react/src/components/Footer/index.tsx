import "./style.css"

import imgLogo from "../../assets/images/logo.svg";
import imgFacebook from "../../assets/images/facebook.svg";
import imgInsta from "../../assets/images/instagram.svg";
import imgIn from "../../assets/images/linkedin.svg";
import imgDev from "../../assets/images/dev.png";

import {Link, useLocation} from "react-router-dom"





function Footer() {

     const location = useLocation();

    
    return (
        <footer className={location.pathname == "/" ? "footer_background_image" : "footer_background_color"}> 
            <div className="container rodape">
                {
                    location.pathname == "/" ? <div className="span_dicas">
                    <img src={imgDev} alt="" />
                    <div className="span_dicas_texto">
                        <p>Temos algumas dicas para o seu serviço ou freela ser um sucesso, acesse nossa página de
                            recomendações para saber mais.</p>
                        <Link className="botao botao_dicas" to={"#"}>mais dicas</Link>
                    </div>
                </div> : ""
                }
                <div className="rodape_conteudo">
                    <div className="rodape_conteudo_paginas">
                        <h2>Páginas</h2>
                        <ul>

                        <Link className="link" to ={"#"}> <li>Login</li></Link>
                        <Link className="link"  to ="/"> <li>Home</li></Link>
                        <Link className="link" to ="lista-servicos"> <li>Listar Serviços</li></Link>
                        <Link className="link" to ="lista-devs"> <li>Listar Desenvolvedores</li></Link>
                        <Link className="link"  to ={"#"}> <li>Cadastrar Cliente</li></Link>
                        <Link className="link" to ="cadastro-usuario"> <li>Cadastrar Desenvolvedor</li></Link>
                        <Link className="link" to ="cadastro-servico"> <li>Cadastrar Servicos</li></Link>
                        </ul>
                    </div>
                    <img src={imgLogo} alt="" />
                    <div className="rodape_conteudo_contatos">
                        <h2>Contatos</h2>
                        <div>
                            <Link to ={"#"}><img src={imgFacebook} alt="" /></Link>
                            <Link to ={"#"}><img src={imgInsta} alt="" /></Link>
                            <Link to ={"#"}><img src={imgIn} alt="" /></Link>

                        </div>
                        <Link to ={"mailto:"}>contato@vsconnect.com</Link>
                    </div>
                </div>
                <p>todos os direitos reservados ©.</p>
            </div>
        </footer>

    );

}

// o componente home pode ser chamado em outros arquivos
export default Footer;