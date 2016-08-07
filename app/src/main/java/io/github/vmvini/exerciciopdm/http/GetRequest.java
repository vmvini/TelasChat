package io.github.vmvini.exerciciopdm.http;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

/**
 * Created by vmvini on 07/08/16.
 */
public class GetRequest implements Request {

    private Connection c;

    public GetRequest(Connection c) throws ProtocolException{
        this.c = c;
        configGetRequest();
    }

    private void configGetRequest() throws ProtocolException{
        HttpURLConnection con = c.getConnection();
        con.setRequestMethod("GET");

    }

    public JSONObject send() throws IOException, JSONException{

        c.getConnection().connect();
        return c.getResponse();

    }

}
