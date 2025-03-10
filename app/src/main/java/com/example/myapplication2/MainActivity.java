package com.example.myapplication2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edt_num1,edt_num2;
    TextView txt_res;
    Button btn_sumar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner_main);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Select item: " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> Symbol = new ArrayList<>();
        Symbol.add("+");
        Symbol.add("-");
        Symbol.add("x");
        Symbol.add("/");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Symbol);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);

        edt_num1 = findViewById(R.id.edt_num1);
        edt_num2 = findViewById(R.id.edt_num2);
        txt_res = findViewById(R.id.txt_res);
        btn_sumar = findViewById(R.id.btn_sumar);

        btn_sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesar();
            }

            private void procesar() {
                String num1 = edt_num1.getText().toString();
                String num2 = edt_num2.getText().toString();
                if (num1.isEmpty()||num2.isEmpty()){
                    Toast.makeText(MainActivity.this,"Favor, llenar todos los campos", Toast.LENGTH_LONG).show();
                }
                double n1 = Double.parseDouble(num1);
                double n2 = Double.parseDouble(num2);
                double resul = 0;
                String operator = spinner.getSelectedItem().toString();

                switch (operator){
                    case "+":
                        resul = n1 + n2;
                        break;
                    case "-":
                        resul = n1 - n2;
                        break;
                    case "x":
                        resul = n1 * n2;
                        break;
                    case "/":
                        if (n2 != 0) {
                            resul = n1 / n2;
                        } else {
                            Toast.makeText(MainActivity.this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
                            return;
                        }
                        break;
                }
                txt_res.setText(String.valueOf(resul));
            }
        });
    }
}