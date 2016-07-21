package io.github.vmvini.exerciciopdm;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vmvini on 20/07/16.
 */

public class User implements Serializable {

    private String name;

    private int color;

    public User(){
        UserColor uc = new UserColor();
        color = uc.random();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
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


}
