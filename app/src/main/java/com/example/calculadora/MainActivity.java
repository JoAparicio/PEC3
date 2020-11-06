package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etxNum1;
    EditText etxNum2;
    Switch swSR;
    ToggleButton tbtnMD;
    Button btnOp1;
    Button btnOp2;
    TextView etxResultado;
    Button btnBorrar;
    int num1 = 0;
    int num2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    public void inicializar(){
        etxNum1 = findViewById(R.id.etxNum1);
        etxNum2 = findViewById(R.id.etxNum2);
        swSR = findViewById(R.id.swSR);
        tbtnMD = findViewById(R.id.tbtnMD);
        btnOp1 = findViewById(R.id.btnOp1);
        btnOp2 = findViewById(R.id.btnOp2);
        etxResultado = findViewById(R.id.etxResultado);
        btnBorrar = findViewById(R.id.btnBorrar);


        btnOp1.setOnClickListener(this);
        btnOp2.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);

    }
    public void multiplicar(){
        etxResultado.setText(String.valueOf(num1*num2));
    }
    public void dividir(){
        etxResultado.setText(String.valueOf(num1/num2));
    }
    public void sumar(){
        etxResultado.setText(String.valueOf(num1+num2));
    }
    public void restar(){
        etxResultado.setText(String.valueOf(num1-num2));
    }
    public void asignarNumero(){
        try {
            num1 = Integer.parseInt(etxNum1.getText().toString());
            num2 = Integer.parseInt(etxNum2.getText().toString());
        }catch (Exception e){

        }
    }
    public void prueba(){

    }
    public void borrar(){
        etxResultado.setText("");
        etxNum1.setText("");
        etxNum2.setText("");
        swSR.setChecked(false);
        tbtnMD.setChecked(false);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        String paquete = getPackageName();
        i.putExtra("paquete1",paquete);
        setResult(RESULT_OK, i);
        finish();

        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        asignarNumero();
        switch (v.getId()){
            case R.id.btnOp1:
                if(swSR.isChecked()){
                    restar();
                }else{
                    sumar();
                }
                break;
            case R.id.btnOp2 :
                if(tbtnMD.isChecked()){
                    dividir();
                }else{
                    multiplicar();
                }
                break;
            case R.id.btnBorrar:
                borrar();
                break;
        }
    }
}