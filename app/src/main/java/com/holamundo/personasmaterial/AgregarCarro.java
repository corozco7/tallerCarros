package com.holamundo.personasmaterial;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class AgregarCarro extends AppCompatActivity {
    private EditText txtPrecio, txtPlaca;
    private Spinner cmbColor, cmbMarca;
    private ArrayAdapter<String> adapterMarcas, adapterColores;
    private String mar[], col[];
    private ArrayList<Integer> fotos;
    private ImageView foto;
    private ArrayList<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);

        txtPrecio = findViewById(R.id.txtPrecio);
        txtPlaca = findViewById(R.id.txtPlaca);
        cmbColor = findViewById(R.id.cmbColor);
        cmbMarca = findViewById(R.id.cmbMarca);
        foto = findViewById(R.id.foto);

        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
        fotos.add(R.drawable.images4);
        fotos.add(R.drawable.images5);

        mar = getResources().getStringArray(R.array.marcas);
        col = getResources().getStringArray(R.array.colores);
        adapterMarcas = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,mar);
        cmbMarca.setAdapter(adapterMarcas);
        adapterColores = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,col);
        cmbColor.setAdapter(adapterColores);
    }

    public boolean validar(){
        if (txtPlaca.getText().toString().isEmpty()){
            txtPlaca.setError(getResources().getString(R.string.error_placa_uno));
            txtPlaca.requestFocus();
            return false;
        }
        if (txtPrecio.getText().toString().isEmpty()){
            txtPrecio.setError(getResources().getString(R.string.error_precio_uno));
            txtPrecio.requestFocus();
            return false;
        }
        if (Integer.parseInt(txtPrecio.getText().toString()) <= 0){
            txtPrecio.setError(getResources().getString(R.string.error_precio_dos));
            txtPrecio.requestFocus();
            return false;
        }
        carros = Datos.obtener();
        for (int i = 0; i < carros.size(); i++){
            if (carros.get(i).getPlaca().equalsIgnoreCase(txtPlaca.getText().toString())){
                txtPlaca.setError(getResources().getString(R.string.error_placa_dos));
                txtPlaca.requestFocus();
                return false;
            }
        }
        return true;
    }

    public int fotoAleatoria(){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public void guardar(View v){
        if (validar()) {
            String plac, pre;
            int foto, col, mar;
            foto = this.fotoAleatoria();
            plac = txtPlaca.getText().toString();
            col = cmbColor.getSelectedItemPosition();
            mar = cmbMarca.getSelectedItemPosition();
            pre = txtPrecio.getText().toString();
            Carro c = new Carro(foto, plac, col, mar, pre);
            c.guardar();
            limpiar();
            Snackbar.make(v, getResources().getString(R.string.guardado_exitoso), Snackbar.LENGTH_SHORT)
                    .show();
        }
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarCarro.this,Principal.class);
        startActivity(i);
    }

    public void limpiar(){
        cmbColor.setSelection(0);
        cmbMarca.setSelection(0);
        txtPlaca.setText("");
        txtPrecio.setText("");
        txtPlaca.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }


    public void limpiar(View v){
        limpiar();
    }
}
