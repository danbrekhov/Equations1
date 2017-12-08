package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuadraticEquationActivity extends AppCompatActivity {

    Button btnSolve, btnShare;
    EditText edit1, edit2, edit3;
    TextView text1, text2;
    int a, b, c;
    double x1, x2, dis;
    String resFull, res, d, e, f, toSend = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic_equation);
        initView();

        btnSolve.setOnClickListener(v -> {

            d=getA();
            if (d.charAt(0)=='-') {
                d=d.substring(1);
                a=-(Integer.parseInt(d));
            } else {
                a=Integer.parseInt(d);
            }

            e=getB();
            if (e.charAt(0)=='-') {
                e=e.substring(1);
                b=-(Integer.parseInt(e));
            } else {
                b=Integer.parseInt(e);
            }

            f=getC();
            if (f.charAt(0)=='-') {
                f=f.substring(1);
                c=-(Integer.parseInt(f));
            } else {
                c=Integer.parseInt(f);
            }

            dis=(double)((b*b)-(4*a*c));

            if (dis<0){
                res="Нет решений";
            } else {
                if (dis==0) {
                    x1=(-(double)b+Math.sqrt(dis))/2*(double)a;
                    res="x = "+x1;
                } else {
                    x1=(-(double)b+Math.sqrt(dis))/2*(double)a;
                    x2=(-(double)b-Math.sqrt(dis))/2*(double)a;

                    res="x₁ = "+x1+"; x₂ = "+x2;
                }

            }

            resFull=a+"x² + "+b+"x + "+c+" = 0";

            toSend="Уравнение: "+resFull+". Ответ: "+res+".";

            text1.setText(resFull);
            text1.setTextAppearance(R.style.TextAppearance_AppCompat_Large);
            text2.setText(res);
            text2.setTextAppearance(R.style.TextAppearance_AppCompat_Large);

        });

        btnShare.setOnClickListener(v -> {
            if (toSend.equals("null")) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        R.string.toast, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, toSend);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }

    String getA(){
        return edit1.getEditableText().toString();
    }

    String getB(){
        return edit2.getEditableText().toString();
    }

    String getC(){
        return edit3.getEditableText().toString();
    }


    void initView(){
        btnSolve = findViewById(R.id.solveQ);
        btnShare = findViewById(R.id.shareQ);

        edit1 = findViewById(R.id.editTextQ1);
        edit2 = findViewById(R.id.editTextQ2);
        edit3 = findViewById(R.id.editTextQ3);

        text1 = findViewById(R.id.res1Q);
        text2 = findViewById(R.id.res2Q);
    }
}