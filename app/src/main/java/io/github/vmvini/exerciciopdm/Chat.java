package io.github.vmvini.exerciciopdm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vmvini on 20/07/16.
 */
public class Chat implements Serializable {

    private List<Mensagem> mensagens;

    private User user;

    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return user;
    }

    public Chat(){
        mensagens = new ArrayList<Mensagem>();
    }

    public void setMensagens(List<Mensagem> mensagens){
        this.mensagens = mensagens;
    }

    public void addMensagem(String msg, User remetente){
        Mensagem m = new Mensagem();
        m.setMensagem(msg);
        m.setUser(remetente);
        this.mensagens.add(m);
    }

    public Mensagem getLastMessage(){
        int length = mensagens.size();
        return mensagens.get(length - 1);
    }

    public List<Mensagem> getMensagens(){
        return Collections.unmodifiableList(mensagens);
    }

}
