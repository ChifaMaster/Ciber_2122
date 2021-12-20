package com.example.proyecto_final_grupo3;

public class Proyecto {
    int id_proyecto;
    String nombre;

    public Proyecto (int id_proyecto, String nombre){
        this.id_proyecto = id_proyecto;
        this.nombre = nombre;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
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
