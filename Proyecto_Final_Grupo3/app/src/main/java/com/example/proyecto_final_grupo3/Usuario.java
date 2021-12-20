package com.example.proyecto_final_grupo3;

import java.util.Date;

public class Usuario {
    int id_usuario;
    int id_departamento;
    String nombre;
    String apellidos;
    String usuario;
    String DNI;
    int password;
    boolean permisos;
    Date ultima_conexion;
    String email;


    public Usuario(){
        this.id_usuario = id_usuario;
        //this.id_departamento = id_departamento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.DNI = DNI;
        //this.password = password;
        //this.permisos = permisos;
        this.ultima_conexion = ultima_conexion;
        this.email = email;
    }

    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean isPermisos() {
        return permisos;
    }

    public void setPermisos(boolean permisos) {
        this.permisos = permisos;
    }

    public Date getUltima_conexion() {
        return ultima_conexion;
    }

    public void setUltima_conexion(Date ultima_conexion) {
        this.ultima_conexion = ultima_conexion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String toString(){
        return usuario;
    }
}
