
package com.tienda.dao;

import org.springframework.data.repository.CrudRepository;
import com.tienda.domain.Cliente;



//lo primero es cambiar la clase por una interface

//  espacios entre "< >" = el nombre de la entidad con la que vamos a relacionar/el tipo de dato de la identidad
public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
}
