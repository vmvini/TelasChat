package io.github.vmvini.exerciciopdm.services;

import android.app.Activity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by vmvini on 07/08/16.
 */
public abstract class GenericClient extends Thread {

    protected Activity activity;

    public GenericClient(Activity activity){
        this.activity = activity;
    }

    public abstract JSONObject getJSONObjectFromURL() throws IOException, JSONException;

    public abstract void custom(JSONObject json);

    public void run() {

        try{
            final JSONObject json = getJSONObjectFromURL();
            activity.runOnUiThread(new Runnable(){
                public void run(){
                    custom(json);
                }
            });
        }
        catch(IOException | JSONException e){
            e.printStackTrace();
        }


    }

}
