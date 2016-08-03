package io.github.vmvini.exerciciopdm;

/**
 * Created by vmvini on 21/07/16.
 */
public interface LoginPresenter {

    String getPassword() throws  NoPasswordException;

    void erasePassword();

    void login(String password) throws Exception;

    void showResponse(String msg);

}
