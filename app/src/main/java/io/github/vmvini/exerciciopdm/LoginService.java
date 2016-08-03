package io.github.vmvini.exerciciopdm;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import httpclient.JsonClient;
import httpclient.JsonRequest;

/**
 * Created by vmvini on 21/07/16.
 */
public class LoginService {

    private JsonClient jsonClient;

    public static void login(String pass) throws Exception{

        JsonRequest jr = new JsonRequest("http://10.0.2.2:3000/login?password=" + pass);
        jr.start();
        while(jr.getJSONObject() == null && jr.getException() == null){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
               throw e;
            }
        }
        if(jr.getJSONObject() != null){
            try{
                JSONObject resp = jr.getJSONObject();

                System.out.println("RESPOSTA!!!" + resp.getString("success"));
                if( resp.getString("success").equals("false") ){
                    throw new IncorrectPasswordException("Senha incorreta!");
                }
                return;
            }
            catch(JSONException e){
                throw e;
            }
        }

        if(jr.getException() != null){
            throw jr.getException();
        }

    }

}
