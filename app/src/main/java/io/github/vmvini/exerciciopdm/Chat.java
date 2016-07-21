package io.github.vmvini.exerciciopdm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vmvini on 20/07/16.
 */
public class Chat {

    private List<Mensagem> mensagens;

    public Chat(){
        mensagens = new ArrayList<Mensagem>();
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
