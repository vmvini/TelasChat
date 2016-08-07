package io.github.vmvini.exerciciopdm.http;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

/**
 * Created by vmvini on 07/08/16.
 */
public class PostRequest implements Request {

    private Connection connection;
    private JSONObject args;

    public PostRequest(Connection c, JSONObject args) throws ProtocolException, IOException{
        connection = c;
        this.args = args;
        configPostRequest();

    }

    private void configPostRequest() throws ProtocolException, IOException{
        HttpURLConnection c = connection.getConnection();
        c.setDoInput(true);
        c.setRequestProperty("Content-Type", "application/json");
        c.setRequestProperty("Accept", "application/json");
        c.setRequestMethod("POST");
        System.out.println("CONFIGUROU REQUISIÇÃO POST");

    }

    @Override
    public JSONObject send() throws IOException, JSONException {
        OutputStreamWriter wr = new OutputStreamWriter(connection.getConnection().getOutputStream());
        wr.write(args.toString());
        wr.flush();
        System.out.println("ENVIOU JSON!!!!!!!");

        return connection.getResponse();

    }
}
