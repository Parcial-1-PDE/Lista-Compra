package com.myproyect.lista_compra;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.myproyect.lista_compra.Product.Product;
import com.myproyect.lista_compra.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etProductName, etProductQuantity, etProductPrice;
    private Button btnAddProduct;
    private TextView tvTotalProducts, tvTotalPrice;
    private ListView lvProducts;

    private ArrayList<Product> productList;
    private ArrayAdapter<String> productAdapter;
    private ArrayList<String> productNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar componentes
        etProductName = findViewById(R.id.etProductName);
        etProductQuantity = findViewById(R.id.etProductQuantity);
        etProductPrice = findViewById(R.id.etProductPrice);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        tvTotalProducts = findViewById(R.id.tvTotalProducts);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        lvProducts = findViewById(R.id.lvProducts);

        productList = new ArrayList<>();
        productNames = new ArrayList<>();
        productAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productNames);
        lvProducts.setAdapter(productAdapter);

        // Registrar el menú contextual para la lista de productos
        registerForContextMenu(lvProducts);

        // Acción al botón de añadir producto
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });
    }



    private void addProduct() {
        // Obtener valores de los campos de texto
        String name = etProductName.getText().toString();
        String quantityText = etProductQuantity.getText().toString();
        String priceText = etProductPrice.getText().toString();

        // Validar que el nombre del producto no esté vacío
        if (name.isEmpty()) {
            etProductName.setError("El nombre es obligatorio");
            return;
        }

        // Convertir cantidad y precio a valores numéricos
        int quantity = quantityText.isEmpty() ? 1 : Integer.parseInt(quantityText);
        double price = priceText.isEmpty() ? 0 : Double.parseDouble(priceText);

        // Crear y añadir el producto a la lista
        Product product = new Product(name, quantity, price);
        productList.add(product);
        String priceDisplay = price > 0 ? String.format("%.2f €", price) : "Sin precio";
        productNames.add(name + " - " + quantity + " x " + priceDisplay);
        productAdapter.notifyDataSetChanged();

        // Limpiar campos de texto
        etProductName.setText("");
        etProductQuantity.setText("");
        etProductPrice.setText("");

        // Actualizar el número de productos y el precio total
        updateTotals();
    }


    private void updateTotals() {
        // Actualizar el número total de productos
        tvTotalProducts.setText("Total de productos: " + productList.size());

        // Calcular el precio total solo para productos con precio especificado
        double totalPrice = 0;
        for (Product product : productList) {
            if (product.hasPrice()) {
                totalPrice += product.getPrice() * product.getQuantity();
            }
        }
        tvTotalPrice.setText("Precio total: " + String.format("%.2f €", totalPrice));
    }


    // Crear el menú contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);
    }

    // Manejar la opción seleccionada del menú contextual
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        if (item.getItemId() == R.id.menu_delete) {
            // Eliminar el producto de la lista
            productList.remove(position);
            productNames.remove(position);
            productAdapter.notifyDataSetChanged();
            updateTotals();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
