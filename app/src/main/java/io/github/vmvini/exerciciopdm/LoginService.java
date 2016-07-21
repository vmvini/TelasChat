package io.github.vmvini.exerciciopdm;

/**
 * Created by vmvini on 21/07/16.
 */
public class LoginService {

    public static void login(String pass) throws IncorrectPasswordException{
        if( !"123456".equals(pass) ){
            throw new IncorrectPasswordException("Senha incorreta!");
        }
        return;

    }

}
