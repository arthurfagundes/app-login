package br.ulbra.applogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edLogin, edPass;
    Button btLogin;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DBHelper(this);
        edLogin = findViewById(R.id.edtlogin);
        edPass = findViewById(R.id.edtpassword);
        btLogin = findViewById(R.id.btentrar);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edLogin.getText().toString();
                String password=edPass.getText().toString();
                if(username.equals("")){
                    Toast.makeText(LoginActivity.this, "Usuário não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                }else if(password.equals("")){
                    Toast.makeText(LoginActivity.this, "Senha não inserida, tente novamente", Toast.LENGTH_SHORT).show();
                }else {
                    String res = db.validarLogin(username,password);
                    if(res.equals("OK")){
                        Toast.makeText(LoginActivity.this, "Login OK!", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(LoginActivity.this, "Login ou senha incorreto!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
