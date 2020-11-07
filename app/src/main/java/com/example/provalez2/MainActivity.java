package com.example.provalez2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Persona persona;
    EditText nome,cognome,indirizzo;
    TextView eta,error;
    Button inserisci,refresh;

    public static final String path="com.example.provalez2.Persona";
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    /*SEEKBAR ZONE*/
       /*RESULT ZONE*/



        nome=findViewById(R.id.nome);
        cognome=findViewById(R.id.cognome);
        indirizzo=findViewById(R.id.indirizzo);
        eta=findViewById(R.id.dataNascita);
        inserisci=findViewById(R.id.inserisci);
        refresh=findViewById(R.id.refresh);
        error=findViewById(R.id.error);
        persona= new Persona();
        persona.dataDiNascita=null;
        eta.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    eta.setError(null);
                    showDialog();
                }
            }
        });
        eta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eta.setError(null);
                showDialog();
            }
        });

        /*ASCOLTA APERTURA NUOVA ACT*/
        inserisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updatePerson();
                if(generalError()) return;

                Intent showResult =new Intent(MainActivity.this,Result.class);
                showResult.putExtra(path,persona);
                startActivity(showResult);
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });

}
    public void updatePerson(){
        this.persona.setNome(this.nome.getText().toString());
        this.persona.setCognome(this.cognome.getText().toString());
        this.persona.setIndirizzo(this.indirizzo.getText().toString());

    }

    public boolean capCheck(String cap){
        this.indirizzo.setError("Cap Errato");
        return cap.length() == 5;
    }
    public boolean nomeCheck(String nome){
        this.nome.setError("vuoto");
        return nome.length() != 0 && nome != null;
    }
    public boolean cognomeCheck(String cognome){
        this.cognome.setError("vuoto");
        return cognome.length() != 0 && cognome != null;

    }
    public boolean maggCheck(Calendar data){

            Calendar today = Calendar.getInstance();
            int age = today.get(Calendar.YEAR) - data.get(Calendar.YEAR);
            if (today.get(Calendar.MONTH) < data.get(Calendar.MONTH)) {
                age--;
            } else if (today.get(Calendar.MONTH) == data.get(Calendar.MONTH)
                    && today.get(Calendar.DAY_OF_MONTH) < data
                    .get(Calendar.DAY_OF_MONTH)) {
                age--;
            }

            if (age < 18) {
                eta.setError("Minorenne");
               return false;
            }
            return true;
    }
    public boolean generalError(){
        int countErrori=0;
        if(!capCheck(persona.getIndirizzo())) countErrori++;
        else indirizzo.setError(null);
        if(!nomeCheck(persona.getNome())) countErrori++;
        else nome.setError(null);
        if(!cognomeCheck(persona.getCognome())) countErrori++;
        else cognome.setError(null);
        if(persona.dataDiNascita==null) {
            eta.setError("Inserire data di nascita");
            countErrori++;
        }



        if(countErrori>0){
            error.setText(R.string.errore);
            error.setTextColor(Color.BLACK);
            error.setBackgroundColor(Color.RED);
            error.setText("Ci sono: "+countErrori+" errori");
            return true;
        }

       return false;
    }

    public void refresh(){
        nome.setText("");
        cognome.setText("");
        eta.setText("");
        indirizzo.setText("");
    }
    void showDialog() {
        DialogFragment newFragment = DatePickerFrag.newInstance();
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    public void doPositiveClick(Calendar date) {
        // Do stuff here.
        if(!maggCheck(date)) {
            date=null;
            return;
        }
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/YYYY");
        eta.setText(format.format(date.getTime()));
        persona.setDataDiNascita(date);


    }

    public void doNegativeClick(Dialog dialog) {
        // Do stuff here.
        dialog.dismiss();
    }
    public void updateDataNascita(Calendar date){
        this.persona.setDataDiNascita(date);
    }

}