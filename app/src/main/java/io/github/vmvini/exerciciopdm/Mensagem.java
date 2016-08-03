package io.github.vmvini.exerciciopdm;

import java.io.Serializable;

/**
 * Created by vmvini on 20/07/16.
 */
public class Mensagem implements Serializable {

    private User user;

    private String mensagem;



    public void setMensagem(String msg){
        mensagem = msg;
    }

    public String getMensagem(){
        return mensagem;
    }

    public String getResumida(){
        int length = mensagem.length();
        if(length >= 27)
            return getNCharacters(mensagem, 24) + "...";
        return mensagem;
    }



    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return user;
    }

    public String toString(){
        return mensagem;
    }

    private String getNCharacters(String word, int q){
        return word.substring(0, Math.min(word.length(), q));
    }

}
