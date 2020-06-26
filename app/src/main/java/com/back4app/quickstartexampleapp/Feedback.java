package com.back4app.quickstartexampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseUser;

public class Feedback extends AppCompatActivity {

    private TextView stressTextView;
    private TextView stressDesc;
    private TextView loneTextView;
    private TextView loneDesc;
    ParseUser user = ParseUser.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        stressTextView = findViewById(R.id.stressTextView);
        stressDesc = findViewById(R.id.stressDesc);
        loneTextView = findViewById(R.id.loneTextView);
        loneDesc = findViewById(R.id.loneDesc);

        int pss = user.getNumber("PSS_Score").intValue();
        int ucla = user.getNumber("UCLA_Score").intValue();

        if(pss>=0 && pss<=13)
        {
            stressDesc.setText("Low Stress");
        }

        else if(pss>13 && pss<27)
            stressDesc.setText("Moderately Stressed");
        else if(pss>26 && pss<41)
            stressDesc.setText("Highly Stressed");



//        if(ucla>=35)
//            loneDesc.setText("")



        stressTextView.append(" "+pss);
        loneTextView.append(" "+ucla);

    }

    public void submit(View view){

        Intent intent = new Intent(getApplicationContext(),PSSActivity.class);
        startActivity(intent);

    }
}
