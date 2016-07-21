package io.github.vmvini.exerciciopdm;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by vmvini on 21/07/16.
 */
public class UserColor {

    private List<Integer> colors;

    public UserColor(){
       colors = new ArrayList<>();
        colors.add(R.color.usericon_green);
        colors.add(R.color.usericon_orange);
        colors.add(R.color.usericon_yellow);
    }

    public int random(){
        Collections.shuffle(colors);
        Iterator i = colors.iterator();
        return (int)i.next();
    }

}
