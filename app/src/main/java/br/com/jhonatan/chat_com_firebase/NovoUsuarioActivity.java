package br.com.jhonatan.chat_com_firebase;



import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.Result;
import com.google.firebase.auth.FirebaseAuth;

import br.com.jhonatan.chat_com_firebase.R;

public class NovoUsuarioActivity extends AppCompatActivity {

    private EditText loginNovoUsuarioEditText;
    private EditText senhaNovoUsuarioEditText;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);
        loginNovoUsuarioEditText =
                findViewById(R.id.loginNovoUsuarioEditText);
        senhaNovoUsuarioEditText =
                findViewById(R.id.senhaNovoUsuarioEditText);
        auth = FirebaseAuth.getInstance();
    }

    public void criarNovoUsuario (View view){
        String login = loginNovoUsuarioEditText.getEditableText().toString();
        String senha = senhaNovoUsuarioEditText.getEditableText().toString();
        auth.createUserWithEmailAndPassword(login, senha).addOnSuccessListener((result) -> {
            Toast.makeText(this, result.getUser().getEmail(), Toast.LENGTH_SHORT).show();
            finish();
        }).addOnFailureListener((error -> error.printStackTrace()));
    }
}



