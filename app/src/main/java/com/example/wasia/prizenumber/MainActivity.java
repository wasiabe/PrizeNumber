package com.example.wasia.prizenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<PrizeNumber> myDataset = new ArrayList<PrizeNumber>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewPN);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
/*
        for(int i=0; i<10; i++) {
            PrizeNumber p = new PrizeNumber();
            String y = String.valueOf(100 + i);
            p.year = y;
            myDataset.add(p);
        }
*/
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        DatabaseReference drPrizeNumbers = FirebaseDatabase.getInstance().getReference("prize_numbers_1060102");

        drPrizeNumbers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                myDataset.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren() ){
                    PrizeNumber pn = new PrizeNumber();
                    pn.number = ds.child("number").getValue().toString();
                    myDataset.add(pn);
                }

                // specify an adapter (see also next example)
                mAdapter = new MyAdapter(myDataset);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
