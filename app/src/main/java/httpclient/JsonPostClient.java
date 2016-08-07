package httpclient;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import io.github.vmvini.exerciciopdm.User;

/**
 * Created by vmvini on 03/08/16.
 */
public abstract class JsonPostClient extends Thread {

    private String url;

    public JsonPostClient(String url){
        this.url = url;
    }

    public abstract void setArgs(JSONObject object);

    public void run(){

        HttpURLConnection con = null;
        try {

            URL object = new URL(url);

            con = (HttpURLConnection) object.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("POST");

            JSONObject parent = new JSONObject();

            setArgs(parent);

            //Gson gson = new Gson();
            //parent.put("user", gson.toJson(user).toString());


            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(parent.toString());
            wr.flush();

//display what returns the POST request

            StringBuilder sb = new StringBuilder();
            int HttpResult = con.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                System.out.println("" + sb.toString());
            } else {
                System.out.println(con.getResponseMessage());
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        finally{
            if (con != null){
                con.disconnect();
            }
        }
    }

}
