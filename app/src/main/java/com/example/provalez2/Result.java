package com.example.provalez2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Result extends AppCompatActivity {
    Persona persona;
    TextView nomeT,cognomeT,indirizzoT,etaT;
    Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        nomeT=findViewById(R.id.nome);
        cognomeT=findViewById(R.id.cognome);
        indirizzoT=findViewById(R.id.indirizzo);
        etaT=findViewById(R.id.eta);
        confirm=findViewById(R.id.confirmaButt);
        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(MainActivity.path);

        if(object instanceof  Persona){
            this.persona =(Persona) object;
        }else{
            this.persona=new Persona();
        }
        nomeT.setText(persona.getNome());
        cognomeT.setText(persona.getCognome());
        indirizzoT.setText(persona.getIndirizzo());
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/YYYY");
        etaT.setText(format.format(persona.getDataDiNascita().getTime()));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button back;
        back=findViewById(R.id.back);


        /*ASCOLTA APERTURA NUOVA ACT*/
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent showResult =new Intent(Result.this,MainActivity.class);
                startActivity(showResult);
            }
        });
    }
}