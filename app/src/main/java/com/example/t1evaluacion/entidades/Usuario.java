package com.example.t1evaluacion.entidades;

public class Usuario {

    private Integer id;
    private Integer dni;
    private String nombre;
    private String telefono;
    private String email;
    private String password;

    public Usuario(Integer id, Integer dni, String nombre, String telefono, String email, String password) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public Usuario() {

    }


    public Usuario(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }







    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
