package io.github.vmvini.exerciciopdm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vmvini on 20/07/16.
 */
public class Users {

    private User eu, anamaria, joao, mariana;
    private List<User> users;

    public Users(){

        eu = new User();
        eu.setName("Marcus Vinícius");
        anamaria = new User();
        anamaria.setName("Ana Maria");
        joao = new User();
        joao.setName("João Pedro");
        mariana = new User();
        mariana.setName("Mariana");





        users = new ArrayList<User>();

        users.add(anamaria);
        users.add(joao);
        users.add(mariana);


    }

    public List<User> getUsers(){
        return users;
    }

    public Chat getChat(User user2){
        Chat chat = new Chat();
        if(user2.getName().equals("Ana Maria")){
            chat.addMensagem("Tudo bem?", anamaria );
            chat.addMensagem("estou bem, e vc?", eu);
            chat.addMensagem("to ótima", anamaria);
        }
        else if(user2.getName().equals("João Pedro")){
            chat.addMensagem("Assistiu o novo episodio de dbs", joao );
            chat.addMensagem("assisti ainda nao. como foi?", eu);
            chat.addMensagem("massa demais", joao);
        }
        else if(user2.getName().equals("Mariana")){
            chat.addMensagem("ola", joao );
            chat.addMensagem("oi", eu);
            chat.addMensagem("gostaria de saber se você encontrou aquele site", joao);
        }

        return chat;

    }

}
