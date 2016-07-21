package io.github.vmvini.exerciciopdm;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by vmvini on 21/07/16.
 */
public class ThirdActivity extends AppCompatActivity {

    private ListView messagesContainer;
    private ChatAdapter chatAdapter;
    private TextView username;
    private TextView usericon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);

         messagesContainer = (ListView) findViewById(R.id.chat_messages);
        User user = (User) getIntent().getSerializableExtra("user");

        username = (TextView) findViewById(R.id.chat_username);
        usericon = (TextView) findViewById(R.id.chat_usericon);

        GradientDrawable gd = (GradientDrawable)usericon.getBackground();
        gd.setColor(getResources().getColor(R.color.white));

        LinearLayout ll = (LinearLayout)findViewById(R.id.chat_header);
        ll.setBackgroundColor(getResources().getColor(user.getColor()));

        usericon.setTextColor(getResources().getColor(R.color.black));

        username.setText(user.getName());
        usericon.setText(user.getAbrev());


        loadChat(user);

    }

    private void loadChat(User user){
        Users users = new Users();
        Chat chat = users.getChat(user);

        chatAdapter = new ChatAdapter(ThirdActivity.this, chat);

        messagesContainer.setAdapter(chatAdapter);

        /*for(int i = 0; i < chat.getMensagens().size(); i++){
            chatAdapter.addMessage(chat.getMensagens().get(i));
            chatAdapter.notifyDataSetChanged();
            messagesContainer.setSelection(messagesContainer.getCount() - 1);
        }*/


    }
}
