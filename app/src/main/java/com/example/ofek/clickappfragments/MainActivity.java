package com.example.ofek.clickappfragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Adapters.ListAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView counterTV;
    Button addBtn;
    boolean isLand=false;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isLand=findViewById(R.id.list)!=null;
        if (!isLand){
            portraitMode(savedInstanceState);
        }
        else {
            landMode(savedInstanceState);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isLand=findViewById(R.id.list)!=null;
        if (!isLand){
            portraitMode(savedInstanceState);
        }
        else {
            landMode(savedInstanceState);
        }
    }

    private void landMode(Bundle savedInstanceState) {
        isLand=true;
        if (savedInstanceState==null){
            return;
        }
        counter=savedInstanceState.getInt("count",0);
        recyclerView= (RecyclerView) findViewById(R.id.list);
        ListAdapter adapter=new ListAdapter(counter);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void portraitMode(Bundle savedInstanceState) {
        isLand=false;
        int counter=0;
        if (savedInstanceState!=null)
            counter=savedInstanceState.getInt("count",0);
        counterTV= (TextView) findViewById(R.id.counterTV);
        counterTV.setText(""+counter);
        addBtn= (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            int counter;
            @Override
            public void onClick(View view) {
                counter= Integer.parseInt(counterTV.getText().toString())+1;
                counterTV.setText(""+counter);
            }
        });
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("deubg", "--------onsaveinstancestate--------");
        if (counterTV!=null){
            counter= Integer.parseInt(counterTV.getText().toString());
        }
        outState.putInt("count", counter);
        super.onSaveInstanceState(outState);
    }
}
