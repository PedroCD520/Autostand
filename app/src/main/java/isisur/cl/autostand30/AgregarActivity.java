package isisur.cl.autostand30;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AgregarActivity extends AppCompatActivity {

    private EditText etNombre, etDescripcion, etTipo, etAnio;
    private Button btnGuardar;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        // Inicializar Firebase Firestore
        db = FirebaseFirestore.getInstance();

        // Referenciar los EditText y Button del layout
        etNombre = findViewById(R.id.et_nombre);
        etDescripcion = findViewById(R.id.et_descripcion);
        etTipo = findViewById(R.id.et_tipo);
        etAnio = findViewById(R.id.et_anio);
        btnGuardar = findViewById(R.id.btn_guardar);

        // Configurar el click listener para el botón Guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarPieza();
            }
        });
    }

    private void guardarPieza() {
        // Obtener los valores ingresados por el usuario
        String nombre = etNombre.getText().toString().trim();
        String descripcion = etDescripcion.getText().toString().trim();
        String tipo = etTipo.getText().toString().trim();
        int anio = Integer.parseInt(etAnio.getText().toString().trim()); // Convertir a entero

        // Crear un mapa con los datos a guardar en Firestore
        Map<String, Object> pieza = new HashMap<>();
        pieza.put("nombre", nombre);
        pieza.put("descripcion", descripcion);
        pieza.put("tipo", tipo);
        pieza.put("anio", anio);

        // Agregar el documento a la colección "piezas" en Firestore
        db.collection("piezas")
                .add(pieza)
                .addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        // Limpiar los EditText después de guardar
                        etNombre.setText("");
                        etDescripcion.setText("");
                        etTipo.setText("");
                        etAnio.setText("");

                        // Mostrar un mensaje de éxito
                        Toast.makeText(AgregarActivity.this, "Pieza guardada correctamente", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Manejar errores en caso de fallo al guardar
                        Toast.makeText(AgregarActivity.this, "Error al guardar la pieza: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
