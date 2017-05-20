package com.bignerdranch.android.safari_rushhour;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Figure extends ImageView{
    int[] a={43,99,155,211,269,324,381};
    int[] m={213,269,325,381,437,493,549};
    int aa=465;
    int  mm=602;
    int oy=150;
    int c=54;
    float X;
    float Y;
    int x;
    int y;
    String orient;
    int lenghtx;
    int lenghty;
    Context context;
    public void setWH(int w,int h){
        for (int i=0;i<7;i++) {
            a[i]=a[i]*w/480;
            m[i]=m[i]*h/800;
        }
        aa=aa*w/480;
        mm=mm*h/800;
        oy=oy*h/800;
        c=(a[1]-a[0]+m[1]-m[0])/2-2;
    }
    public Figure(Context con, int ax, int ay, int im, String r,int l) {
        super(con);
        context=con;
        x=ax;
        y=ay;
        X=a[ax];
        Y=m[ay];
        orient=r;
        this.setImageResource(im);
        this.setBackgroundResource(im);
        this.setX(X);
        this.setY(Y);

        if(orient.equals("v")){
            setLayoutParams(new ViewGroup.LayoutParams(c,c*l));
            lenghtx=1;
            lenghty=l;
        }
        if(orient.equals("g")){
            setLayoutParams(new ViewGroup.LayoutParams(c*l,c));
            lenghtx=l;
            lenghty=1;
        }
        if(orient.equals("m")){
            setLayoutParams(new ViewGroup.LayoutParams(c*2,c*2));
            lenghtx=2;
            lenghty=2;
        }
        xChanged();
        yChanged();
    }
    public void setOnTouchListener(OnTouchListener n, final Figure[] f, final LinearLayout lll) {
        n=new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(f[0].x==5&&f[0].y==2){
                    f[0].setX(a[6]);
                    lll.setVisibility(View.VISIBLE);
                }else {
                    boolean[][] bool = new boolean[7][7];
                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 7; j++) {
                            bool[i][j] = false;
                        }
                    }
                    for (Figure g : f) {
                        if (g.x < x) {
                            for (int i = 0; i < g.x; i++) {
                                for (int j = g.y; j < g.y + g.lenghty; j++) {
                                    bool[i][j] = true;
                                }
                            }
                        }
                        if (g.x > x) {
                            for (int i = g.x; i < 7; i++) {
                                for (int j = g.y; j < g.y + g.lenghty; j++) {
                                    bool[i][j] = true;
                                }
                            }
                        }
                        if (g.y < y) {
                            for (int i = g.x; i < g.x + g.lenghtx; i++) {
                                for (int j = 0; j < g.y; j++) {
                                    bool[i][j] = true;
                                }
                            }
                        }
                        if (g.y > y) {
                            for (int i = g.x; i < g.x + g.lenghtx; i++) {
                                for (int j = g.y; j < 7; j++) {
                                    bool[i][j] = true;
                                }
                            }
                        }


                        if (g.orient.equals("v")) {
                            for (int i = 0; i < g.lenghty; i++) {
                                bool[g.x][g.y + i] = true;

                            }

                        }
                        if (g.orient.equals("g")) {
                            for (int i = 0; i < g.lenghtx; i++) {
                                bool[g.x + i][g.y] = true;
                            }


                        }
                        if (g.orient.equals("m")) {
                            bool[g.x][g.y] = true;
                            bool[g.x + 1][g.y] = true;
                            bool[g.x][g.y + 1] = true;
                            bool[g.x + 1][g.y + 1] = true;

                        }
                    }
                    if (orient.equals("v")) {
                        float SY = getY();
                        int sy = y;
                        for (int i = 0; i < lenghty; i++) {
                            bool[x][sy + i] = false;
                        }

                        float RY = event.getRawY() - oy;
                        setY(RY);
                        yChanged();

                        boolean checker = true;
                        for (int i = 0; i < lenghty; i++) {
                            if (bool[x][y + i])
                                checker = false;
                        }
                        if (checker) {
                            for (int i = 0; i < lenghty; i++) {
                                bool[x][y + i] = true;
                            }
                        } else {
                            setY(SY);
                            y = sy;
                            for (int i = 0; i < lenghty; i++) {
                                bool[x][sy + i] = true;
                            }
                        }
                    }
                    if (orient.equals("g")) {
                        float SX = getX();
                        int sx = x;
                        for (int i = 0; i < lenghtx; i++) {
                            bool[sx + i][y] = false;
                        }

                        float RX = event.getRawX();
                        setX(RX);
                        xChanged();

                        boolean checker = true;
                        for (int i = 0; i < lenghtx; i++) {
                            if (bool[x + i][y])
                                checker = false;
                        }
                        if (checker) {
                            for (int i = 0; i < lenghtx; i++) {
                                bool[x + i][y] = true;
                            }
                        } else {
                            setX(SX);
                            x = sx;
                            for (int i = 0; i < lenghtx; i++) {
                                bool[sx + i][y] = true;
                            }
                        }
                    }
                    if (orient.equals("m")) {
                        float RY = event.getRawY() - oy;
                        float RX = event.getRawX();
                        if (Math.abs(RX - getX()) >= Math.abs(RY - getY())) {
                            for (Figure g : f) {
                                if (!(RX + getWidth() >= g.getX() && RX <= g.getX() + g.getWidth())) {
                                    float SX = getX();
                                    int sx = x;
                                    bool[x][y] = false;
                                    bool[x + 1][y] = false;
                                    bool[x][y + 1] = false;
                                    bool[x + 1][y + 1] = false;

                                    setX(RX);
                                    xChanged();

                                    boolean checker = true;
                                    if (bool[x][y])
                                        checker = false;
                                    if (bool[x + 1][y])
                                        checker = false;
                                    if (bool[x][y + 1])
                                        checker = false;
                                    if (bool[x + 1][y + 1])
                                        checker = false;

                                    if (checker) {
                                        bool[x][y] = true;
                                        bool[x + 1][y] = true;
                                        bool[x][y + 1] = true;
                                        bool[x + 1][y + 1] = true;
                                    } else {
                                        setX(SX);
                                        x = sx;
                                        bool[sx][y] = true;
                                        bool[sx + 1][y] = true;
                                        bool[sx][y + 1] = true;
                                        bool[sx + 1][y + 1] = true;
                                    }
                                }
                            }
                        } else {
                            for (Figure g : f) {
                                if (!(RY + getHeight() >= g.getY() && RY <= g.getY() + g.getHeight())) {
                                    float SY = getY();
                                    int sy = y;
                                    bool[x][y] = false;
                                    bool[x + 1][y] = false;
                                    bool[x][y + 1] = false;
                                    bool[x + 1][y + 1] = false;

                                    setY(RY);
                                    yChanged();

                                    boolean checker = true;
                                    if (bool[x][y])
                                        checker = false;
                                    if (bool[x + 1][y])
                                        checker = false;
                                    if (bool[x][y + 1])
                                        checker = false;
                                    if (bool[x + 1][y + 1])
                                        checker = false;

                                    if (checker) {
                                        bool[x][y] = true;
                                        bool[x + 1][y] = true;
                                        bool[x][y + 1] = true;
                                        bool[x + 1][y + 1] = true;
                                    } else {
                                        setY(SY);
                                        y = sy;
                                        bool[x][sy] = true;
                                        bool[x + 1][sy] = true;
                                        bool[x][sy + 1] = true;
                                        bool[x + 1][sy + 1] = true;
                                    }
                                }
                            }
                        }
                    }
                }
                return true;
            }
        };
        super.setOnTouchListener(n);
    }
    public void xChanged(){
        this.setX(this.changed(a,aa,getX(),getWidth(),lenghtx));
        X=getX();
    }
    public void yChanged(){
        this.setY(this.changed(m,mm,getY(),getHeight(),lenghty));
        Y=getY();
    }
    public float changed(int[] a,int b,float k,float d,int l){
        if(k+d>b) {
            y=(b==mm?7-l:y);
            x=(b==aa?7-l:x);
            return (a[7 - l]);
        }
        if(k<=a[0]) {
            y=(b==mm?0:y);
            x=(b==aa?0:x);
            return (a[0]);
        }
        for (int i = 0; i < 5; i++) {
            if (k < a[i+1] -10 && k>=a[i]) {
                y=(b==mm?i:y);
                x=(b==aa?i:x);
                return a[i];
            }
            if (k > a[i+1] - 10 && k < a[i+1]+46) {
                y=(b==mm?i+1:y);
                x=(b==aa?i+1:x);
                return a[i + 1];
            }
        }
        if(k>a[6]-10) {
            y=(b==mm?7-l:y);
            x=(b==aa?7-l:x);
            return a[7 - l];
        }
        return 0;
    }
}