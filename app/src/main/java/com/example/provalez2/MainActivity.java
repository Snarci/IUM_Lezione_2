package com.example.provalez2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Persona persona;
    EditText nome,cognome,data,indirizzo;
    TextView eta;
    Button inserisci;
    public static final String path="com.example.provalez2.Persona";
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    /*SEEKBAR ZONE*/
    SeekBar seekBar = findViewById(R.id.etaSeek);
    final TextView seekBarValue = findViewById(R.id.etaShow);

       seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
        boolean fromUser) {
            // TODO Auto-generated method stub
            seekBarValue.setText(String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
        }
    });
       /*RESULT ZONE*/



        nome=findViewById(R.id.nome);
        cognome=findViewById(R.id.cognome);
        indirizzo=findViewById(R.id.indirizzo);
        eta=findViewById(R.id.etaShow);
        data=findViewById(R.id.dataNascita);
        inserisci=findViewById(R.id.inserisci);
        persona= new Persona();

        /*ASCOLTA APERTURA NUOVA ACT*/
        inserisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePerson();
                Intent showResult =new Intent(MainActivity.this,Result.class);
                showResult.putExtra(path,persona);
                startActivity(showResult);
            }
        });

}
    public void updatePerson(){
        this.persona.setNome(this.nome.getText().toString());
        this.persona.setCognome(this.cognome.getText().toString());
        this.persona.setData(this.data.getText().toString());
        this.persona.setEta(this.eta.getText().toString());
        this.persona.setIndirizzo(this.indirizzo.getText().toString());
    }
}