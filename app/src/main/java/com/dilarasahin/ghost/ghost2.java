package com.dilarasahin.ghost;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ghost2 extends AppCompatActivity {
    TextView time;
    TextView scoretext;
    int score;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView[] imagearray;
    Handler handler;
    Runnable runnable;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghost2);
        hide();
        time = findViewById(R.id.textView);
        scoretext = findViewById(R.id.textView2);
        score = 0;
        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);


        imagearray = new ImageView[]{imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8};
        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("Time: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                time.setText("Time off");
                handler.removeCallbacks(runnable);
                for(ImageView image: imagearray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(ghost2.this);
                alert.setTitle("Restart");
                alert.setMessage("Are you sure to restart game?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ghost2.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();


            }
        }.start();
    }
    public void myghost(View view){
        score++;
        scoretext.setText("Score: "+score);


    }
    public  void hide(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image: imagearray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int numb = random.nextInt(9);
                imagearray[numb].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);

            }
        };
        handler.post(runnable);

    }




}
