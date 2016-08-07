package io.github.vmvini.exerciciopdm;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import httpclient.JsonPostClient;
import httpclient.SendMessageClient;

/**
 * Created by vmvini on 21/07/16.
 */
public class ThirdActivity extends AppCompatActivity implements ChatPresenter {

    private ListView messagesContainer;
    private ChatAdapter chatAdapter;
    private TextView username;
    private TextView usericon;
    private Chat chat;
    private User loggedUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);

         messagesContainer = (ListView) findViewById(R.id.chat_messages);
        chat = (Chat) getIntent().getSerializableExtra("chat");
        loggedUser = (User) getIntent().getSerializableExtra("LoggedUser");

        username = (TextView) findViewById(R.id.chat_username);
        usericon = (TextView) findViewById(R.id.chat_usericon);

        GradientDrawable gd = (GradientDrawable)usericon.getBackground();
        gd.setColor(getResources().getColor(R.color.white));

        LinearLayout ll = (LinearLayout)findViewById(R.id.chat_header);
        ll.setBackgroundColor(getResources().getColor(chat.getUser().getColor()));

        usericon.setTextColor(getResources().getColor(R.color.black));

        username.setText(chat.getUser().getName());
        usericon.setText(chat.getUser().getAbrev());


        Button button = (Button)findViewById(R.id.chat_send_message_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(getTypedMessage());
            }
        });

        loadChat(chat);

    }

    @Override
    public Mensagem getTypedMessage(){
        EditText et = (EditText)findViewById(R.id.chat_sendmsg);
        Mensagem nova = new Mensagem();

        nova.setMensagem(et.getText().toString());

        //setando remetente
        User eu = new User();
        eu.setName(loggedUser.getName());
        nova.setUser(eu);

        return nova;
    }

    @Override
    public void sendMessage(Mensagem m){
        if(!m.getMensagem().isEmpty()){
            chatAdapter.addMessage(m);
            //SendMessageClient smc = new SendMessageClient(this, loggedUser);
            //smc.start();

        }

    }


    private void loadChat(Chat chat){
        //Users users = new Users();
        //Chat chat = users.getChat(user);

        chatAdapter = new ChatAdapter(ThirdActivity.this, chat, loggedUser);

        messagesContainer.setAdapter(chatAdapter);

        /*for(int i = 0; i < chat.getMensagens().size(); i++){
            chatAdapter.addMessage(chat.getMensagens().get(i));
            chatAdapter.notifyDataSetChanged();
            messagesContainer.setSelection(messagesContainer.getCount() - 1);
        }*/


    }
}
