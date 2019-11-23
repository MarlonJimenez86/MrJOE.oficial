package com.example.mrjoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_ubicacion(View view) {
        Intent btnCreaUs = new Intent(MainActivity.this, activity_ubicanos.class);
        startActivity(btnCreaUs);

    }

    public void btn_producto(View view) {
        Intent btnCreaUs = new Intent(MainActivity.this, activity_productos.class);
        startActivity(btnCreaUs);
    }

    public void btn_quienes_somos(View view) {
        Intent btnCreaUs = new Intent(MainActivity.this, Activity_quiensomos.class);
        startActivity(btnCreaUs);
    }

    public void btn_conacto(View view) {
        Intent btnCreaUs = new Intent(MainActivity.this, Activity_contactenos.class);
        startActivity(btnCreaUs);
    }
}
