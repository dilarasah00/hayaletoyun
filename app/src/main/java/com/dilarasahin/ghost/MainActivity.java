package com.dilarasahin.ghost;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void basla(View view){
        Intent intent = new Intent(getApplicationContext(),ghost2.class);
        startActivity(intent);
    }
    public void nasil(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("NASIL OYNANIR?");
        alert.setMessage("Belirtilen sürede ekranda farklı yerlerde gösterilen hayaletleri yakalamaya çalışıcaksınız. Her yakaladığınız hayalet skor tablonuza eklenicek.");
        alert.setPositiveButton("KAPAT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();

    }

}
