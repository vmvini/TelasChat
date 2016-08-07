package httpclient;

import android.app.Activity;
import android.os.Message;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import io.github.vmvini.exerciciopdm.User;

/**
 * Created by vmvini on 03/08/16.
 */
public class SendMessageClient extends JsonClient {

    private User user;

    public SendMessageClient(Activity activity, User user){

        super("http://10.0.2.2:3000/send", activity, "POST");
        this.user = user;
    }

    @Override
    public void sendJsonObject(HttpURLConnection urlConnection) {
        try{
            JSONObject parent=new JSONObject();

            OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
            Gson gson = new Gson();
            parent.put("user", gson.toJson(user).toString());
            wr.write(parent.toString());
            wr.flush();

            System.out.println("enviou mensagem!!!!!!!!!!!!!!!!!");
        }
        catch(IOException | JSONException e){
            e.printStackTrace();
        }

    }

    @Override
    public void custom(JSONObject json) {
        System.out.println("enviou mensagem");
    }
}
