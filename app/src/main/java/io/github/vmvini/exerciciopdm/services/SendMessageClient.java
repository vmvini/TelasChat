package io.github.vmvini.exerciciopdm.services;

import android.app.Activity;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.github.vmvini.exerciciopdm.Chat;
import io.github.vmvini.exerciciopdm.Mensagem;
import io.github.vmvini.exerciciopdm.http.HttpFacade;

/**
 * Created by vmvini on 08/08/16.
 */
public class SendMessageClient extends GenericClient {

    private Mensagem msg;
    private Chat chat;

    public SendMessageClient(Activity activity, Chat chat, Mensagem msg){
        super(activity);
        this.chat = chat;
        this.msg = msg;
    }

    @Override
    public JSONObject getJSONObjectFromURL() throws IOException, JSONException {
        HttpFacade http = new HttpFacade();
        JSONObject args = new JSONObject();
        Gson gson = new Gson();
        args.put( "chatId", chat.get_id() );
        args.put("message", gson.toJson(msg) );
        return http.post("http://10.0.2.2:3000/api/message/", args );
    }

    @Override
    public void custom(JSONObject json) {
        System.out.println("mensagem enviada");
        System.out.println(json);
    }
}
