package io.github.vmvini.exerciciopdm;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import httpclient.JsonPostClient;

/**
 * Created by vmvini on 21/07/16.
 */
public class ChatAdapter extends BaseAdapter {

    private Chat chat;

    private Context context;
    private User loggedUser;

    public ChatAdapter(Context context, Chat chat, User loggedUser){
        this.chat = chat;
        this.context = context;
        this.loggedUser = loggedUser;
    }

    @Override
    public int getCount() {
        if (chat.getMessages() != null) {
            return chat.getMessages().size();
        } else {
            return 0;
        }
    }

    @Override
    public Mensagem getItem(int position) {
        if (chat.getMessages() != null) {
            return chat.getMessages().get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View view;
        Mensagem msg = getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //view = new View(context);
        view = inflater.inflate(R.layout.chat_messages, null);

        MessageView mv = createViewHolder(view);


        setAlignment(mv, msg);
        mv.msgContent.setText(msg.getMessage());

        return view;

    }


    public void addMessage(Mensagem msg){

       // chat.addMensagem(msg.getMensagem(), msg.getUser());

        //adicionando ao user (estrutura de documento)
        //loggedUser.getChat( chat.getUser() ).addMensagem(msg.getMensagem(), msg.getUser());
        //JsonPostClient jpc = new JsonPostClient(loggedUser);
       // jpc.start();
    }

    private static class MessageView {
        public TextView msgContent;

        public LinearLayout rootBubble;
        public LinearLayout bubble;
    }

    private MessageView createViewHolder(View view) {
        MessageView holder = new MessageView();
        holder.msgContent = (TextView) view.findViewById(R.id.chat_message_content);

        holder.bubble = (LinearLayout) view.findViewById(R.id.chat_message_bubble);
        holder.rootBubble = (LinearLayout) view.findViewById(R.id.chat_root_message);
        return holder;
    }

    private void setAlignment(MessageView holder, Mensagem m){

        //se for mensagem enviada por usuario logado
        //System.out.println("USUARIO LOGADO: " + loggedUser.getName());
        //System.out.println("CONTATO: " + m.getUser().getName());
        if(m.getFrom().get_id().equals(loggedUser.get_id())){
            holder.bubble.setBackgroundResource(R.drawable.my_message);

            LinearLayout.LayoutParams layoutParams =
                    (LinearLayout.LayoutParams) holder.bubble.getLayoutParams();
            layoutParams.gravity = Gravity.RIGHT;
            holder.bubble.setLayoutParams(layoutParams);

            RelativeLayout.LayoutParams lp =
                    (RelativeLayout.LayoutParams) holder.rootBubble.getLayoutParams();
            lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 0);
            lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            holder.rootBubble.setLayoutParams(lp);
            layoutParams = (LinearLayout.LayoutParams) holder.msgContent.getLayoutParams();
            layoutParams.gravity = Gravity.RIGHT;
            holder.msgContent.setLayoutParams(layoutParams);

        }
        else{
            holder.bubble.setBackgroundResource(R.drawable.other_message);

            LinearLayout.LayoutParams layoutParams =
                    (LinearLayout.LayoutParams) holder.bubble.getLayoutParams();
            layoutParams.gravity = Gravity.LEFT;
            holder.bubble.setLayoutParams(layoutParams);

            RelativeLayout.LayoutParams lp =
                    (RelativeLayout.LayoutParams) holder.rootBubble.getLayoutParams();
            lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
            lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            holder.rootBubble.setLayoutParams(lp);
            layoutParams = (LinearLayout.LayoutParams) holder.msgContent.getLayoutParams();
            layoutParams.gravity = Gravity.LEFT;
            holder.msgContent.setLayoutParams(layoutParams);

        }


    }



}
