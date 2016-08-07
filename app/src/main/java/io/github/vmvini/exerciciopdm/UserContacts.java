package io.github.vmvini.exerciciopdm;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vmvini on 06/08/16.
 */
public class UserContacts implements Serializable {

    private User user;

    private List<User> contacts;

    public UserContacts(){

    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public void setContacts(List<User> contacts){
        this.contacts = contacts;
    }

    public List<User> getContacts(){
        return contacts;
    }

    public void addContact(User contact){
        contacts.add(contact);
    }



}
