package com.example.proyecto_final_grupo3;

public class Departamentos {
    int id_departamentos;
    String nombre;

    public int getId_departamentos() {
        return id_departamentos;
    }

    public void setId_departamentos(int id_departamentos) {
        this.id_departamentos = id_departamentos;
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
