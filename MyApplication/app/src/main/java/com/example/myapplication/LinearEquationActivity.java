package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LinearEquationActivity extends AppCompatActivity {

    Button btnSolve, btnShare;
    EditText edit1, edit2, edit3;
    TextView text1, text2;
    int a, b, c;
    double x;
    String resFull, res, d, e, f, toSend = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_equation);
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

            x=((double)c-(double)b)/(double)a;

            resFull=a+"x + "+b+" = "+c;
            res="x = "+x;

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
        btnSolve = findViewById(R.id.solveL);
        btnShare = findViewById(R.id.shareL);

        edit1 = findViewById(R.id.editTextL1);
        edit2 = findViewById(R.id.editTextL2);
        edit3 = findViewById(R.id.editTextL3);

        text1 = findViewById(R.id.res1L);
        text2 = findViewById(R.id.res2L);
    }
}
