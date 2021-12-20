package com.example.proyecto_final_grupo3;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "grupotres.db";

    //tablas
    String consulta1 = "CREATE TABLE departamento(id_departamento INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT )";
    String consulta2 = "CREATE TABLE usuario(id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, id_departamento INTEGER,DNI TEXT, nombre TEXT ,  apellidos TEXT , usuario TEXT , password TEXT, permisos boolean, ultima_conexion DATE, email TEXT,  FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento))";
    String consulta3 = "CREATE TABLE proyecto(id_proyecto INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT )";
    String consulta4 = "CREATE TABLE usuario_proyecto(id_proyecto INTEGER,id_usuario INTEGER, FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto), FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario))";
    String consulta5 = "CREATE TABLE fichaje(id_fichaje INTEGER PRIMARY KEY AUTOINCREMENT, id_usuario INTEGER, id_proyecto INTEGER,  hora_entrada TIME, hora_salida TIME, fecha DATE, horas_metidas int, FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario), FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto))";
    String consulta6 = "CREATE TABLE gestion_de_gastos(id_gastos INTEGER PRIMARY KEY AUTOINCREMENT, id_usuario INTEGER, id_proyecto INTEGER, id_departamento INTEGER, fecha_gasto DATE , transporte TEXT, distancia_recorrida TEXT, peaje TEXT, parking TEXT, precioTotal INT, pais TEXT, ciudad TEXT, fecha_ini DATE, fecha_fin DATE, dias_fuera INT, FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario), FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto), FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento))";
    String consulta7 = "CREATE TABLE usuario_gastos(id_usuario INTEGER,id_gastos INTEGER, FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario), FOREIGN KEY (id_gastos) REFERENCES gestion_de_gastos(id_gastos))";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(consulta1);
        db.execSQL(consulta2);
        db.execSQL(consulta3);
        db.execSQL(consulta4);
        db.execSQL(consulta5);
        db.execSQL(consulta6);
        db.execSQL(consulta7);
        //this.getWritableDatabase();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS departamento");
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS proyecto");
        db.execSQL("DROP TABLE IF EXISTS usuario_proyecto");
        db.execSQL("DROP TABLE IF EXISTS fichaje");
        db.execSQL("DROP TABLE IF EXISTS gestion_de_gastos");
        db.execSQL("DROP TABLE IF EXISTS usuario_gastos");

        onCreate(db);

    }


    public long checkUser(String user, int password) {
        long rv = -1;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor csr = db.query(
                "usuario", new String[]{"id_usuario","usuario","password"},
                "usuario" + "=? AND " + "password" + "=?",
                new String[]{user, String.valueOf(password)},
                null,null,null);
        if (csr.moveToFirst()) {
            rv = csr.getColumnIndex("id_usuario");
        }
        csr.close();
        return rv;
    }

    public String getNombre() throws SQLException {
        String nombre = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("usuario", new String[]{"nombre"},
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                nombre = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        //cursor.close();
        return nombre;
    }

    public String getApellidos() throws SQLException {
        String apellidos = "";
        Cursor cursor11 = this.getReadableDatabase().query("usuario", new String[]{"apellidos"},
                null, null, null, null, null);
        if (cursor11.moveToFirst()) {
            do {
                apellidos = cursor11.getString(0);
            } while (cursor11.moveToNext());
        }
        //cursor11.close();

        return apellidos;
    }

    public String getDNI() throws SQLException {
        String dni = "";
        Cursor cursor2 = this.getReadableDatabase().query("usuario", new String[]{"DNI"},
                null, null, null, null, null);
        if (cursor2.moveToFirst()) {
            do {
                dni = cursor2.getString(0);
            } while (cursor2.moveToNext());
        }
        //cursor2.close();

        return dni;
    }

    public String getUser() throws SQLException {

        String user = "";
        Cursor cursor3 = this.getReadableDatabase().query("usuario", new String[]{"usuario"},
                null, null, null, null, null);
        if (cursor3.moveToFirst()) {
            do {
                user = cursor3.getString(0);
            } while (cursor3.moveToNext());
        }
        //cursor3.close();

        return user;

    }

    public String getDate() throws SQLException {
        String date = "";
        Cursor cursor4 = this.getReadableDatabase().query("usuario", new String[]{"ultima_conexion"},
                null, null, null, null, null);
        if (cursor4.moveToFirst()) {
            do {
                date = cursor4.getString(0);
            } while (cursor4.moveToNext());
        }
        //cursor4.close();

        return date;
    }

    /*public Usuario getUser(int id_usuario) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("usuario", new String[] { "usuario" }," id = ?",new String[]{String.valueOf(id_usuario)},null,null,null,null);


        if (cursor != null)
            cursor.moveToFirst();

        Usuario user = new Usuario();
        user.setId_usuario(Integer.parseInt(cursor.getString(0)));
        user.setNombre(cursor.getString(1));

        return user;
    }*/
    /*public List<Departamentos> getDepartamentos() {
        List<Departamentos> retData = new ArrayList<Departamentos>();
        //SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("departamentos", new String[]{"id_departamento","nombre"}, null,null,null,null,null);
        //Cursor cursor = db.rawQuery("select nombre from departamento",null);
        if (cursor.moveToFirst()) {
            do {
                retData.add(new Departamentos(cursor.getString(1)));
            } while (cursor.moveToNext());
        }


        return retData;
    }*/


    /*public ArrayList<String> getDepartamentos() {
        ArrayList<String> retData = new ArrayList<String>();
        //SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("departamento", new String[]{"id_departamento","nombre"}, null,null,null,null,null);
        //Cursor cursor = db.rawQuery("select nombre from departamento",null);

        if (cursor.moveToFirst()) {
            do {
                retData.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        return retData;
    }*/


    public List<String> getProyectos() {
        List<String> retData = new ArrayList<String>();
        //SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("proyecto", new String[]{"nombre"}, null, null, null, null, null);
        //Cursor cursor = db.rawQuery("select nombre from departamento",null);
        if (cursor.moveToFirst()) {
            do {
                retData.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }


        return retData;
    }


    public ArrayList<Departamentos> getDepartamentos() {
        ArrayList<Departamentos> departamentosList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + "departamento";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                departamentosList.add(new Departamentos(cursor.getInt(0), cursor.getString(1)));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        //db.close();

        // returning lables
        return departamentosList;
    }

    public ArrayList<Proyecto> getProyecto_2() {
        ArrayList<Proyecto> proyectoList = new ArrayList<>();

        //SQLiteDatabase db = this.getWritableDatabase();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + "proyecto";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                proyectoList.add(new Proyecto(cursor.getInt(0), cursor.getString(1)));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        //db.close();

        // returning lables
        return proyectoList;
    }

    public Cursor getData(String usuario, int password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.query("usuario",
                new String[]{"usuario","password"},
                "usuario =? and password =?",
                new String[]{usuario, String.valueOf(password)},
                null, null, null);
        return res;
    }



    public String getUsername() throws SQLException {
        //Usuario user = new Usuario();
        String username = "";
        Cursor cursor = this.getReadableDatabase().query(
                "usuario", new String[]{"id_usuario","usuario"},
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                username = cursor.getString(0);
                //user.setId_usuario(Integer.parseInt(cursor.getString(0)));
                //user.setUsuario(cursor.getString(1));

            } while (cursor.moveToNext());
        }


        return username;
    }


    /*public String getData_usuarioactivo(int id_usuario, int id_departamento, String nombre, String apellidos, String usuario, int password, boolean permisos, Date ultima_conexion, String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select id_usuario,id_departamento,nombre,apellidos,usuario,password,permisos,ultima_conexion,email from usuario where usuario='" + usuario + "'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            Usuario response = new Usuario(id_usuario, nombre, usuario, email, DNI, amount, password);
            response.email = res.getString(res.getColumnIndex(Table_Column_2_Email));
            response.name = res.getString(res.getColumnIndex(Table_Column_1_Name));
            response.username = res.getString(res.getColumnIndex(Table_Column_1_Username));
            response.age = res.getString(res.getColumnIndex(Table_Column_3_Age));
            response.amount = res.getString(res.getColumnIndex(Table_Column_3_Amount));
        }
        return response;
    }*/

    public boolean checkUserExist(String username, int password){
        String[] columns = {"usuario"};
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = "usuario=? and password = ?";
        String[] selectionArgs = {username, String.valueOf(password)};

        Cursor cursor = db.query("usuario", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }

    public Usuario getAllInfoUser(int id_usuario, String nombre, String apellidos, String usuario, String DNI, Date ultima_conexion,String email){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select id_usuario,usuario,nombre,apellidos,ultima_conexion,email,DNI from usuario where id _usuario="+id_usuario;
        Cursor cursor_user_info = db.rawQuery(sql,null);
        Usuario user = new Usuario();
        if (cursor_user_info.moveToFirst()){
            user.setId_usuario(Integer.parseInt(cursor_user_info.getString(0)));
            user.setUsuario(cursor_user_info.getString(1));
            user.setNombre(cursor_user_info.getString(2));
            user.setApellidos(cursor_user_info.getString(3));
            user.setEmail(cursor_user_info.getString(5));
            user.setDNI(cursor_user_info.getString(7));
            //user.setUltima_conexion(cursor_user_info.getColumnIndex("ultima_conexion"));
        }
        return user;
    }

    public Usuario checkUserValid(String usuario,int password){
        Usuario users =null;
        try {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT id_usuario,usuario,nombre,apellidos,email,ultima_conexion,DNI FROM " + "usuario" + " WHERE userName = ? AND userPassword = ?" ,new String[]{usuario, String.valueOf(password)} );
            if (cursor.moveToFirst()){
                users = new Usuario();
                users.setId_usuario(cursor.getInt(0));
                users.setUsuario(cursor.getString(1));
                users.setNombre(cursor.getString(2));
                users.setApellidos(cursor.getString(3));
                users.setEmail(cursor.getString(4));
                users.setDNI(cursor.getString(6));
            }
        }catch (Exception e){
            users=null;
        }
        return users;

    }













}














