
package com.tienda.service;

//una interfaz permite definir metodos que pueden implementar ciertas clases. Su nivel de acceso, su tipo de retorno, nombre, parametros que recibe

import com.tienda.domain.Cliente;
import java.util.List;


public interface ClienteService {
    
    // este metodo retorna una lista de clientes (todos los clientes que tenemos en BD) 
    // importar paquetes necesarios 
    public List<Cliente> getClientes();
    
    // metodo save. crea y modifica. la app sabe cuando crear o cuando modificar si en propiedad id (de cliente) va un valor
    // recibe objeto tipo Cliente= aquel que vamos a guardar o modificar
    public void save(Cliente cliente);
    
    public void delete(Cliente cliente);
    
    //metodo para consultar por cliente especifico. retorna un cliente que consulta en BD. recibe objeto tipo Cliente con id del cliente a consultar
    public Cliente getCliente(Cliente cliente);
    
}
