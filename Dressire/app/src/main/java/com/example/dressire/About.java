package com.example.dressire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class About extends AppCompatActivity {
    TextView oneD, whyD;
    LinearLayout one, why;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        oneD=findViewById(R.id.oneD);
        whyD=findViewById(R.id.whyD);
        one = findViewById(R.id.one);
        why=findViewById(R.id.why);
    }
    public void expand(View view){
        int o = (oneD.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(one, new AutoTransition());
        oneD.setVisibility(o);
    }

}