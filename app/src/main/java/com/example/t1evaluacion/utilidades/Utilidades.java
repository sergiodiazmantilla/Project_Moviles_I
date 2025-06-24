package com.example.t1evaluacion.utilidades;

public class Utilidades {

    //constantes tabla usuario
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_DNI = "dni";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CAMPO_EMAIL = "email";
    public static final String CAMPO_PASSWORD = "password";

    //Crear tabla
    public static final String CREAR_TABLA_USUARIO
            ="CREATE TABLE " + TABLA_USUARIO + " ( "+
            CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CAMPO_DNI + " INTEGER , " + CAMPO_NOMBRE + " TEXT , " +
            CAMPO_TELEFONO + " TEXT , " + CAMPO_EMAIL + " TEXT , " +
            CAMPO_PASSWORD + " TEXT ) ";
}
