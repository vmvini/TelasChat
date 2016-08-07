package io.github.vmvini.exerciciopdm;

import android.content.Intent;
import android.content.pm.InstrumentationInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vmvini on 20/07/16.
 */
public class SecondActivity extends AppCompatActivity implements ContactsPresenter {

    private GridView gridView;

    private UserContacts loggedUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        //setando usuario logado
        loggedUser = (UserContacts) getIntent().getSerializableExtra("loggedUser");
        TextView username = (TextView) findViewById(R.id.second_logged_username);
        username.setText(loggedUser.getUser().getName());


        gridView = (GridView) findViewById(R.id.second_contacts);



        //fazer isso com ContactsClient
        gridView.setAdapter(new ContactsAdapter(this, loggedUser));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //User user = users.getUsers().get(position);
                // showChat(user);
                /*User contact = user.getUsers().get(position);
                Chat chat = user.getChat(contact);
                chat.setUser(contact);
                showChat(chat);*/

            }
        });


    }

    public void showChat(Chat chat) {
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        intent.putExtra("chat", chat );
        //intent.putExtra("LoggedUser", user);
        startActivity(intent);
    }
}

