package com.bignerdranch.android.safari_rushhour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button level=(Button)findViewById(R.id.buttonlv);
        Button help=(Button)findViewById(R.id.buttonhelp);
        Button exit=(Button)findViewById(R.id.buttonex);
        final ImageView rule=(ImageView)findViewById(R.id.imagerule);
        final Button play=(Button)findViewById(R.id.buttonpl);

        level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Menu.this,LevelActivity.class);
                startActivity(i);
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rule.setVisibility(View.VISIBLE);
            }
        });
        rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rule.setVisibility(View.INVISIBLE);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Menu.this,MainActivity.class);
                i.putExtra("number",1);
                startActivity(i);
            }
        });
    }
}