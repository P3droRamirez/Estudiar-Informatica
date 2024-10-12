package ies.camas.estudiarinformaticarepaso;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spCiclo,spPoblacion, spTipo;
    TextView txtResultado;
    Button btnBorrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spCiclo = findViewById(R.id.spCiclos);
        spPoblacion = findViewById(R.id.spPoblacion);
        spTipo = findViewById(R.id.spTipo);

        txtResultado = findViewById(R.id.txtResultado);

        btnBorrar = findViewById(R.id.btnBorrar);

        spCiclo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mostrarInfo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spPoblacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mostrarInfo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mostrarInfo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnBorrar.setOnClickListener(view -> borrar());
    }

    private void mostrarInfo() {
        String ciclo = spCiclo.getSelectedItem().toString();
        String poblacion = spPoblacion.getSelectedItem().toString();
        String tipo = spTipo.getSelectedItem().toString();

        // Construcción dinámica del mensaje
        StringBuilder resultado = new StringBuilder();

        if (!ciclo.isEmpty() && !ciclo.equals("Seleccionar ciclo")) {  // Asegurarse de que no sea el valor por defecto
            resultado.append(ciclo);
        }

        if (!poblacion.isEmpty() && !poblacion.equals("Seleccionar población")) {  // Asegurarse de que no sea el valor por defecto
            if (resultado.length() > 0) {
                resultado.append(" en ");
            }
            resultado.append(poblacion);
        }

        if (!tipo.isEmpty() && !tipo.equals("Seleccionar tipo")) {  // Asegurarse de que no sea el valor por defecto
            if (resultado.length() > 0) {
                resultado.append(" de forma ");
            }
            resultado.append(tipo);
        }

        // Actualizar el TextView con el resultado generado
        txtResultado.setText(resultado.toString());
    }

    public void borrar(){
        txtResultado.setText("");
    }
}