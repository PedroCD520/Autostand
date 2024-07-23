package isisur.cl.autostand30;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvNombreProducto; // Agregar TextView para mostrar el nombre

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Aplicar padding para las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar clic del botón Agregar
        Button btnAgregar = findViewById(R.id.btn_agregar);
        btnAgregar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AgregarActivity.class);
            startActivity(intent);
        });

        // Configurar clic del botón Modificar
        Button btnModificar = findViewById(R.id.btn_modificar);
        btnModificar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProductosActivity.class);
            startActivity(intent);
        });

        // Referenciar TextView para mostrar el nombre del producto
        tvNombreProducto = findViewById(R.id.tv_nombre);
    }

    // Método para actualizar el nombre del producto mostrado en MainActivity
    public void actualizarNombreProducto(String nombreProducto) {
        tvNombreProducto.setText(nombreProducto);
    }

}
