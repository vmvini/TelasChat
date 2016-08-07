package io.github.vmvini.exerciciopdm.services;

import android.app.Activity;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.github.vmvini.exerciciopdm.Chat;
import io.github.vmvini.exerciciopdm.ThirdActivity;
import io.github.vmvini.exerciciopdm.http.HttpFacade;

/**
 * Created by vmvini on 07/08/16.
 */
public class PostChatClient extends GenericClient {

    private Chat chat;

    public PostChatClient(Activity activity, Chat chat){
        super(activity);
        this.chat = chat;
    }

    public  JSONObject getJSONObjectFromURL() throws IOException, JSONException{
        HttpFacade http = new HttpFacade();
        JSONObject args = new JSONObject();
        Gson gson = new Gson();
        args.put( "chat", gson.toJson(chat).toString() );
        return http.post("http://10.0.2.2:3000/api/chat/", args );
    }

    public  void custom(JSONObject json){

        try{
            if(json.getString("success").equals("true")){
                Gson gson = new Gson();
                chat = gson.fromJson(json.getString("chat"), Chat.class);
                ((ThirdActivity)activity).loadChat(chat);
            }
            else{
                //erro ao salvar novo chat
                System.out.println("Erro ao cadastrar novo chat");
            }

            //((ThirdActivity)activity).loadChat(chat);
        }
        catch(JSONException e){
            e.printStackTrace();
        }

    }

}
