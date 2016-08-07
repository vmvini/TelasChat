package io.github.vmvini.exerciciopdm;

/**
 * Created by vmvini on 21/07/16.
 */
public interface LoginPresenter {

    String getPassword() throws  NoPasswordException;

    String getName() throws NoPasswordException;

    void erasePassword();

    void login(String name, String password) throws IncorrectPasswordException;

    void showResponse(String msg);

}
