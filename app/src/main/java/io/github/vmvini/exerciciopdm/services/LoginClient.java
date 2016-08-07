package io.github.vmvini.exerciciopdm.services;

import android.app.Activity;
import android.content.Intent;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.github.vmvini.exerciciopdm.MainActivity;
import io.github.vmvini.exerciciopdm.SecondActivity;
import io.github.vmvini.exerciciopdm.UserContacts;
import io.github.vmvini.exerciciopdm.http.HttpFacade;

/**
 * Created by vmvini on 07/08/16.
 */
public class LoginClient extends GenericClient {

    private String name, password;
    private HttpFacade httpFacade;

    public LoginClient(Activity activity, String name, String password){
        super(activity);
        this.name = name;
        this.password = password;
        httpFacade = new HttpFacade();
    }

    public JSONObject getJSONObjectFromURL() throws IOException, JSONException{
        JSONObject args = new JSONObject();
        args.put("name", name);
        args.put("password", password);
        return httpFacade.post("http://10.0.2.2:3000/api/login", args);
    }

    public  void custom(JSONObject json){
        try{
            if(json.getString("success").equals("false")){
                ((MainActivity)activity).showResponse("Senha incorreta");
            }
            else{
                Gson gson = new Gson();
                UserContacts userContacts = gson.fromJson(json.getString("usercontacts"), UserContacts.class);
                Intent intent = new Intent(activity, SecondActivity.class);
                intent.putExtra("loggedUser", userContacts );
                activity.startActivity(intent);
            }
        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }
}
