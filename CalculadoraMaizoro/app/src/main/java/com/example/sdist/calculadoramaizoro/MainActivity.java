package com.example.sdist.calculadoramaizoro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText oper1, oper2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oper1=(EditText)findViewById(R.id.editText);
        oper2=(EditText)findViewById(R.id.editText2);
    }
    public void suma(View v){
        int num1, num2, res;
        num1=Integer.parseInt(oper1.getText().toString());
        num2=Integer.parseInt(oper2.getText().toString());
        res=num1+num2;
        mostrar(res);
    }
    public void resta(View v){
        int num1, num2, res;
        num1=Integer.parseInt(oper1.getText().toString());
        num2=Integer.parseInt(oper2.getText().toString());
        res=num1-num2;
        mostrar(res);
    }
    public void división(View v){
        int num1, num2, res;
        num1=Integer.parseInt(oper1.getText().toString());
        num2=Integer.parseInt(oper2.getText().toString());
        if (num2 != 0) {
            res = num1 / num2;
            mostrar(res);
        }else
            Toast.makeText(this,"No se puede dividir entre cero", Toast.LENGTH_LONG).show();
    }
    public void multiplicación(View v){
        int num1, num2, res;
        num1=Integer.parseInt(oper1.getText().toString());
        num2=Integer.parseInt(oper2.getText().toString());
        res=num1*num2;
        mostrar(res);
    }
    public void potencia(View v){
        int num1, num2, res;
        num1=Integer.parseInt(oper1.getText().toString());
        num2=Integer.parseInt(oper2.getText().toString());
        res=num1^num2;
        mostrar(res);
    }
    public void clear(View v){
        int num1, num2, res;
        oper1.setText(0);
        oper1.setTag(0);
        Toast.makeText(this,"Clear", Toast.LENGTH_LONG).show();
    }

    private void mostrar(int res) {
        Toast.makeText(this,"El resultado es: " + res, Toast.LENGTH_LONG).show();
    }
}
