package com.back4app.quickstartexampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;

public class PSSActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private PSSAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<PSS> PSSList;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    int res;
    ParseUser user = ParseUser.getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pss);

        PSSList = new ArrayList<>();

        PSSList.add(new PSS(getString(R.string.pss1)));
        PSSList.add(new PSS(getString(R.string.pss2)));
        PSSList.add(new PSS(getString(R.string.pss3)));
        PSSList.add(new PSS(getString(R.string.pss4)));
        PSSList.add(new PSS(getString(R.string.pss5)));
        PSSList.add(new PSS(getString(R.string.pss6)));
        PSSList.add(new PSS(getString(R.string.pss7)));
        PSSList.add(new PSS(getString(R.string.pss8)));
        PSSList.add(new PSS(getString(R.string.pss9)));
        PSSList.add(new PSS(getString(R.string.pss10)));


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new PSSAdapter(PSSList);



        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new PSSAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int resource) {

                PSSList.get(position).updateResponse(resource);
            }
        });

    }

    public void cont(View view){

        Intent intent = new Intent(getApplicationContext(),UCLAActivity.class);
        startActivity(intent);

        int pssScore = 0;
        for(PSS response:PSSList)
        {
            pssScore += response.getResponse();
        }
        user.put("PSS_Score",pssScore);
        user.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null)
                    Toast.makeText(PSSActivity.this, "Responses Saved", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(PSSActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}
