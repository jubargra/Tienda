
package com.tienda.controller;

// import com.tienda.dao.ClienteDao; import eliminado en clase 5
import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//en este controlador se decide que modelo recibe, que acciones hace y que vista retornar

@Controller
@Slf4j //anotaciones 
public class IndexController {
    
    @Autowired
    //clase4
    //private ClienteDao clienteDao;
    
    //Cambio en clase5 para acceder a la interfaz
    private ClienteService clienteService;
  
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
        
        //modificado en clase5 para usar ClienteService (sigue en 52)
        //agregando CRUDrepository y conectando con MySQL
        //var clientesDB = clienteDao.findAll(); //se esta creando una instancia del clienteDao usando el repositoryCRUD
        //model.addAttribute("clientesDB", clientesDB); //agregamos al modelo los clienteDB y se agregan en el html
        
        
        //Clase 5. Se cambia la forma en que se llaman los clientes. Ya no se llaman desde controlador en capa de presentacion
        // sino que ahora se llama desde la capa de negocio mediante la implementacion de ClienteService
        
        var clientesDB = clienteService.getClientes();
        model.addAttribute("clientesDB", clientesDB);
        
        return "index"; //devuelve la pagina que le pongamos aca
    }
    
@GetMapping("/nuevoCliente")
public String nuevoCliente(Cliente cliente){
    return "modificarCliente";
}
@PostMapping("/nuevoCliente")
public String guardarCliente(Cliente cliente){
    clienteService.save(cliente);
    return "redirect:/";
}

@GetMapping("/modificarCliente/{idcliente}")
public String modificarCliente(Cliente cliente, Model model){
    Cliente respuesta= clienteService.getCliente(cliente);
    model.addAttribute("cliente",respuesta);
    return "modificarCliente";
}

@GetMapping("/eliminarCliente/{idcliente}")
public String eliminarCliente(Cliente cliente){
    clienteService.delete(cliente);
    return "modificarCliente";
}



}
