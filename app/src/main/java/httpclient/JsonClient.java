package httpclient;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;


import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import io.github.vmvini.exerciciopdm.MainActivity;

/**
 * Created by vmvini on 03/08/16.
 */
public abstract class JsonClient extends Thread {

    private String result;
    protected Activity activity;
    private String method;

    private String url = "http://10.0.2.2:3000/test";

    public JsonClient(String url, Activity activity, String method){
        this.activity = activity;
        this.url = url;
        this.method = method;
    }

    public abstract void sendJsonObject(HttpURLConnection urlConnection);

    public JSONObject getJSONObjectFromURL(String urlString) throws IOException, JSONException {

        HttpURLConnection urlConnection = null;

        URL url = new URL(urlString);

        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod(method);
        urlConnection.setReadTimeout(10000 /* milliseconds */);
        urlConnection.setConnectTimeout(15000 /* milliseconds */);

        if(method.equals("POST")){
            urlConnection.setDoInput(true);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");

        }

        urlConnection.setDoOutput(true);

        urlConnection.connect();


        sendJsonObject(urlConnection);

        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));

        char[] buffer = new char[1024];

        String jsonString = new String();

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();

        jsonString = sb.toString();

        System.out.println("JSON: " + jsonString);

        return new JSONObject(jsonString);
    }

    public abstract void custom(JSONObject json);

    public void run() {

        try{
            final JSONObject json = getJSONObjectFromURL(url);
            activity.runOnUiThread(new Runnable(){
                public void run(){
                    custom(json);
                }
            });
        }
        catch(IOException  | JSONException e){
            e.printStackTrace();
        }


    }


}
