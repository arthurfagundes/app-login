package br.ulbra.applogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity {
    EditText edNome,edUser,edPas1,edPas2;
    Button btSalvar;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        db = new DBHelper(this);

        edNome = findViewById(R.id.edtregnome);
        edUser = findViewById(R.id.edtlogin);
        edPas1 = findViewById(R.id.edtregpass);
        edPas2 = findViewById(R.id.edtregpass1);

        btSalvar = findViewById(R.id.btsalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edUser.getText().toString();
                String pas1 = edPas1.getText().toString();
                String pas2 = edPas2.getText().toString();
                if (userName.equals("")){
                    Toast.makeText(RegistrarActivity.this, "Insira o LOGIN DO USUÁRIO", Toast.LENGTH_SHORT).show();
                }else if (pas1.equals("") || pas2.equals("")){
                    Toast.makeText(RegistrarActivity.this, "Insira a SENHA DO USUÁRIO", Toast.LENGTH_SHORT).show();
                }else if (!pas1.equals(pas2)){
                    Toast.makeText(RegistrarActivity.this, "As senhas não correspondem ao login do usuário", Toast.LENGTH_SHORT).show();
                }else {
                    long res = db.criarUtilizador(userName,pas1);
                    if(res>0){
                        Toast.makeText(RegistrarActivity.this, "Registro OK", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegistrarActivity.this, "Senha inválida!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
