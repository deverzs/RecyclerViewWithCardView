package edu.miracostacollege.recyclerviewwithcardview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleAdapterHolder> {

    ArrayList<ExampleItem> theList;

    public ExampleAdapter(ArrayList<ExampleItem> itemList){
        theList = itemList;
    }

    @NonNull
    @Override
    public ExampleAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_item, parent, false);
        ExampleAdapterHolder exampleAdapterHolder = new ExampleAdapterHolder(v);
        return exampleAdapterHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleAdapterHolder holder, int position) {
            ExampleItem currentItem = theList.get(position);

            holder.mImageView.setImageResource(currentItem.getmImageResource());
            holder.mText1.setText(currentItem.getmText1());
            holder.mText2.setText(currentItem.getmText2());
    }

    @Override
    public int getItemCount() {
        return theList.size();
    }

    public class ExampleAdapterHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mText1;
        public TextView mText2;

        public ExampleAdapterHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mText1 = itemView.findViewById(R.id.textView1);
            mText2 = itemView.findViewById(R.id.textView2);
        }
    }
}
