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

import java.util.ArrayList;

import io.github.vmvini.exerciciopdm.services.GenericClient;
import io.github.vmvini.exerciciopdm.services.LoadChatClient;

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
    private User contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);

         messagesContainer = (ListView) findViewById(R.id.chat_messages);

        //usuarios do chat
        loggedUser = (User) getIntent().getSerializableExtra("loggedUser");
        contact = (User) getIntent().getSerializableExtra("contact");


        username = (TextView) findViewById(R.id.chat_username);
        usericon = (TextView) findViewById(R.id.chat_usericon);

        GradientDrawable gd = (GradientDrawable)usericon.getBackground();
        gd.setColor(getResources().getColor(R.color.white));

        LinearLayout ll = (LinearLayout)findViewById(R.id.chat_header);
        ll.setBackgroundColor(getResources().getColor(contact.getColor()));

        usericon.setTextColor(getResources().getColor(R.color.black));

        username.setText(contact.getName());
        usericon.setText(contact.getAbrev());


        Button button = (Button)findViewById(R.id.chat_send_message_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(getTypedMessage());
            }
        });

        chat = new Chat();
        chat.setUser1(loggedUser);
        chat.setUser2(contact);
        chat.setMessages(new ArrayList<Mensagem>());

        GenericClient chatService = new LoadChatClient(this, chat );
        chatService.start();
        //loadChat(chat);

    }

    @Override
    public Mensagem getTypedMessage(){
        EditText et = (EditText)findViewById(R.id.chat_sendmsg);
        Mensagem nova = new Mensagem();

        nova.setMessage(et.getText().toString());

        //setando remetente
        nova.setFrom(loggedUser);

        return nova;
    }

    @Override
    public void sendMessage(Mensagem m){
        if(!m.getMessage().isEmpty()){
            System.out.println("chatAdapter");
            System.out.println(chatAdapter);
            chatAdapter.addMessage(m);
            //SendMessageClient smc = new SendMessageClient(this, loggedUser);
            //smc.start();

        }

    }


    public void loadChat(Chat chat){
        //Users users = new Users();
        //Chat chat = users.getChat(user);

        chatAdapter = new ChatAdapter(ThirdActivity.this, chat, loggedUser);

        messagesContainer.setAdapter(chatAdapter);
        System.out.println("chatAdapter construido");

        /*for(int i = 0; i < chat.getMessages().size(); i++){
            System.out.println("mensagem carregada");
            System.out.println(chat.getMessages().get(i).getMessage());
            chatAdapter.addMessage(chat.getMessages().get(i));
            chatAdapter.notifyDataSetChanged();
            messagesContainer.setSelection(messagesContainer.getCount() - 1);
        }*/


    }
}
