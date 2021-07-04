package com.amarmane.pgfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.amarmane.pgfinder.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPGActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pgactivity);

        auth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                auth.signOut();
                Intent intent = new Intent(RegisterPGActivity.this, SignInActivity.class);
                startActivity(intent);
                break;
            case R.id.register:
                Intent register = new Intent(RegisterPGActivity.this, RegisterPGActivity.class);
                startActivity(register);
                break;
            case R.id.profile:
                Toast.makeText(this, "Profile Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home:
                Intent home = new Intent(RegisterPGActivity.this, MainActivity.class);
                startActivity(home);
                break;
        }
        return true;
    }
}