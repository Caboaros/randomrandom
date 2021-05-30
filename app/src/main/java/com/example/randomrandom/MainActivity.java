package com.example.randomrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText numEscolhido;
    TextView textResultado;
    TextView textoNumSorteado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numEscolhido = findViewById(R.id.edit_numInput);
        textResultado = findViewById(R.id.textAcertou);
        textoNumSorteado= findViewById(R.id.result);
    }

    public void rodar(View view) {

        int max = 10;
        int numRand = new Random().nextInt(max + 1);

        String numInput = numEscolhido.getText().toString();

        if(validar(numInput)){
            textoNumSorteado.setText("Sorteado: " + numRand);
            int escolhido = Integer.parseInt(numInput);

            if (numRand == escolhido)
                textResultado.setText("ACERTOU!");
            else
                textResultado.setText("ERROU!");
            if (escolhido > max)
                textResultado.setText("Entre 0 e 10!");
        }
        else {
            textResultado.setText("Entre 0 e 10!");
        }
    }

    public Boolean validar (String num){
        if(num == null || num.equals(""))
            return false;
        else
            return true;
    }
}