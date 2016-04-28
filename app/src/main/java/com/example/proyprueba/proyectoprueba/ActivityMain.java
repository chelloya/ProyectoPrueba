package com.example.proyprueba.proyectoprueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SaludarOnClick (View v){

        EditText CajaTexto = (EditText) findViewById(R.id.editText);
        String nombre = CajaTexto.getText().toString();
        Toast.makeText(this,"Hola " + nombre,Toast.LENGTH_LONG).show();
        Intent fa = new Intent(getApplicationContext(), ActivityFinal.class);
        startActivity(fa);
    }

}
