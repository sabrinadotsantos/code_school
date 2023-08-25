//estilização
import "./style.css";

//hooks
import {useState, useEffect} from "react";

//axios
import api from "../../utils/api";

import { useNavigate } from "react-router-dom";

//localStorage
import secureLocalStorage from "react-secure-storage";



function Login() {

    //variavel que utiliza a função useNavigate para navegar entre os componentes;
    const navigate = useNavigate();

    const [email, setEmail] = useState<string>("");
    const [senha, setSenha] = useState<string>("");

    function realizarAutenticação(event: any) {
        event.preventDefault();

        const usuario = {
            email: email,
            password: senha
        };

        api.post("login", usuario)
            .then((response: any) => {
                console.log(response.data);
                secureLocalStorage.setItem("user", response.data); //adicionando resposta ao localstorage / salvando detro da chave user

                //redirecionar ao componente perfil
                navigate("/perfil/" + response.data.user.id) //redireciona o perfil de acordo com o id
                navigate(0); //recarregando e mudando o valor / entender que esta logado

                // alert("Login realizado com sucesso!")
                
            }).catch((error:any) =>{
                console.log(error);
                alert("Erro ao realizar o login!")
            })
        
    }



    return (
        <main id="main_login">
            <div className="container container_login">
                <div className="login_conteudo">
                    <h1>Login</h1>
                    <hr />
                    <form className="login_formulario" method="POST" onSubmit={realizarAutenticação}>
                        <div className="login_box_input">
                            <label htmlFor="email">E-mail:</label>
                            <input
                                type="email"
                                id="email"
                                placeholder="Digite aqui seu e-mail:"
                                required
                                onChange={(e) => setEmail(e.target.value) } //pegando valores digitados pelo usuario
                            />
                        </div>
                        <div className="login_box_input">
                            <label htmlFor="senha">Senha:</label>
                            <input
                                type="password"
                                id="senha"
                                placeholder="Digite aqui sua senha:"
                                required
                                onChange={(e) => setSenha(e.target.value) }
                            />
                        </div>
                        <button className="login_botao" type="submit">Logar</button>
                    </form>
                </div>
            </div>
        </main>

    );
}

export default Login;