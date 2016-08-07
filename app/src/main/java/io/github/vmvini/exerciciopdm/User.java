package io.github.vmvini.exerciciopdm;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vmvini on 20/07/16.
 */

public class User implements Serializable {

    private String name;
    private String salt;
    private String hash;



    private int color;

    public User(){
        UserColor uc = new UserColor();
        color = uc.random();
    }


    @Override
    public String toString(){
        return name;
    }

    public String getAbrev(){
        return getNCharacters(name, 2);
    }

    private String getNCharacters(String word, int q){
        return word.substring(0, Math.min(word.length(), q));
    }

    public int getColor(){
        return color;
    }

    public void setColor(int color){
        if(color == 0){
            UserColor uc = new UserColor();
            this.color = uc.random();
        }
        else
            this.color = color;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setHash(String hash){
        this.hash = hash;
    }

    public String getHash(){
        return hash;
    }

    public void setSalt(String salt){
        this.salt = salt;
    }
    public String getSalt(){
        return salt;
    }




}
