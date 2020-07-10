package com.example.minhasanotacoes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias anotacaoPreferencias;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        anotacaoPreferencias = new AnotacaoPreferencias(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textRecuperado = editText.getText().toString();
                if(textRecuperado.equals("")){
                    Snackbar.make(view, "Digite algo", Snackbar.LENGTH_LONG).show();
                }else{
                    anotacaoPreferencias.salvarAnotacoes(textRecuperado);
                    Snackbar.make(view, "ANotação salva com sucesso", Snackbar.LENGTH_LONG).show();
                }


            }
        });

        //Recuperar anotação
        String anotacao = anotacaoPreferencias.recuperarAnotacoes();
        if(!anotacao.equals("")){
            editText.setText(anotacao);
        }
    }

}
