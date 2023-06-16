package com.wolf.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wolf.login.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> {
            String user = binding.user.getText().toString();
            String password = binding.password.getText().toString();

            if (user.equals("Mario14") && password.equals("isof21")) {
                Intent intent = new Intent(this, MainMenu.class);
                startActivity(intent);
                Toast.makeText(this, getString(R.string.welcome) + user, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show();
            }

        });
    }
}