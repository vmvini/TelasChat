package io.github.vmvini.exerciciopdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginPresenter {

    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.signin);
        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                try{
                    login(getPassword());
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
                catch(NoPasswordException | IncorrectPasswordException e){
                    showResponse(e.getMessage());
                }
            }
        });
    }

    @Override
    public void showResponse(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getPassword() throws NoPasswordException {
        password = (EditText) findViewById(R.id.password);
        Editable e = password.getText();
        if(e.toString().isEmpty()){
           throw new NoPasswordException("Digite sua senha");
        }

        return password.getText().toString();

    }

    @Override
    public void login(String password) throws IncorrectPasswordException{

            LoginService.login(password);

    }

    @Override
    public void erasePassword(){
        password.setText("");
    }
}
