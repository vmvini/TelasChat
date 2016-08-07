package httpclient;

import android.app.Activity;
import android.content.Intent;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

import io.github.vmvini.exerciciopdm.MainActivity;
import io.github.vmvini.exerciciopdm.SecondActivity;
import io.github.vmvini.exerciciopdm.User;

/**
 * Created by vmvini on 03/08/16.
 */
public class LoginClient extends JsonClient {



    public LoginClient(MainActivity activity, String name,  String password){
        super("http://10.0.2.2:3000/login?password=" + password, activity, "GET");
    }

    @Override
    public void custom(JSONObject json) {
        User user;
       Gson gson = new Gson();
        try {
            if (json.getString("success").equals("true")) {
                user = gson.fromJson(json.getString("user"), User.class);
                Intent intent = new Intent(activity, SecondActivity.class);
                intent.putExtra("user", user );
                activity.startActivity(intent);
            }
            else{
                //erro na autenticacao
                ((MainActivity)activity).showResponse("Senha incorreta");

            }
        }
        catch(JSONException e){
            e.printStackTrace();
        }

    }

    public void sendJsonObject(HttpURLConnection urlConnection){

    }



}
