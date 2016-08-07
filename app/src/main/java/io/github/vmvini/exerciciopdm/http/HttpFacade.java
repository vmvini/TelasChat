package io.github.vmvini.exerciciopdm.http;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by vmvini on 07/08/16.
 */
public class HttpFacade {

    public JSONObject post(String url, JSONObject args)throws IOException, JSONException{
        Connection c = new Connection(url);
        Request r = new PostRequest(c, args);
        JSONObject resp = r.send();
        return resp;
    }

    public JSONObject get(String url) throws IOException, JSONException{
        Connection c = new Connection(url);
        Request r = new GetRequest(c);
        JSONObject resp = r.send();
        return resp;
    }


}

