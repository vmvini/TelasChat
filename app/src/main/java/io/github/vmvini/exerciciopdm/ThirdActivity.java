package io.github.vmvini.exerciciopdm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by vmvini on 21/07/16.
 */
public class ThirdActivity extends AppCompatActivity {

    private ListView messagesContainer;
    private ChatAdapter chatAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);

         messagesContainer = (ListView) findViewById(R.id.chat_messages);
        User user = (User) getIntent().getSerializableExtra("user");
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
