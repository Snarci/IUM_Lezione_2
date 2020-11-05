package com.example.provalez2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class Result extends AppCompatActivity {
    Persona persona;
    TextView nomeT,cognomeT,dataT,indirizzoT,etaT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        nomeT=findViewById(R.id.nome);
        cognomeT=findViewById(R.id.cognome);
        dataT=findViewById(R.id.dataNascita);
        indirizzoT=findViewById(R.id.indirizzo);
        etaT=findViewById(R.id.eta);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(MainActivity.path);

        if(object instanceof  Persona){
            this.persona =(Persona) object;
        }else{
            this.persona=new Persona();
        }
        nomeT.setText(persona.getNome());
        cognomeT.setText(persona.getCognome());
        dataT.setText(persona.getData());
        indirizzoT.setText(persona.getIndirizzo());
        etaT.setText(persona.getEta());


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