package com.bignerdranch.android.safari_rushhour;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Scanner;

public class LevelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
       /* Figure[][] levels={{new Figure(getBaseContext(),'x',2,2,R.mipmap.blue,"v",2)},
        {new Figure(getBaseContext(),'x',2,2,R.mipmap.blue,"v",2)},
        {new Figure(getBaseContext(),'x',2,2,R.mipmap.blue,"v",2)},
        {new Figure(getBaseContext(),'x',2,2,R.mipmap.blue,"v",2)},
        {new Figure(getBaseContext(),'x',2,2,R.mipmap.blue,"v",2)}};*/


        final Button[] buttons={(Button)findViewById(R.id.button1),
        (Button)findViewById(R.id.button2),(Button)findViewById(R.id.button3),
        (Button)findViewById(R.id.button4),(Button)findViewById(R.id.button5),
        (Button)findViewById(R.id.button6),(Button)findViewById(R.id.button7),
        (Button)findViewById(R.id.button8),(Button)findViewById(R.id.button9),
        (Button)findViewById(R.id.button10),(Button)findViewById(R.id.button11),
        (Button)findViewById(R.id.button12),(Button)findViewById(R.id.button13),
        (Button)findViewById(R.id.button14),(Button)findViewById(R.id.button15)};

        final Intent i=new Intent(LevelActivity.this, Menu.class);
        for (int k=0;k<15;k++) {
            final int b=new Scanner(buttons[k].getText().toString()).nextInt();
            buttons[k].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent j=new Intent(LevelActivity.this, MainActivity.class);
                    j.putExtra("number",b);
                    startActivity(j);
                }
            });

        }
    }
}
