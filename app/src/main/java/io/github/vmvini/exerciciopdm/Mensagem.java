package io.github.vmvini.exerciciopdm;

import java.io.Serializable;

/**
 * Created by vmvini on 20/07/16.
 */
public class Mensagem implements Serializable {

    /*
    * message: String,
	from: { type: UserSchema }
    * */

    private User from;

    private String message;



    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public String getResumida(){
        int length = message.length();
        if(length >= 27)
            return getNCharacters(message, 24) + "...";
        return message;
    }



    public void setFrom(User from){
        this.from = from;
    }
    public User getFrom(){
        return from;
    }

    public String toString(){
        return message;
    }

    private String getNCharacters(String word, int q){
        return word.substring(0, Math.min(word.length(), q));
    }

}
