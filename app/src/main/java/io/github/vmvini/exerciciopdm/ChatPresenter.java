package io.github.vmvini.exerciciopdm;

/**
 * Created by vmvini on 21/07/16.
 */
public interface ChatPresenter {

    Mensagem getTypedMessage();

    public void sendMessage(Mensagem m);

    void loadChat(Chat chat);

}
