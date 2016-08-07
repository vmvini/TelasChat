package io.github.vmvini.exerciciopdm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vmvini on 20/07/16.
 */

/*
* user1: {type: UserSchema},
	user2: {type: UserSchema},
	messages:[ MessageSchema ]
* */
public class Chat implements Serializable {

    private List<Mensagem> messages;

    private User user1;
    private User user2;

    public void setUser1(User user1){
        this.user1 = user1;
    }
    public User getUser1(){
        return user1;
    }

    public void setUser2(User user2){
        this.user2 = user2;
    }
    public User getUser2(){
        return user2;
    }

    public Chat(){

    }

    public void setMessages(List<Mensagem> messages){
        this.messages = messages;
    }

    public List<Mensagem> getMessages(){
        return Collections.unmodifiableList(messages);
    }

    /*public void addMensagem(String msg, User remetente){
        Mensagem m = new Mensagem();
        m.setMensagem(msg);
        m.setUser(remetente);
        this.mensagens.add(m);
    }*/

    /*
    public Mensagem getLastMessage(){
        int length = mensagens.size();
        return mensagens.get(length - 1);
    }*/




}
