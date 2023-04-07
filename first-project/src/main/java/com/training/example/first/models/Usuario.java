package com.training.example.first.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity // entidad referencia BD
@Table(name = "usuarios") //referencia la tabla de la BD.
@ToString // genera toString de la clase
@EqualsAndHashCode // genera equals y haschode de la clase
public class Usuario {

    @Getter // lombok - genera el getter de la propiedad
    @Setter // lombok - genera el setter de la propiedad
    @Column(name = "id") // asigna la propiedad con la columna de la BD.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "nombre")
    private String nombre;

    @Getter
    @Setter
    @Column(name = "apellidos")
    private String apellido;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "telefono")
    private String telefono;

    @Getter
    @Setter
    @Column(name = "password")
    private String password;

}
