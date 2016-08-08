package io.github.vmvini.exerciciopdm.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by vmvini on 07/08/16.
 */
public class GetResponse  implements Response {

    private URL url;

    public GetResponse(URL url){
        this.url = url;
    }

    public InputStream getInputStream()  throws IOException{
        return url.openStream();
    }

}
