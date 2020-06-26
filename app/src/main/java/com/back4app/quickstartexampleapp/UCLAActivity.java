package com.back4app.quickstartexampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;

public class UCLAActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private UCLAAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<UCLA> uclaList;
    ParseUser user = ParseUser.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucla);

        uclaList = new ArrayList<>();
        uclaList.add(new UCLA(getString(R.string.ucla1)));
        uclaList.add(new UCLA(getString(R.string.ucla2)));
        uclaList.add(new UCLA(getString(R.string.ucla3)));
        uclaList.add(new UCLA(getString(R.string.ucla4)));
        uclaList.add(new UCLA(getString(R.string.ucla5)));
        uclaList.add(new UCLA(getString(R.string.ucla6)));
        uclaList.add(new UCLA(getString(R.string.ucla7)));
        uclaList.add(new UCLA(getString(R.string.ucla8)));
        uclaList.add(new UCLA(getString(R.string.ucla9)));
        uclaList.add(new UCLA(getString(R.string.ucla10)));
        uclaList.add(new UCLA(getString(R.string.ucla11)));
        uclaList.add(new UCLA(getString(R.string.ucla12)));
        uclaList.add(new UCLA(getString(R.string.ucla13)));
        uclaList.add(new UCLA(getString(R.string.ucla14)));
        uclaList.add(new UCLA(getString(R.string.ucla15)));
        uclaList.add(new UCLA(getString(R.string.ucla16)));
        uclaList.add(new UCLA(getString(R.string.ucla17)));
        uclaList.add(new UCLA(getString(R.string.ucla18)));
        uclaList.add(new UCLA(getString(R.string.ucla19)));
        uclaList.add(new UCLA(getString(R.string.ucla20)));


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new UCLAAdapter(uclaList);



        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new UCLAAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int resource) {

                uclaList.get(position).updateResponse(resource);
            }
        });


    }



    public void cont(View view){
        int UCLAScore = 0;
        for(UCLA response:uclaList)
        {
            UCLAScore += response.getResponse();
        }
        user.put("UCLA_Score",UCLAScore);
        user.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null)
                    Toast.makeText(UCLAActivity.this, "Responses Saved", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(UCLAActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        Intent intent = new Intent(getApplicationContext(),Feedback.class);
        startActivity(intent);

    }
}
