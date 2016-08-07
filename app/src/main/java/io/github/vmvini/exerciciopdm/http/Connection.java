package io.github.vmvini.exerciciopdm.http;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by vmvini on 07/08/16.
 */
public class Connection {

    private HttpURLConnection connection;
    private URL urlObject;

    private Response response;

    public Connection(String url) throws IOException {
        urlObject = new URL(url);
        connection = (HttpURLConnection) urlObject.openConnection();
        connection.setDoOutput(true);
    }

    public URL getUrlObject(){
        return urlObject;
    }

    public void setResponse(Response response){
        this.response = response;
    }


    public HttpURLConnection getConnection(){
        return connection;
    }

    public JSONObject getResponse() throws IOException, JSONException{
        //BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

        BufferedReader br=new BufferedReader(new InputStreamReader(response.getInputStream(), "utf-8"));
        //urlObject.openStream();

        char[] buffer = new char[1024];

        String jsonString = new String();

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();

        jsonString = sb.toString();

        return new JSONObject(jsonString);
    }

}
