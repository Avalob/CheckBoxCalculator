package com.example.calculadoracheckbox;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textViewNum1, textViewNum2, textViewOptions, textViewResultado;
    private Button buttonCalcular;
    private EditText editTextNum1, editTextNum2;
    private CheckBox checkBoxDividir, checkBoxSumar, checkBoxMult, checkBoxRestar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewNum1 = findViewById(R.id.textViewNum1);
        textViewNum2 = findViewById(R.id.textViewNum2);
        textViewOptions = findViewById(R.id.TextViewOptions);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonCalcular = findViewById(R.id.buttonCalcular);

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);

        checkBoxDividir = findViewById(R.id.checkBoxDividir);
        checkBoxMult = findViewById(R.id.checkBoxMult);
        checkBoxRestar = findViewById(R.id.checkBoxRestar);
        checkBoxSumar = findViewById(R.id.checkBoxSumar);

        buttonCalcular.setOnClickListener(v -> {
            String num1Text = editTextNum1.getText().toString();
            String num2Text = editTextNum2.getText().toString();

            if (num1Text.isEmpty() || num2Text.isEmpty()) {
                textViewResultado.setText("Por favor, ingresa ambos números.");
                return;
            }

            double num1 = Double.parseDouble(num1Text);
            double num2 = Double.parseDouble(num2Text);

            StringBuilder resultado = new StringBuilder();

            if (checkBoxSumar.isChecked()) {
                resultado.append("Suma: ").append(num1 + num2).append("\n");
            }
            if (checkBoxRestar.isChecked()) {
                resultado.append("Resta: ").append(num1 - num2).append("\n");
            }
            if (checkBoxMult.isChecked()) {
                resultado.append("Multiplicación: ").append(num1 * num2).append("\n");
            }
            if (checkBoxDividir.isChecked()) {
                if (num2 != 0) {
                    resultado.append("División: ").append(num1 / num2).append("\n");
                } else {
                    resultado.append("División: No se puede dividir entre cero.\n");
                }
            }
            if (resultado.length() == 0) {
                textViewResultado.setText("Por favor, selecciona al menos una operación.");
            } else {
                textViewResultado.setText(resultado.toString());
            }
        });
    }
}
