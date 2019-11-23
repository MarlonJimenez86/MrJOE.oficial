package com.example.mrjoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_registrese extends AppCompatActivity {

    Button btnCreaUs;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrese);

        mAuth = FirebaseAuth.getInstance();
        btnCreaUs = (Button) findViewById(R.id.btnCreaUs);

        /*btnCreaUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btnCreaUs = new Intent(Login_Activity.this, MainActivity.class);
                startActivity(btnCreaUs);
            }
        });*/

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void btn_ingreso(View view) {

        String email = ((EditText) findViewById(R.id.TxtEmail)).getText().toString();
        String password = ((EditText) findViewById(R.id.TxtPass)).getText().toString();

        if (email == null && email.isEmpty()) {
            Toast.makeText(this, "Correo Invalido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password == null && password.isEmpty()) {
            Toast.makeText(this, "Password vacio ", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("registrese", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent btnCreaUs = new Intent(activity_registrese.this, MainActivity.class);
                            startActivity(btnCreaUs);
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("registrese", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(activity_registrese.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
}
