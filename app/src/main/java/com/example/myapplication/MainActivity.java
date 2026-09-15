package com.example.myapplication;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editName = findViewById(R.id.name);
    EditText editSurname = findViewById(R.id.surname);
    EditText editEmail = findViewById(R.id.email);
    EditText editPassword = findViewById(R.id.password);
    Button btnRegister = findViewById(R.id.registerBtn);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnRegister.setOnClickListener(v -> {
            if (!checkValues()) {
                return;
            }

            if (!checkEmail()) {
                return;
            }

            if (!checkPassword()) {
                return;
            }

            Toast.makeText(
                    this,
                    "Dane są poprawne!",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }

    private boolean checkValues(){
            String name = editName.getText().toString().trim();
            String surname = editSurname.getText().toString().trim();
            String email = editEmail.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            if(name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(
                        this,
                        "Uzupełnij pola",
                        Toast.LENGTH_SHORT
                ).show();
                return false;
            }
            return true;
        }

    private boolean checkEmail(){
        String email = editEmail.getText().toString().trim();
        if(email.contains("@") || email.contains(".")){
            Toast.makeText(
                    this,
                    "Wpisz poprawny email!",
                    Toast.LENGTH_SHORT
            ).show();
            return false;
        }
        return true;
    }

    private boolean checkPassword(){
        String password = editPassword.getText().toString().trim();

        if(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8}$")){
            return true;
        };
        return false;
    }


}