package com.example.t1evaluacion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.t1evaluacion.entidades.Usuario;
import com.example.t1evaluacion.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public ConexionSQLiteHelper(LoginActivity context) {
        super(context, "db_usuarios", null, 1);
    }

    //public static Usuario obtenerUsuarioPorEmail(String email) {    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }


    // Método para obtener un usuario por email
    public Usuario obtenerUsuarioPorEmail(String email) {
        Usuario usuario = null;
        SQLiteDatabase db = null;
        Cursor cursor = null;

        try {
            db = this.getReadableDatabase();
            String query = "SELECT id, email, password FROM usuarios WHERE email = ?";
            cursor = db.rawQuery(query, new String[]{email});

            if (cursor != null && cursor.moveToFirst()) { // Verifica si hay resultados
                //int id = cursor.getInt(0); // Obtener el id
                String emailDB = cursor.getString(0); // Obtener el email
                String passwordDB = cursor.getString(1); // Obtener la contraseña
                usuario = new Usuario( emailDB, passwordDB); // Crear el objeto Usuario
            }
        } catch (Exception e) {
            Log.e("DB_ERROR", "Error al obtener usuario por email", e);
        } finally {
            if (cursor != null) cursor.close();
            if (db != null) db.close();
        }

        return usuario; // Retorna el usuario o null si no se encontró
    }



}
