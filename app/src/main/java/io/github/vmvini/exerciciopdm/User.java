package io.github.vmvini.exerciciopdm;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vmvini on 20/07/16.
 */

public class User implements Serializable {

    private String name;

    private List<Chat> chats;

    private List<User> users;

    public void setUsers(List<User> users){
        this.users = users;

    }

    public Chat getChat(User user){
        for(int i = 0; i < chats.size(); i++){
            if(chats.get(i).getUser().getName().equals(user.getName())){
                return chats.get(i);
            }
        }
        return null;
    }

    public String getLastMessage(User user){
        Chat c = getChat(user);
        if(c == null)
            return "";
        return c.getLastMessage().getResumida();
    }

    public List<User> getUsers(){
        return users;
    }

    public void setChats(List<Chat> chats){
        this.chats = chats;
    }

    public List<Chat> getChats(){
        return chats;
    }

    private int color;

    public User(){
        UserColor uc = new UserColor();
        color = uc.random();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }

    public String getAbrev(){
        return getNCharacters(name, 2);
    }

    private String getNCharacters(String word, int q){
        return word.substring(0, Math.min(word.length(), q));
    }

    public int getColor(){
        return color;
    }




}
