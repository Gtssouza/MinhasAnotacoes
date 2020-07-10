package com.example.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final String  NOME_ARQUIVO = "anotacao.preferencias";
    private final String CHAVE_NOME = "nome";

    public AnotacaoPreferencias(Context c) {
        this.context = c;
        sharedPreferences = context.getSharedPreferences(NOME_ARQUIVO,0);
        editor = sharedPreferences.edit();
    }

    public  void salvarAnotacoes(String anotacao){
        editor.putString(CHAVE_NOME,anotacao );
        editor.commit();
    }

    public String recuperarAnotacoes(){
        return sharedPreferences.getString(CHAVE_NOME,"");
        
    }
}
