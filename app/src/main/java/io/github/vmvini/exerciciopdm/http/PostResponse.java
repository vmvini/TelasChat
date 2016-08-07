package io.github.vmvini.exerciciopdm.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * Created by vmvini on 07/08/16.
 */
public class PostResponse implements Response {

    private HttpURLConnection connection;

    public PostResponse(HttpURLConnection connection){
        this.connection = connection;
    }

    public InputStream getInputStream() throws IOException{
        return connection.getInputStream();
    }

}
