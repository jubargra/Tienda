
package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data  //a;adir esta anotacion para usar Data, que crea los getters y setters automatico
@Entity
@Table(name="cliente")  //anotacion de la tabla a la que hace relacion
public class Cliente implements Serializable{  //se implemente serializable
    
    private static final long serialVersionUID = 1L; //propiedad que necesita hybernate para realizar la persistencia
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //esto quiere decir que el valor generado va a tener forma de identidad
    private long idcliente; //la variable que agregamos en la tabla
    private String nombre; //los sets y gets se crean automaticamente por agregar Data
    private String apellidos;
    private String correo;
    private String telefono;
    
    //hay que crear los constructores
    // hacer uno sin nada y uno sobrecargado(con todos los atributos)

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    
    
}
