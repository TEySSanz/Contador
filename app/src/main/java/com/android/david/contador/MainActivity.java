package com.android.david.contador;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    public int contador;

    TextView miTextView;
    EditText reseteaTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miTextView = (TextView) findViewById(R.id.contadorTexto);
        contador=0;

    }

    public void incrementaContador(View vista){
        contador++;
        miTextView.setText(""+contador);
        //mostrarResultado();
    }

    public void decrementaContador(View vista){
        contador--;
        if (contador<0){
            CheckBox negativos = (CheckBox) findViewById(R.id.reseteaCheckBox);
            if(!negativos.isChecked()) {
               contador=0;
            }
        }
        miTextView.setText("" + contador);
        //mostrarResultado();
    }

    public void reseteaContador(View vista){

        reseteaTextView = (EditText) findViewById(R.id.reseteaNumber);
        //Log.d("Contador", ""+reseteaTextView.getText().length());

        if(reseteaTextView.getText().length()>0){
            contador=Integer.parseInt(reseteaTextView.getText().toString());
        } else {
            contador=0;
        }

        reseteaTextView.setText("");
        miTextView.setText("" + contador);

        //mostrarResultado();
    }

    /*public void mostrarResultado(){
        TextView miTextView = (TextView) findViewById(R.id.contadorTexto);
        miTextView.setText(""+contador);

    }*/




}
