package io.github.vmvini.exerciciopdm;

import android.content.Intent;
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

    //serviço para pegar usuarios
    private Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        users = new Users();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        gridView = (GridView) findViewById(R.id.second_contacts);

        gridView.setAdapter(new ContactsAdapter(this, users));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               User user = users.getUsers().get(position);
                showChat(user);

            }
        });


    }

    @Override
    public void showChat(User user) {
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        intent.putExtra("user", user );
        startActivity(intent);
    }
}

