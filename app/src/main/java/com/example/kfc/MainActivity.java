package com.example.kfc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import Grados.celcius;
import Grados.fahrenheit;
import Grados.grado;
import Grados.kelvin;

public class MainActivity extends AppCompatActivity {

    private EditText valorEditText;
    private RadioGroup fromGroup, toGroup;
    private Button convertirButton;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos de la interfaz
        valorEditText = findViewById(R.id.Valor);
        fromGroup = findViewById(R.id.Radio1);
        toGroup = findViewById(R.id.Radio2);
        convertirButton = findViewById(R.id.btnConvertir);
        resultadoTextView = findViewById(R.id.textResultado);

        // Evento al presionar el botón "Convertir"
        convertirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarConversion();
            }
        });
    }

    private void realizarConversion() {
        // Obtener el valor ingresado
        String valorTexto = valorEditText.getText().toString();
        if (valorTexto.isEmpty()) {
            resultadoTextView.setText("Por favor ingresa un valor.");
            return;
        }

        double valor = Double.parseDouble(valorTexto);

        // Obtener la selección del RadioGroup de entrada
        int fromSelectedId = fromGroup.getCheckedRadioButtonId();
        int toSelectedId = toGroup.getCheckedRadioButtonId();

        if (fromSelectedId == -1 || toSelectedId == -1) {
            resultadoTextView.setText("Por favor selecciona ambos tipos.");
            return;
        }

        // Variables para las conversiones
        grado resultado = null;

        if (fromSelectedId == R.id.Kelvin1)
        {
            kelvin kelvinInicial = new kelvin();
            kelvinInicial.setValor(valor);
            if (toSelectedId == R.id.Celsius2)
            {
                resultado = new celcius().parse(kelvinInicial);
            } else if (toSelectedId == R.id.Fahrenheit2)
            {
                resultado = new fahrenheit().parse(kelvinInicial);
            }
        } else if (fromSelectedId == R.id.Fahrenheit1)
        {
            fahrenheit fahrenheitInicial = new fahrenheit();
            fahrenheitInicial.setValor(valor);
            if (toSelectedId == R.id.Celsius2)
            {
                resultado = new celcius().parse(fahrenheitInicial);
            } else if (toSelectedId == R.id.Kelvin2)
            {
                resultado = new kelvin().parse(fahrenheitInicial);
            }
        } else if (fromSelectedId == R.id.Celsius1)
        {
            celcius celsiusInicial = new celcius();
            celsiusInicial.setValor(valor);
            if (toSelectedId == R.id.Kelvin2)
            {
                resultado = new kelvin().parse(celsiusInicial);
            } else if (toSelectedId == R.id.Fahrenheit2)
            {
                resultado = new fahrenheit().parse(celsiusInicial);
            }
        }

        if (resultado != null) {
            resultadoTextView.setText("Resultado: " + resultado.getValor() + " " + resultado.getUnidad());
        } else {
            resultadoTextView.setText("Error en la conversión.");
        }
    }
}
