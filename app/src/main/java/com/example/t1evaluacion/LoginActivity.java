package com.example.t1evaluacion;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.t1evaluacion.entidades.Usuario;
import com.example.t1evaluacion.utilidades.Utilidades;
import com.example.t1evaluacion.view.ContainerActivity;
import com.example.t1evaluacion.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText emailField, passwordField;
    private Button botonLogin;
    private ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        conn = new ConexionSQLiteHelper(this);

        // Inicializamos las vistas
        emailField = findViewById(R.id.email);
        passwordField = findViewById(R.id.password);
        botonLogin = findViewById(R.id.login);

        // Configuramos el botón de login
        botonLogin.setOnClickListener(v -> {
            String email = emailField.getText().toString().trim();
            String password = passwordField.getText().toString().trim();

            // Validar que no estén vacíos
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validar las credenciales
            validarCredenciales(email, password);
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.createHere) {
            Intent miIntent = new Intent(LoginActivity.this, CreateAccountActivity.class);
            startActivity(miIntent);
        }
    }

    private void validarCredenciales(String email, String password) {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {email};
        String[] campos = {Utilidades.CAMPO_EMAIL, Utilidades.CAMPO_PASSWORD};

        try {
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_EMAIL + "=?", parametros, null, null, null);

            if (cursor.moveToFirst()) {
                String passwordDB = cursor.getString(1); // Obtiene la contraseña de la base de datos

                if (passwordDB.equals(password)) { // Verifica la contraseña
                    Intent intent = new Intent(this, ContainerActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_LONG).show();
            }

            cursor.close();
        } catch (Exception e) {
            Toast.makeText(this, "Error al consultar: " + e.getMessage(), Toast.LENGTH_LONG).show();
        } finally {
            db.close();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "La Actividad ha Comenzado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "La Actividad ha sido Pausada");
    }
}
