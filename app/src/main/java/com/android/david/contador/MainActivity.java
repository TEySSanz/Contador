package com.android.david.contador;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
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

        /* Crear un objeto de la clase creada EventoTeclado para que al pulsar el botón "Hecho" llame a la función reseteaContador()*/
        EventoTeclado teclado = new EventoTeclado();
        EditText reseteaTextView_aux = (EditText) findViewById(R.id.reseteaNumber);
        reseteaTextView_aux.setOnEditorActionListener(teclado);
    }

    /* Función que llama a reseteaContador() cuando se pulsa el botón "Hecho" del teclado */
    class EventoTeclado implements TextView.OnEditorActionListener {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId== EditorInfo.IME_ACTION_DONE){
                reseteaContador(null);
            }
            return false;
        }
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

        /* Hacer que desaparezca el teclado una vez que se introduce el número del EditText reseteaTextView "R.id.reseteaNumber"
           y se pulsa el botón R.id.buttonResetea
        * */
        InputMethodManager miTeclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        miTeclado.hideSoftInputFromWindow(reseteaTextView.getWindowToken(), 0);


        //mostrarResultado();
    }

    /*public void mostrarResultado(){
        TextView miTextView = (TextView) findViewById(R.id.contadorTexto);
        miTextView.setText(""+contador);

    }*/




}
