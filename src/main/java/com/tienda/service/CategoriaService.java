
package com.tienda.service;

//una interfaz permite definir metodos que pueden implementar ciertas clases. Su nivel de acceso, su tipo de retorno, nombre, parametros que recibe

import com.tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
    // este metodo retorna una lista de clientes (todos los clientes que tenemos en BD) 
    // importar paquetes necesarios 
    public List<Categoria> getCategorias(boolean activos);
    
    // metodo save. crea y modifica. la app sabe cuando crear o cuando modificar si en propiedad id (de cliente) va un valor
    // recibe objeto tipo Categoria= aquel que vamos a guardar o modificar
    public void save(Categoria cliente);
    
    public void delete(Categoria cliente);
    
    //metodo para consultar por cliente especifico. retorna un cliente que consulta en BD. recibe objeto tipo Categoria con id del cliente a consultar
    public Categoria getCategoria(Categoria cliente);
    
}
