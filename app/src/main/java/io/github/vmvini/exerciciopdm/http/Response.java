package io.github.vmvini.exerciciopdm.http;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by vmvini on 07/08/16.
 */
public interface Response {

    InputStream getInputStream()  throws IOException;

}
