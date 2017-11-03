package com.cq4.simonsays;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView green_dino, blue_dino, yellow_dino, red_dino;
    private ImageButton button_play;

    final Animation lightup = new AlphaAnimation(1,0);

    static Handler handler;

    final Random random = new Random();

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
        handler = new Handler();
        lightup.setDuration(1000);

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

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    img.get(r).startAnimation(lightup);
                }
            }, 1000 * i);
        }
        return imghold;
    }

    public void buttonPress(View v) {

        if (v == button_play) {

            LinkedList<ImageView> img = startAnimations(3);
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


        }
    }


}
