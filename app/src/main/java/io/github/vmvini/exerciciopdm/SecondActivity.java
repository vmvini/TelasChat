package io.github.vmvini.exerciciopdm;

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
public class SecondActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        gridView = (GridView) findViewById(R.id.second_contacts);

        gridView.setAdapter(new ContactsAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) view.findViewById(R.id.contacts_username)).getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}

