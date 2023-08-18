import "./style.css";


function CardServicos(props: any) {
    return (
        <>
            <div className="servico">
                <div className="topo_servico">
                    <h3>{ props.titulo}</h3>
                    <span>{props.valor}</span>
                </div>
                <p>{props.descricao}</p>
                <div className="techs">
                    {
                        props.listaTechs.map((tech: string, indice: number) => {

                            return <span key={indice}>{tech}</span>

                        })
                    }
                </div>
            </div>
        </>

    );

}

export default CardServicos;