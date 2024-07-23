package isisur.cl.autostand30.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



import isisur.cl.autostand30.R;
import isisur.cl.autostand30.modelo.Producto;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder> {

    private List<Producto> productos;

    public ProductosAdapter(List<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.piezas_view, parent, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.tvNombrePieza.setText(producto.getNombre());
        holder.tvDescripcionPieza.setText(producto.getDescripcion());
        holder.tvTipoPieza.setText(producto.getTipo());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    static class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombrePieza, tvDescripcionPieza, tvTipoPieza;

        ProductoViewHolder(View itemView) {
            super(itemView);
            tvNombrePieza = itemView.findViewById(R.id.tv_nombre);
            tvDescripcionPieza = itemView.findViewById(R.id.tv_descripcion_pieza);
            tvTipoPieza = itemView.findViewById(R.id.tv_tipo_pieza);
        }
    }
}
