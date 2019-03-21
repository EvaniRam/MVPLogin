package com.evani.techmtest.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.evani.techmtest.R;
import com.evani.techmtest.presenters.IDataPresenter;
import com.evani.techmtest.presenters.ILoginPresenter;
import com.evani.techmtest.presenters.LoginPresenter;
import com.evani.techmtest.view.ILoginView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private static final String TAG = "CustomAdapter";
    private List<String> mDataset;
    private Context context;


    public CustomAdapter(List<String> mDataset, Context context) {
        this.mDataset = mDataset;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final String valStr = mDataset.get(i);
        myViewHolder.textView.setText(valStr);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public MyViewHolder(View view) {
           super(view);
           textView = (TextView) view.findViewById(R.id.content);
        }
    }


}
