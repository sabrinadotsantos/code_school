let menu = document.getElementById("menu_links");
let menu_barras = document.getElementById("menu_barras");


function mostrarMenu (){
    if (window.getComputedStyle(menu).display == "none") { 
        menu.style.display = "flex"
        menu_barras.setAttribute("aria-label", "fechar menu") //alterar atributo
        menu_barras.setAttribute("aria-expanded", "true")        
        
        //se a propriedade display  do elemento menu for igual a none - entao aplique o initial

        //pegue o estilo que esta computado/ elemento menu (pega o elemento do estilo do elemeento menu e olha o display se é igual a none)
        
    }else{
        menu.style.display = "none"
        menu_barras.setAttribute("aria-label", "abrir menu")
        menu_barras.setAttribute("aria-expanded", "false")
    }
    
    

}  
