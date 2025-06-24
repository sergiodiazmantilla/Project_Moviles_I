package com.example.t1evaluacion.view;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.t1evaluacion.ConexionSQLiteHelper;
import com.example.t1evaluacion.LoginActivity;
import com.example.t1evaluacion.R;
import com.example.t1evaluacion.utilidades.Utilidades;

public class CreateAccountActivity extends AppCompatActivity {

    EditText campoDni, campoNombre, campoTelefono, campoEmail, campoPassword, campoConfirmPassword;
    Button botonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_createaccount);

        campoDni=(EditText) findViewById(R.id.dni);
        campoNombre=(EditText) findViewById(R.id.username);
        campoTelefono=(EditText) findViewById(R.id.telefono);
        campoEmail=(EditText) findViewById(R.id.email);
        campoPassword=(EditText) findViewById(R.id.password);
        campoConfirmPassword = findViewById(R.id.confirPassword);
        botonRegistrar = findViewById(R.id.loginUs);


        showToolbar(getResources().getString(R.string.toolbar_title_createAccount), true);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botonRegistrar.setOnClickListener(v -> {
            String password = campoPassword.getText().toString();
            String confirmPassword = campoConfirmPassword.getText().toString();

            if (password.equals(confirmPassword)) {
                registrarUsuariosSql();
            } else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onClick(View view){
        registrarUsuariosSql();
    }

    private void registrarUsuariosSql() {
        ConexionSQLiteHelper conn=
                new ConexionSQLiteHelper(this, "db_usuarios", null, 1);
        SQLiteDatabase db= conn.getReadableDatabase();

        //insert into usuario (dni, nombre, telefono) values (10101010, 'Alonso', 95959595)
        String insert = "INSERT INTO " + Utilidades.TABLA_USUARIO +
                " ( " + Utilidades.CAMPO_DNI + " , " + Utilidades.CAMPO_NOMBRE +
                " , " + Utilidades.CAMPO_TELEFONO + " , " + Utilidades.CAMPO_EMAIL +
                " , " + Utilidades.CAMPO_PASSWORD + " ) " + " VALUES ( " +
                campoDni.getText().toString() + " , '" + campoNombre.getText().toString()
                + "' , '" + campoTelefono.getText().toString() + "' , '" + campoEmail.getText().toString()
                + "' , '" + campoPassword.getText().toString() + "' )";
        db.execSQL(insert);

        db.close();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}