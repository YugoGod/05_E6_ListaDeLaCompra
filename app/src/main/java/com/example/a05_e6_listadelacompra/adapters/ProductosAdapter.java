package com.example.a05_e6_listadelacompra.adapters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a05_e6_listadelacompra.R;
import com.example.a05_e6_listadelacompra.modelos.Producto;

import java.util.List;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.Producto_VH> {

    // ATRIBUTOS
    private List<Producto> objects;
    private int resource;
    private Context context;

    // CONSTRUCTOR
    public ProductosAdapter(List<Producto> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public Producto_VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productoFilaView = LayoutInflater.from(context).inflate(resource, null);
        productoFilaView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new Producto_VH(productoFilaView);
    }

    @Override
    public void onBindViewHolder(@NonNull Producto_VH holder, int position) {
        Producto producto = objects.get(position);
        holder.lblNombre.setText(producto.getNombre());
        holder.txtCantidad.setText(String.valueOf(producto.getCantidad()));
        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objects.remove(producto);
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });

        holder.txtCantidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int cantidad;
                try{
                    cantidad = Integer.parseInt(editable.toString());
                }catch (NumberFormatException nfe){
                    cantidad = 0;
                }
                producto.setCantidad(cantidad);
            }
        });
    }

    /**
     * Me indica la cantidad de elementos que voy a mostrar.
     * @return
     */
    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class Producto_VH extends RecyclerView.ViewHolder {

        ImageButton btnEliminar;
        TextView lblNombre;
        EditText txtCantidad;

        public Producto_VH(@NonNull View itemView) {
            super(itemView);
            btnEliminar = itemView.findViewById(R.id.imageButton);
            lblNombre = itemView.findViewById(R.id.lblNombreProductoCard);
            txtCantidad = itemView.findViewById(R.id.lblCantidadProductoCard);

        }
    }
}
