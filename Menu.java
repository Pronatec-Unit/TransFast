package com.example.adryangabriel.escolaronibus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    public Button bfilhos;

    public void init() {
        bfilhos = (Button) findViewById(R.id.bfilhos);
        bfilhos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(Menu.this,filho.class);

                startActivity(toy);

            }
        });


    }




    public Button buttonmoto;

    public void inite() {
        buttonmoto = (Button) findViewById(R.id.buttonmoto);
        buttonmoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(Menu.this,Motoristas.class);

                startActivity(toy);

            }
        });


    }

    public Button buttonconta;

    public void initer() {
        buttonconta = (Button) findViewById(R.id.buttonconta);
        buttonconta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(Menu.this,Conta.class);

                startActivity(toy);

            }
        });


    }

    public Button buttonajuda;

    public void initey() {
        buttonajuda = (Button) findViewById(R.id.buttonajuda);
        buttonajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(Menu.this,Ajuda.class);

                startActivity(toy);

            }
        });


    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
        inite();
        initer();
        initey();

    }
}




