package com.back4app.quickstartexampleapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PSSAdapter extends RecyclerView.Adapter<PSSAdapter.PSSViewHolder> {

        private ArrayList<PSS> mPSS;

        private OnItemClickListener mListener;



        public PSSAdapter(ArrayList<PSS> PSSList){
            mPSS= PSSList;

        }


    @Override
    public PSSViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pss,parent,false);
        PSSAdapter.PSSViewHolder pssViewHolder = new PSSAdapter.PSSViewHolder(view,mListener);
        return pssViewHolder;
    }

    @Override
    public void onBindViewHolder( PSSViewHolder holder, int position) {

        final RadioGroup radioGroup = (holder).mResponse;
        radioGroup.clearCheck();
        PSS currentQuestion = mPSS.get(position);
        holder.mQuestion.setText(currentQuestion.getQuestion());

    }

    @Override
    public int getItemCount() {
        return mPSS.size();
    }

    public interface  OnItemClickListener{
            void onItemClick(int position,int resource);


        }

        public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

        public static class PSSViewHolder extends RecyclerView.ViewHolder{

            public TextView mQuestion;
            public RadioGroup mResponse;
            public RadioButton radioButton;

            public PSSViewHolder( View itemView, final OnItemClickListener listener) {
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

                            if(position!=RecyclerView.NO_POSITION)
                            {
                                switch(i)
                                {
                                    case R.id.one: resource = 0;
                                    break;
                                    case R.id.two: resource = 1;
                                    break;
                                    case R.id.three: resource = 2;
                                    break;
                                    case R.id.four: resource =3;
                                    break;
                                    case R.id.five: resource = 4;
                                    break;
                                }
                                listener.onItemClick(position,resource);
                            }
                        }

                    }
                });


            }
        }

}
