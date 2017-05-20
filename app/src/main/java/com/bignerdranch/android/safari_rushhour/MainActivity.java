package com.bignerdranch.android.safari_rushhour;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Scanner;

import static com.bignerdranch.android.safari_rushhour.R.layout.activity_main;

//213 605 50 445 (56)
public class MainActivity extends AppCompatActivity {

    public void startLevel(int s,EditText et,RelativeLayout l,Figure[][] figures,final LinearLayout lll){
        et.setText(""+s);
        for (Figure[] f:figures) {
            for (Figure g:f) {
                l.removeView(g);
            }
        }
        for (Figure f:figures[s-1]) {
            l.addView(f);
            f.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            },figures[s-1],lll);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        final Figure[][] figures={
                {new Figure(getApplicationContext(),2,5,R.mipmap.j,"m",2),//1
                        new Figure(getApplicationContext(),3,0,R.mipmap.rv,"v",3),
                        new Figure(getApplicationContext(),5,0,R.mipmap.dg,"g",2),new Figure(getApplicationContext(),1,1,R.mipmap.lg,"g",2),
                        new Figure(getApplicationContext(),1,2,R.mipmap.dv,"v",2),new Figure(getApplicationContext(),6,2,R.mipmap.zv,"v",2),
                        new Figure(getApplicationContext(),2,3,R.mipmap.vg,"g",2),new Figure(getApplicationContext(),4,3,R.mipmap.lg,"g",2),
                        new Figure(getApplicationContext(),3,4,R.mipmap.mg,"g",2),new Figure(getApplicationContext(),5,4,R.mipmap.zg,"g",2),
                        new Figure(getApplicationContext(),5,5,R.mipmap.tg,"m",2)},

                {new Figure(getApplicationContext(),4,2,R.mipmap.j,"m",2),//2
                        new Figure(getApplicationContext(),0,1,R.mipmap.tp,"m",2),
                        new Figure(getApplicationContext(),3,1,R.mipmap.rg,"g",3),new Figure(getApplicationContext(),6,1,R.mipmap.ev,"v",3),
                        new Figure(getApplicationContext(),0,3,R.mipmap.ev,"v",3),new Figure(getApplicationContext(),3,2,R.mipmap.ev,"v",3),
                        new Figure(getApplicationContext(),1,3,R.mipmap.dg,"g",2),
                        new Figure(getApplicationContext(),1,4,R.mipmap.dv,"v",2),new Figure(getApplicationContext(),2,4,R.mipmap.mv,"v",2),
                        new Figure(getApplicationContext(),4,4,R.mipmap.rg,"g",3),new Figure(getApplicationContext(),4,5,R.mipmap.mg,"g",2)},

                {new Figure(getApplicationContext(),0,4,R.mipmap.j,"m",2),//3
                        new Figure(getApplicationContext(),4,1,R.mipmap.tp,"m",2),
                        new Figure(getApplicationContext(),3,3,R.mipmap.lv,"v",2),new Figure(getApplicationContext(),1,6,R.mipmap.dg,"g",2),
                        new Figure(getApplicationContext(),3,0,R.mipmap.rv,"v",3),new Figure(getApplicationContext(),0,2,R.mipmap.zv,"v",2),
                        new Figure(getApplicationContext(),5,4,R.mipmap.vg,"g",2),
                        new Figure(getApplicationContext(),2,5,R.mipmap.zg,"g",2),
                        new Figure(getApplicationContext(),4,5,R.mipmap.lg,"g",2),new Figure(getApplicationContext(),3,6,R.mipmap.vg,"g",2)},

                {new Figure(getApplicationContext(),1,3,R.mipmap.j,"m",2),//4
                        new Figure(getApplicationContext(),3,1,R.mipmap.lv,"v",2),
                        new Figure(getApplicationContext(),3,3,R.mipmap.tp,"m",2),new Figure(getApplicationContext(),0,5,R.mipmap.dg,"g",2),
                        new Figure(getApplicationContext(),3,5,R.mipmap.lv,"v",2),new Figure(getApplicationContext(),0,2,R.mipmap.mg,"g",2),
                        new Figure(getApplicationContext(),5,2,R.mipmap.vg,"g",2),
                        new Figure(getApplicationContext(),5,3,R.mipmap.dv,"v",2),
                        new Figure(getApplicationContext(),5,5,R.mipmap.vg,"g",2)},

                {new Figure(getApplicationContext(),1,5,R.mipmap.j,"m",2),//5
                        new Figure(getApplicationContext(),1,2,R.mipmap.rv,"v",3),
                        new Figure(getApplicationContext(),3,2,R.mipmap.lg,"g",2),new Figure(getApplicationContext(),5,2,R.mipmap.ev,"v",3),
                        new Figure(getApplicationContext(),2,2,R.mipmap.zv,"v",2),new Figure(getApplicationContext(),2,4,R.mipmap.rg,"g",3),
                        new Figure(getApplicationContext(),3,3,R.mipmap.lg,"g",2),
                        new Figure(getApplicationContext(),3,5,R.mipmap.eg,"g",3)},

                {new Figure(getApplicationContext(),0,0,R.mipmap.j,"m",2),//6
                        new Figure(getApplicationContext(),5,2,R.mipmap.zg,"g",2),
                        new Figure(getApplicationContext(),3,3,R.mipmap.ev,"v",3),new Figure(getApplicationContext(),3,1,R.mipmap.tp,"m",2),
                        new Figure(getApplicationContext(),4,3,R.mipmap.rv,"v",3),new Figure(getApplicationContext(),1,2,R.mipmap.lg,"g",2),
                        new Figure(getApplicationContext(),2,6,R.mipmap.dg,"g",2),
                        new Figure(getApplicationContext(),4,6,R.mipmap.vg,"g",2),new Figure(getApplicationContext(),3,0,R.mipmap.rg,"g",3)},

                {new Figure(getApplicationContext(),0,5,R.mipmap.j,"m",2),//7
                        new Figure(getApplicationContext(),3,4,R.mipmap.vv,"v",2),
                        new Figure(getApplicationContext(),5,2,R.mipmap.zv,"v",2),new Figure(getApplicationContext(),4,4,R.mipmap.tg,"m",2),
                        new Figure(getApplicationContext(),6,2,R.mipmap.ev,"v",3),new Figure(getApplicationContext(),3,3,R.mipmap.zg,"g",2),
                        new Figure(getApplicationContext(),4,1,R.mipmap.lg,"g",2),
                        new Figure(getApplicationContext(),3,1,R.mipmap.lv,"v",2),new Figure(getApplicationContext(),2,2,R.mipmap.rv,"v",3)},

                {new Figure(getApplicationContext(),0,4,R.mipmap.j,"m",2),//8
                        new Figure(getApplicationContext(),0,0,R.mipmap.tg,"m",2),
                        new Figure(getApplicationContext(),2,0,R.mipmap.zv,"v",2),new Figure(getApplicationContext(),0,2,R.mipmap.eg,"g",3),
                        new Figure(getApplicationContext(),3,2,R.mipmap.tp,"m",2),new Figure(getApplicationContext(),5,2,R.mipmap.dv,"v",2),
                        new Figure(getApplicationContext(),2,4,R.mipmap.vv,"v",2),
                        new Figure(getApplicationContext(),3,4,R.mipmap.eg,"g",3),new Figure(getApplicationContext(),0,6,R.mipmap.rg,"g",3)},

                {new Figure(getApplicationContext(),2,2,R.mipmap.j,"m",2),//9
                        new Figure(getApplicationContext(),3,0,R.mipmap.tp,"m",2),
                        new Figure(getApplicationContext(),5,1,R.mipmap.dv,"v",2),new Figure(getApplicationContext(),0,3,R.mipmap.tg,"m",2),
                        new Figure(getApplicationContext(),5,4,R.mipmap.mg,"g",2),new Figure(getApplicationContext(),4,3,R.mipmap.eg,"g",3),
                        new Figure(getApplicationContext(),1,5,R.mipmap.zg,"g",2),
                        new Figure(getApplicationContext(),4,5,R.mipmap.zv,"v",2),new Figure(getApplicationContext(),3,4,R.mipmap.ev,"v",3)},

                {new Figure(getApplicationContext(),1,3,R.mipmap.j,"m",2),//10
                        new Figure(getApplicationContext(),0,0,R.mipmap.dg,"g",2),
                        new Figure(getApplicationContext(),0,2,R.mipmap.ev,"v",3),new Figure(getApplicationContext(),3,0,R.mipmap.vg,"g",2),
                        new Figure(getApplicationContext(),3,3,R.mipmap.rv,"v",3),new Figure(getApplicationContext(),5,1,R.mipmap.dv,"v",2),
                        new Figure(getApplicationContext(),1,2,R.mipmap.eg,"g",3),
                        new Figure(getApplicationContext(),0,5,R.mipmap.rg,"g",3),new Figure(getApplicationContext(),5,4,R.mipmap.mv,"v",2)},

                {new Figure(getApplicationContext(),1,2,R.mipmap.j,"m",2),//11
                        new Figure(getApplicationContext(),6,3,R.mipmap.zv,"v",2),new Figure(getApplicationContext(),1,1,R.mipmap.dg,"g",2),
                        new Figure(getApplicationContext(),3,4,R.mipmap.rg,"g",3),new Figure(getApplicationContext(),3,0,R.mipmap.vv,"v",2),
                        new Figure(getApplicationContext(),0,5,R.mipmap.tg,"m",2),new Figure(getApplicationContext(),5,0,R.mipmap.tp,"m",2),
                        new Figure(getApplicationContext(),3,5,R.mipmap.lv,"v",2),new Figure(getApplicationContext(),0,0,R.mipmap.vv,"v",2),
                        new Figure(getApplicationContext(),6,5,R.mipmap.lv,"v",2),new Figure(getApplicationContext(),3,3,R.mipmap.rg,"g",3)},

                {new Figure(getApplicationContext(),1,5,R.mipmap.j,"m",2),//12
                        new Figure(getApplicationContext(),0,0,R.mipmap.dv,"v",2),new Figure(getApplicationContext(),0,5,R.mipmap.dv,  "v",2),
                        new Figure(getApplicationContext(),1,1,R.mipmap.eg,"g",3),new Figure(getApplicationContext(),3,4,R.mipmap.rg,  "g",3),
                        new Figure(getApplicationContext(),0,2,R.mipmap.rg,"g",3),new Figure(getApplicationContext(),3,5,R.mipmap.zv,  "v",2),
                        new Figure(getApplicationContext(),3,2,R.mipmap.zg,"g",2),new Figure(getApplicationContext(),4,5,R.mipmap.tg,"m",2),
                        new Figure(getApplicationContext(),1,4,R.mipmap.lg,"g",2),new Figure(getApplicationContext(),6,5,R.mipmap.lv,  "v",2)},

                {new Figure(getApplicationContext(),5,5,R.mipmap.j,"m",2),//13
                        new Figure(getApplicationContext(),1,0,R.mipmap.zv,"v",2),new Figure(getApplicationContext(),4,2,R.mipmap.rv,  "v",3),
                        new Figure(getApplicationContext(),2,0,R.mipmap.tg,"m",2),new Figure(getApplicationContext(),3,3,R.mipmap.ev,  "v",3),
                        new Figure(getApplicationContext(),4,0,R.mipmap.zg,"g",2),new Figure(getApplicationContext(),2,4,R.mipmap.ev,  "v",3),
                        new Figure(getApplicationContext(),6,0,R.mipmap.rv,"v",3),new Figure(getApplicationContext(),1,5,R.mipmap.dv,"v",2),
                        new Figure(getApplicationContext(),5,1,R.mipmap.ev,"v",3),new Figure(getApplicationContext(),3,6,R.mipmap.mg,  "g",2)},

                {new Figure(getApplicationContext(),0,0,R.mipmap.j,"m",2),//14
                        new Figure(getApplicationContext(),2,1,R.mipmap.eg,"g",3),new Figure(getApplicationContext(),2,4,R.mipmap.zg,  "g",2),
                        new Figure(getApplicationContext(),5,0,R.mipmap.tp,"m",2),new Figure(getApplicationContext(),5,4,R.mipmap.lg,  "g",2),
                        new Figure(getApplicationContext(),1,2,R.mipmap.ev,"v",3),new Figure(getApplicationContext(),0,5,R.mipmap.tg,  "m",2),
                        new Figure(getApplicationContext(),4,2,R.mipmap.mv,"v",2),new Figure(getApplicationContext(),2,5,R.mipmap.zv,"v",2),
                        new Figure(getApplicationContext(),5,2,R.mipmap.dg,"g",2),new Figure(getApplicationContext(),4,5,R.mipmap.lv,  "v",2)},

                {new Figure(getApplicationContext(),0,1,R.mipmap.j,"m",2),//15
                        new Figure(getApplicationContext(),3,0,R.mipmap.rv,"v",3),new Figure(getApplicationContext(),0,3,R.mipmap.zg,  "g",2),
                        new Figure(getApplicationContext(),4,0,R.mipmap.eg,"g",3),new Figure(getApplicationContext(),1,4,R.mipmap.eg,  "g",3),
                        new Figure(getApplicationContext(),4,1,R.mipmap.tp,"m",2),new Figure(getApplicationContext(),2,5,R.mipmap.mv,  "v",2),
                        new Figure(getApplicationContext(),6,1,R.mipmap.rv,"v",3),
                        new Figure(getApplicationContext(),3,3,R.mipmap.eg,"g",3)}
        };
        final int[] images={R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4,R.mipmap.a5,R.mipmap.a6,R.mipmap.a7,R.mipmap.a8,R.mipmap.a9,R.mipmap.a10,R.mipmap.a11,
                R.mipmap.a12,R.mipmap.a13,R.mipmap.a14,R.mipmap.a15};
        final RelativeLayout l=(RelativeLayout) findViewById(R.id.main);
        Display disp = getWindowManager().getDefaultDisplay();
        for (Figure[] f:figures) {
            for (Figure g:f) {
                g.setWH(disp.getWidth(),disp.getHeight());
            }
        }
        final Intent j=getIntent();
        final EditText et=(EditText)findViewById(R.id.editText);
        final int s=j.getIntExtra("number",1);
        final LinearLayout lll=(LinearLayout)findViewById(R.id.lll);
        startLevel(s,et,l,figures,lll);
        ImageButton next=(ImageButton)findViewById(R.id.btNext);
        ImageButton prev=(ImageButton)findViewById(R.id.btPrev);
        ImageButton ask=(ImageButton)findViewById(R.id.btAsk);
        ImageButton res=(ImageButton)findViewById(R.id.btRes);
        final ImageView imageView=(ImageView)findViewById(R.id.imageView4);
        final LinearLayout ll=(LinearLayout)findViewById(R.id.ll);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scanner sc=new Scanner(et.getText().toString());
                int s=sc.nextInt();
                startLevel((s!=15?s+1:1),et,l,figures,lll);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scanner sc=new Scanner(et.getText().toString());
                int s=sc.nextInt();
                startLevel((s!=1?s-1:15),et,l,figures,lll);
            }
        });
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scanner sc=new Scanner(et.getText().toString());
                int s=sc.nextInt();
                Intent i=new Intent(MainActivity.this,MainActivity.class);
                i.putExtra("number",s);
                finish();
                startActivity(i);
            }
        });
        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scanner sc=new Scanner(et.getText().toString());
                int s=sc.nextInt();
                ll.setVisibility(View.VISIBLE);
                imageView.setImageResource(images[s-1]);
                for (Figure[] f:figures) {
                    for (Figure g:f) {
                        l.removeView(g);
                    }
                }
            }
        });
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scanner sc=new Scanner(et.getText().toString());
                int s=sc.nextInt();
                ll.setVisibility(View.INVISIBLE);
                startLevel(s,et,l,figures,lll);
            }
        });
        lll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scanner sc=new Scanner(et.getText().toString());
                int s=sc.nextInt();
                lll.setVisibility(View.INVISIBLE);
            }
        });
    }
}




