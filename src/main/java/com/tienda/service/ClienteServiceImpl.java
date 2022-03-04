
package com.tienda.service;

//esta clase es para la implementacion del cliente
// agregar ''implements ClienteService'' y agregar todos los metodos abstractos
import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; //agregar este con @Transactional


@Service
public class ClienteServiceImpl implements ClienteService{
    
    
    //implementar clienteDao
    @Autowired
    private ClienteDao clienteDao;

    
    //findAll devuelve un objeto iterable. Hay que agregar un cast para convertir el objeto tipo iterable a lista de Cliente
    @Override
    @Transactional (readOnly=true) //esto se agrega para que cuando vaya a base de datos haga solo lectura, nada de escritura
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();
    }

    //Transaccion en BD. Tienen que tener commits. Si hay un error hace rollback (devuelva todo lo que hice, cancelelo)
    
    @Override
    @Transactional //no se le pone nada xq asi permite escribir y leer
    public void save(Cliente cliente) {
        //ya recibimos el cliente, se lo pasa al Dao y se encarga de ir a insertar o guardar
        clienteDao.save(cliente);
    }

    @Override
    @Transactional // eliminar es como escribir 
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional (readOnly=true)
    public Cliente getCliente(Cliente cliente) {
        
                                         //si la busqueda no encuentra un objeto cliente retorna null
        return clienteDao.findById(cliente.getIdcliente()).orElse(null);
    }
    
}
