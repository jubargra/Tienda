
package com.tienda.service;

//esta clase es para la implementacion del cliente
// agregar ''implements ArticuloService'' y agregar todos los metodos abstractos
import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; //agregar este con @Transactional


@Service
public class ArticuloServiceImpl implements ArticuloService{
    
    
    //implementar clienteDao
    @Autowired
    private ArticuloDao clienteDao;

    
    //findAll devuelve un objeto iterable. Hay que agregar un cast para convertir el objeto tipo iterable a lista de Articulo
    @Transactional (readOnly=true) //esto se agrega para que cuando vaya a base de datos haga solo lectura, nada de escritura
    public List<Articulo> getArticulos() {
        return (List<Articulo>)clienteDao.findAll();
    }

    //Transaccion en BD. Tienen que tener commits. Si hay un error hace rollback (devuelva todo lo que hice, cancelelo)
    
    @Override
    @Transactional //no se le pone nada xq asi permite escribir y leer
    public void save(Articulo cliente) {
        //ya recibimos el cliente, se lo pasa al Dao y se encarga de ir a insertar o guardar
        clienteDao.save(cliente);
    }

    @Override
    @Transactional // eliminar es como escribir 
    public void delete(Articulo cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional (readOnly=true)
    public Articulo getArticulo(Articulo cliente) {        
         //si la busqueda no encuentra un objeto cliente retorna null
        return clienteDao.findById(cliente.getIdArticulo()).orElse(null);
    }

    @Override
    public List<Articulo> getArticulos(boolean activos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
