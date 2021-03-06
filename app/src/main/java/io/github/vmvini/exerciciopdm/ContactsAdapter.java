package io.github.vmvini.exerciciopdm;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import io.github.vmvini.exerciciopdm.services.GenericClient;
import io.github.vmvini.exerciciopdm.services.LastMessageClient;

/**
 * Created by vmvini on 21/07/16.
 */
public class ContactsAdapter extends BaseAdapter {

    private UserContacts loggedUser;
    private Activity context;

    private GenericClient lastMessageService;

    public ContactsAdapter(Activity context, UserContacts loggedUser){
        this.loggedUser = loggedUser;

        this.context = context;
    }


    @Override
    public int getCount() {
        return loggedUser.getContacts().size();
    }

    @Override
    public Object getItem(int position) {
        return loggedUser.getContacts().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
            //gerando gridView
            gridView = new View(context);
            gridView = inflater.inflate(R.layout.user_contacts, null);
            User u = (User)getItem(position);

            //setando nome do contato
            TextView textView = (TextView) gridView.findViewById(R.id.contacts_username);
            textView.setText(getItem(position).toString());

            //setando icone do contato
            TextView textView2 = (TextView) gridView.findViewById(R.id.contacts_usericon);
            GradientDrawable ld = (GradientDrawable)textView2.getBackground();
            ld.setColor(context.getResources().getColor(u.getColor()));


            textView2.setText(u.getAbrev());

            //setando ultima mensagem do chat
            TextView textView3 = (TextView) gridView.findViewById(R.id.contacts_lastMessage);
            //textView3.setText(loggedUser.getLastMessage(u));
            //textView3.setText("teste");

            lastMessageService = new LastMessageClient(context, loggedUser.getUser(), u, textView3);
            lastMessageService.start();


        return gridView;
    }



}
