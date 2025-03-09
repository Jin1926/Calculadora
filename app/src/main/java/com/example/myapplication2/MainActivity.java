package com.example.myapplication2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
                }else{
                    int resul = Integer.parseInt(num1) + Integer.parseInt(num2);
                    txt_res.setText(resul+"");
                }
            }
        });
    }
}