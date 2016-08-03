package httpclient;

import org.json.JSONObject;

import io.github.vmvini.exerciciopdm.ContactsAdapter;
import io.github.vmvini.exerciciopdm.SecondActivity;

/**
 * Created by vmvini on 03/08/16.
 */
public class ContactsClient extends JsonClient {

    public ContactsClient(SecondActivity activity){
        super("http://10.0.2.2:3000/contacts", activity);
    }

    @Override
    public void custom(JSONObject json) {

    }
}
