package isisur.cl.autostand30;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;



import isisur.cl.autostand30.adapter.ProductosAdapter;
import isisur.cl.autostand30.modelo.Producto;

public class ProductosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductosAdapter adapter;
    private List<Producto> productoList;
    private FirebaseFirestore db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        recyclerView = findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productoList = new ArrayList<>();
        adapter = new ProductosAdapter(productoList);
        recyclerView.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();

        // Obtener datos de Firestore
        db.collection("piezas")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            return;
                        }

                        productoList.clear();
                        for (QueryDocumentSnapshot doc : value) {
                            String nombre = doc.getString("nombre"); // Obtener solo el nombre
                            productoList.add(new Producto(nombre)); // Crear un Producto con solo el nombre
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}
