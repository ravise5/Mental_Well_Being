package com.back4app.quickstartexampleapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UCLAAdapter extends RecyclerView.Adapter<UCLAAdapter.UCLAViewHolder> {

    private ArrayList<UCLA> mPSS;

    private UCLAAdapter.OnItemClickListener mListener;



    public UCLAAdapter(ArrayList<UCLA> PSSList){
        mPSS= PSSList;

    }


    @Override
    public UCLAAdapter.UCLAViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ucla,parent,false);
        UCLAAdapter.UCLAViewHolder uclaViewHolder = new UCLAAdapter.UCLAViewHolder(view,mListener);
        return uclaViewHolder;
    }

    @Override
    public void onBindViewHolder(UCLAAdapter.UCLAViewHolder holder, int position) {

        final RadioGroup radioGroup = (holder).mResponse;
        radioGroup.clearCheck();
        UCLA currentQuestion = mPSS.get(position);
        holder.mQuestion.setText(currentQuestion.getQuestion());

    }

    @Override
    public int getItemCount() {
        return mPSS.size();
    }

    public interface  OnItemClickListener{
        void onItemClick(int position,int resource);


    }

    public void setOnItemClickListener(UCLAAdapter.OnItemClickListener listener){
        mListener = listener;
    }

    public static class UCLAViewHolder extends RecyclerView.ViewHolder{

        public TextView mQuestion;
        public RadioGroup mResponse;
        public RadioButton radioButton;

        public UCLAViewHolder( View itemView, final UCLAAdapter.OnItemClickListener listener) {
            super(itemView);
            mQuestion = itemView.findViewById(R.id.question);
            mResponse = itemView.findViewById(R.id.responseRadioGroup);
            mResponse.clearCheck();
            mResponse.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {

                    if(listener!=null)
                    {
                        int position = getAdapterPosition();

                        int resource = 0;

                        if(position!=RecyclerView.NO_POSITION) {
                            if (position != 0 && position != 4 && position != 5 && position != 8 && position != 9 && position != 14 && position != 15 && position != 18 && position != 19)
                            {
                                switch (i) {
                                    case R.id.one:
                                        resource = 0;
                                        break;
                                    case R.id.two:
                                        resource = 1;
                                        break;
                                    case R.id.three:
                                        resource = 2;
                                        break;
                                    case R.id.four:
                                        resource = 3;
                                        break;
                                }

                            }else
                            {
                                switch (i) {
                                    case R.id.one:
                                        resource = 4;
                                        break;
                                    case R.id.two:
                                        resource = 3;
                                        break;
                                    case R.id.three:
                                        resource = 2;
                                        break;
                                    case R.id.four:
                                        resource = 1;
                                        break;
                                }

                            }
                            listener.onItemClick(position, resource);
                        }
                    }

                }
            });


        }
    }

}
