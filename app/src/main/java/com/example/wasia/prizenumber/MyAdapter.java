package com.example.wasia.prizenumber;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wasia on 2017/2/27.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.PrizeNumberHolder>{
    private ArrayList<PrizeNumber> mDataset ;

    public MyAdapter(ArrayList<PrizeNumber> myDataset) {
        mDataset = myDataset;
    }

    public static class PrizeNumberHolder extends RecyclerView.ViewHolder{
        public TextView prizeyear;
        public TextView prizemonth;

        public PrizeNumberHolder(View v) {
            super(v);
            prizeyear = (TextView)v.findViewById(R.id.PrizeYear);
            prizemonth = (TextView)v.findViewById(R.id.PrizeMonth);

        }
    }

    @Override
    public PrizeNumberHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prize_number_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        // return view holder
        return new PrizeNumberHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(PrizeNumberHolder holder, int position) {
        PrizeNumber pn = (PrizeNumber)mDataset.get(position);
        holder.prizeyear.setText(pn.number);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
