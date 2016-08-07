package io.github.vmvini.exerciciopdm.services;

import android.app.Activity;
import android.content.Intent;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.github.vmvini.exerciciopdm.Chat;
import io.github.vmvini.exerciciopdm.MainActivity;
import io.github.vmvini.exerciciopdm.SecondActivity;
import io.github.vmvini.exerciciopdm.ThirdActivity;
import io.github.vmvini.exerciciopdm.UserContacts;
import io.github.vmvini.exerciciopdm.http.HttpFacade;

/**
 * Created by vmvini on 07/08/16.
 */
public class LoadChatClient extends GenericClient {


    private Chat chat;

    public LoadChatClient(Activity activity, Chat chat){
        super(activity);
        this.chat = chat;
    }

    public  JSONObject getJSONObjectFromURL() throws IOException, JSONException{
        ///chat/:user1/:user2
        HttpFacade http = new HttpFacade();
        return http.get("http://10.0.2.2:3000/api/chat/" + chat.getUser1().get_id() + "/" + chat.getUser2().get_id());


    }

    public  void custom(JSONObject json){

        try{
            if(json.getString("success").equals("true")){
                Gson gson = new Gson();
                chat = gson.fromJson(json.getString("chat"), Chat.class);

            }
            else{
                GenericClient postChat = new PostChatClient(activity, chat);
                postChat.start();
            }

        }
        catch(JSONException e){
            e.printStackTrace();
        }

    }

}
