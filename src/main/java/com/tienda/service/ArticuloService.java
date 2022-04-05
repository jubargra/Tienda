
package com.tienda.service;

//una interfaz permite definir metodos que pueden implementar ciertas clases. Su nivel de acceso, su tipo de retorno, nombre, parametros que recibe

import com.tienda.domain.Articulo;
import java.util.List;


public interface ArticuloService {
    
    // este metodo retorna una lista de clientes (todos los clientes que tenemos en BD) 
    // importar paquetes necesarios 
    public List<Articulo> getArticulos(boolean activos);
    
    // metodo save. crea y modifica. la app sabe cuando crear o cuando modificar si en propiedad id (de cliente) va un valor
    // recibe objeto tipo Articulo= aquel que vamos a guardar o modificar
    public void save(Articulo cliente);
    
    public void delete(Articulo cliente);
    
    //metodo para consultar por cliente especifico. retorna un cliente que consulta en BD. recibe objeto tipo Articulo con id del cliente a consultar
    public Articulo getArticulo(Articulo cliente);
    
}
