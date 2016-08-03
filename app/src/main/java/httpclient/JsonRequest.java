package httpclient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by vmvini on 03/08/16.
 */
public class JsonRequest extends Thread {

    private JSONObject resp;
    private String urlString;
    private Exception exception;

    public JSONObject getJSONObject(){
        return resp;
    }
    public Exception getException(){
        return exception;
    }

    public JsonRequest(String urlString){
        this.urlString = urlString;
    }

    public void run(){
        try{
            resp = getJSONObjectFromURL();
        }
        catch(JSONException | IOException e){
            exception = e;
        }
    }


    private  JSONObject getJSONObjectFromURL() throws IOException, JSONException {

        HttpURLConnection urlConnection = null;

        URL url = new URL(urlString);

        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */);
        urlConnection.setConnectTimeout(15000 /* milliseconds */);

        urlConnection.setDoOutput(true);

        urlConnection.connect();

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

}
