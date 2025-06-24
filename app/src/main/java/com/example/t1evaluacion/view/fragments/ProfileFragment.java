package com.example.t1evaluacion.view.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t1evaluacion.R;
import com.example.t1evaluacion.ConexionSQLiteHelper; // Asegúrate de que este es el paquete correcto para tu clase DatabaseHelper
import com.example.t1evaluacion.entidades.Usuario; // Asegúrate de que este es el paquete correcto para tu clase User

public class ProfileFragment extends Fragment {

    private TextView nombreTextView, emailTextView, telefonoTextView, dniTextView;

    // Claves para los argumentos
    private static final String ARG_NOMBRE = "nombre";
    private static final String ARG_EMAIL = "email";
    private static final String ARG_TELEFONO = "telefono";
    private static final String ARG_DNI = "dni";

    public ProfileFragment() {
        // Constructor vacío requerido
    }

    // Método de fábrica para crear una nueva instancia del fragmento con los datos del usuario
    public static ProfileFragment newInstance(String nombre, String email, String telefono, String dni) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NOMBRE, nombre);
        args.putString(ARG_EMAIL, email);
        args.putString(ARG_TELEFONO, telefono);
        args.putString(ARG_DNI, dni);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.perfil, container, false);

        // Inicializar los TextView
        nombreTextView = view.findViewById(R.id.nombre);
        emailTextView = view.findViewById(R.id.email);
        telefonoTextView = view.findViewById(R.id.telefono);
        dniTextView = view.findViewById(R.id.dni);

        // Verificar y asignar los argumentos si están presentes
        if (getArguments() != null) {
            String nombre = getArguments().getString(ARG_NOMBRE);
            String email = getArguments().getString(ARG_EMAIL);
            String telefono = getArguments().getString(ARG_TELEFONO);
            String dni = getArguments().getString(ARG_DNI);

            // Establecer los textos
            nombreTextView.setText(nombre);
            emailTextView.setText(email);
            telefonoTextView.setText(telefono);
            dniTextView.setText(dni);
        }

        return view;
    }
}
