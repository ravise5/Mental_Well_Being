package com.back4app.quickstartexampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.parse.ParseUser;

public class General extends AppCompatActivity {

    private EditText ageEditText;
    private RadioGroup gender;
    private RadioGroup employment;
    private RadioGroup marital;
    private RadioButton rb1;
    ParseUser user = ParseUser.getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);


        ageEditText = findViewById(R.id.ageEditText);
        gender = findViewById(R.id.gender);
        employment = findViewById(R.id.employment);
        marital = findViewById(R.id.marital);








    }

    public void cont(View view){

        int radioID = gender.getCheckedRadioButtonId();
        rb1 = findViewById(radioID);
        user.put("Gender",rb1.getText().toString());

        radioID = employment.getCheckedRadioButtonId();
        rb1 = findViewById(radioID);
        user.put("EmploymentStatus",rb1.getText().toString());

        radioID =  marital.getCheckedRadioButtonId();
        rb1 = findViewById(radioID);
        user.put("MaritalStatus",rb1.getText().toString());

        user.saveInBackground();

        Intent intent = new Intent(getApplicationContext(),PSSActivity.class);
        startActivity(intent);




    }
}
