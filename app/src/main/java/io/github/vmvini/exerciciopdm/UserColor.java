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
    private static int count = 0;

    public UserColor(){
       colors = new ArrayList<>();
        colors.add(R.color.usericon_green);
        colors.add(R.color.usericon_orange);
        colors.add(R.color.usericon_yellow);
    }

    public int random(){
        if(count == 3)
            count = 0;
        return colors.get(count++);
    }

}
