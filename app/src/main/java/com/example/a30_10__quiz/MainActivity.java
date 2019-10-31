package com.example.a30_10__quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView pregunta;
    private Button boton;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pregunta = (TextView) findViewById(R.id.texto);
        String[] preguntas = getResources().getStringArray(R.array.listaPreguntas);
        String preguntaActual = preguntas[contador];
        pregunta.setText(preguntaActual);
    }



    public void mostrarRespuesta(View view){
        Button boton = (Button) view;
        String[] array = getResources().getStringArray(R.array.listaRespuestas);
        if(array[contador].equals(boton.getText().toString())){
            mostrarMensajeCorrecto();
        }else{
            mostrarMensajeIncorrecto();
        }
    }

    public void cambiarPregunta(View view){
        Button boton = (Button) view;
        String[] preguntas = getResources().getStringArray(R.array.listaPreguntas);

            if(boton.getText().toString().equals("Siguiente")){
                if(contador<preguntas.length-1){
                    contador++;
                }

            }else{
                if(contador>0){
                    contador--;
                }
            }

            String preguntaActual = preguntas[contador];
            pregunta.setText(preguntaActual);



    }

    public void mostrarMensajeCorrecto(){
        Toast.makeText(this,"¡Has acertado!",Toast.LENGTH_LONG).show();
    }

    public void mostrarMensajeIncorrecto(){
        Toast.makeText(this,"¡Te has equivocado!",Toast.LENGTH_LONG).show();
    }







}
