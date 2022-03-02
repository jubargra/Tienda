
package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

//en este controlador se decide que modelo recibe, que acciones hace y que vista retornar

@Controller
@Slf4j //anotaciones 
public class IndexController {
    
    @Autowired
    private ClienteDao clienteDao;
    
    @RequestMapping("/")  //de esta manera el controlador le agrega al navegador las rutas de las paginas
    public String inicio(Model model) {
        log.info("Ahora utilizando la arquitectura MVC"); //muestra un mensaje   
        
        //atributos al modelo como texto plano
        model.addAttribute("Mensaje", "Mensaje desde el controlador"); //le agregamos un atributo al modelo llamado Mensaje y su contenido
        model.addAttribute("Nombre", "Julian Barquero"); //le agregamos un atributo al modelo llamado Mensaje y su contenido
        
        //como agregar un objeto
        Cliente cliente = new Cliente("Julian", "Barquero Granados", "jubargra@gmail.com","85034220");        
        //agregamos cliente al modelo
        model.addAttribute(cliente);
        
        // como agregar una lista de objetos
        Cliente cliente2 = new Cliente("Juan", "Vargas Mora", "juanvargar@gmail.com","88551245");
        var clientes = Arrays.asList(cliente,cliente2);
        model.addAttribute("clientes", clientes);  
        
        //   clienteDao.save(new Cliente("Andres", "Barquero Granados", "jubargra@gmail.com","85034220"));
        
        
        //agregando CRUDrepository y conectando con MySQL
        var clientesDB = clienteDao.findAll(); //se esta creando una instancia del clienteDao usando el repositoryCRUD
        model.addAttribute("clientesDB", clientesDB); //agregamos al modelo los clienteDB y se agregan en el html
        
        
        
        
        return "index"; //devuelve la pagina que le pongamos aca
    }
    
}
