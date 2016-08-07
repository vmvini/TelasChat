package io.github.vmvini.exerciciopdm.http;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by vmvini on 07/08/16.
 */
public interface Request {

    JSONObject send() throws IOException, JSONException;
}
