package io.github.vmvini.exerciciopdm;

/**
 * Created by vmvini on 20/07/16.
 */
public class User {

    private String name;

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

}
