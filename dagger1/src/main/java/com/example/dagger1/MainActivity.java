package com.example.dagger1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @Inject 注入的物件
 * @Named 若有相同的類別，作為區別用
 */
public class MainActivity extends AppCompatActivity {
    @Inject
    int number;

    @Inject
    LayoutInflater inflater;

    @Inject
    @Named("string1")
    String s1;

    @Inject
    DemoObj obj;

    @Inject
    @Named("indString")
    String indString;

    @Inject
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DemoApplication) getApplication()).inject(this);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.addView(button);
        setContentView(relativeLayout);

        Log.e("string", "number   " + number);
        Log.e("string", "LayoutInflater   " + inflater);
        Log.e("string", "s1   " + s1);
        Log.e("string", "obj   " + obj);
        Log.e("string", "obj   " + indString);

    }
}
