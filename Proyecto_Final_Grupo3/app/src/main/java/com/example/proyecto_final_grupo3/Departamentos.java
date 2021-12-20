package com.example.proyecto_final_grupo3;

public class Departamentos {
    int id_departamento;
    String nombre;

    public  Departamentos(int id_departamento, String nombre) {
        this.id_departamento = id_departamento;
        this.nombre = nombre;
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

    public String toString(){
        return nombre;
    }
}
