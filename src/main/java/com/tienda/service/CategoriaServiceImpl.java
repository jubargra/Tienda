
package com.tienda.service;

//esta clase es para la implementacion del cliente
// agregar ''implements CategoriaService'' y agregar todos los metodos abstractos
import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; //agregar este con @Transactional


@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    
    //implementar clienteDao
    @Autowired
    private CategoriaDao clienteDao;

    
    //findAll devuelve un objeto iterable. Hay que agregar un cast para convertir el objeto tipo iterable a lista de Categoria
    @Override
    @Transactional (readOnly=true) //esto se agrega para que cuando vaya a base de datos haga solo lectura, nada de escritura
    public List<Categoria> getCategorias(boolean activos) {
        var lista=(List<Categoria>)clienteDao.findAll();
        if(activos){lista.removeIf(e->e.isActiva());} //devuelve lista de categorias activas si parametro es true, si false devuelve toda la lista
        return lista;
    }

    //Transaccion en BD. Tienen que tener commits. Si hay un error hace rollback (devuelva todo lo que hice, cancelelo)
    
    @Override
    @Transactional //no se le pone nada xq asi permite escribir y leer
    public void save(Categoria cliente) {
        //ya recibimos el cliente, se lo pasa al Dao y se encarga de ir a insertar o guardar
        clienteDao.save(cliente);
    }

    @Override
    @Transactional // eliminar es como escribir 
    public void delete(Categoria cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional (readOnly=true)
    public Categoria getCategoria(Categoria cliente) {        
         //si la busqueda no encuentra un objeto cliente retorna null
        return clienteDao.findById(cliente.getIdCategoria()).orElse(null);
    }
}
