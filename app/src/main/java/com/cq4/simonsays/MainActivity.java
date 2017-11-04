package com.cq4.simonsays;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView green_dino, blue_dino, yellow_dino, red_dino;
    private ImageButton button_play;
    private Button button_green, button_blue, button_yellow, button_red;

    final Animation lightup = new AlphaAnimation(0,1);
    final Animation lightup1 = new AlphaAnimation(0,1);
    final Animation lightup2 = new AlphaAnimation(0,1);
    final Animation lightup3 = new AlphaAnimation(0,1);


    static Handler handler;

    final Random random = new Random();

    private LinkedList<ImageView> flashes;

    private int itterateImages = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = (TextView) findViewById(R.id.textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/bromo.otf");
        myTextView.setTypeface(typeface);

        green_dino = findViewById(R.id.green_dino);
        blue_dino = findViewById(R.id.blue_dino);
        yellow_dino = findViewById(R.id.yellow_dino);
        red_dino = findViewById(R.id.red_dino);
        button_play = findViewById(R.id.button_play);
        button_green = findViewById(R.id.button_green);
        button_blue = findViewById(R.id.button_blue);
        button_yellow = findViewById(R.id.button_yellow);
        button_red = findViewById(R.id.button_red);
        handler = new Handler();
        green_dino.setVisibility(View.INVISIBLE);
        blue_dino.setVisibility(View.INVISIBLE);
        yellow_dino.setVisibility(View.INVISIBLE);
        red_dino.setVisibility(View.INVISIBLE);
        button_green.setVisibility(View.INVISIBLE);
        button_blue.setVisibility(View.INVISIBLE);
        button_yellow.setVisibility(View.INVISIBLE);
        button_red.setVisibility(View.INVISIBLE);
        lightup.setDuration(1000);
        lightup1.setDuration(1000);
        lightup2.setDuration(1000);
        lightup3.setDuration(1000);

    }
    public LinkedList<ImageView> startAnimations(int n) {
        final ArrayList<ImageView> img = new ArrayList<>();
        img.add(green_dino);
        img.add(blue_dino);
        img.add(yellow_dino);
        img.add(red_dino);

        final LinkedList<ImageView> imghold = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            final int r = random.nextInt(n);
            imghold.add(img.get(r));

            if (img.get(r).equals(green_dino)){

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        green_dino.startAnimation(lightup);
                    }
                }, 1000 * i);
            } else if (img.get(r).equals(blue_dino)){
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        blue_dino.startAnimation(lightup1);
                    }
                }, 1000 * i);

            } else if (img.get(r).equals(yellow_dino)){
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        yellow_dino.startAnimation(lightup2);
                    }
                }, 1000 * i);

            } else if (img.get(r).equals(red_dino)){
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        red_dino.startAnimation(lightup3);
                    }
                }, 1000 * i);

            }
        }

        return imghold;
    }

    public void buttonPress(View v) {

        if (v == button_play) {
            flashes = new LinkedList<>();
            itterateImages = 0;
            flashes = gameStart(3);
            button_play.setVisibility(View.INVISIBLE);
            button_green.setVisibility(View.VISIBLE);
            button_blue.setVisibility(View.VISIBLE);
            button_yellow.setVisibility(View.VISIBLE);
            button_red.setVisibility(View.VISIBLE);
        } else if (v == button_green){
            v.startAnimation(lightup);
            colorCheck("green");
        } else if (v == button_blue){
            v.startAnimation(lightup1);
            colorCheck("blue");
        } else if (v == button_yellow){
            v.startAnimation(lightup2);
            colorCheck("yellow");
        }else if (v == button_red){
            v.startAnimation(lightup3);
            colorCheck("red");
        }
    }

    public LinkedList<ImageView> gameStart(int n){
        LinkedList<ImageView> img = startAnimations(n);
        for (int i = 0; i < img.size(); i++) {
            if (img.get(i).equals(green_dino)) {
                System.out.println("green");
            } else if (img.get(i).equals(blue_dino)) {
                System.out.println("blue");
            } else if (img.get(i).equals(yellow_dino)) {
                System.out.println("yellow");
            } else if (img.get(i).equals(red_dino)) {
                System.out.println("red");
            }
        }
        return img;

    }

    public void colorCheck(String v){
        if (v.equals("green")){
            try {
                if (flashes.get(itterateImages).equals(green_dino)) {
                    Toast.makeText(MainActivity.this, "correct " + (itterateImages + 1), Toast.LENGTH_SHORT).show();
//                    button_play.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(MainActivity.this, "incorrect " + (itterateImages + 1), Toast.LENGTH_SHORT).show();
                }
                itterateImages++;

            }catch (IndexOutOfBoundsException e){

            }

        }else if (v.equals("blue")){
            try {
                if (flashes.get(itterateImages).equals(blue_dino)) {
                    Toast.makeText(MainActivity.this, "correct " + (itterateImages + 1), Toast.LENGTH_SHORT).show();
//                    button_play.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(MainActivity.this, "incorrect " + (itterateImages + 1), Toast.LENGTH_SHORT).show();
                }
                itterateImages++;

            }catch (IndexOutOfBoundsException e){

            }
        }else if (v.equals("yellow")){
            try {
                if (flashes.get(itterateImages).equals(yellow_dino)) {
                    Toast.makeText(MainActivity.this, "correct " + (itterateImages + 1), Toast.LENGTH_SHORT).show();
//                    button_play.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(MainActivity.this, "incorrect " + (itterateImages + 1), Toast.LENGTH_SHORT).show();
                }
                itterateImages++;

            }catch (IndexOutOfBoundsException e){

            }
        }else if (v.equals("red")){
            try {
                if (flashes.get(itterateImages).equals(red_dino)) {
                    Toast.makeText(MainActivity.this, "correct " + (itterateImages + 1), Toast.LENGTH_SHORT).show();
//                    button_play.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(MainActivity.this, "incorrect " + (itterateImages + 1), Toast.LENGTH_SHORT).show();
                }
                itterateImages++;

            }catch (IndexOutOfBoundsException e){

            }
        }

        if(itterateImages == flashes.size()) {
            button_play.setVisibility(View.VISIBLE);
        }

    }


}
