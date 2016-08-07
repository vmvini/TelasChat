package io.github.vmvini.exerciciopdm.services;

import android.app.Activity;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.github.vmvini.exerciciopdm.User;
import io.github.vmvini.exerciciopdm.http.HttpFacade;

/**
 * Created by vmvini on 07/08/16.
 */
public class LastMessageClient extends GenericClient {

    private Activity activity;
    private User user1, user2;
    private TextView textView;

    public LastMessageClient(Activity activity, User user1, User user2, TextView textView){
        super(activity);
        this.user1 = user1;
        this.user2 = user2;
        this.textView = textView;

    }

    public  JSONObject getJSONObjectFromURL() throws IOException, JSONException{
        HttpFacade http = new HttpFacade();
        return http.get("http://10.0.2.2:3000/api/chat/lastmessage/" + user1.get_id() + "/" + user2.get_id());
    }

    public  void custom(JSONObject json){
        try {
            textView.setText(json.get("message").toString());
        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }

}
