package com.example.manav;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class listadapter extends RecyclerView.Adapter<listadapter.viewHolder> {
    private ArrayList<listdata> emplist;


    public listadapter(ArrayList<listdata> emplist) {
        this.emplist = emplist;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from((parent.getContext()).inflate(R.layout.activity_recyclerview, parent, false));
//        return new viewHolder(itemView);
        return null;
    }
    @Override
    public int getItemCount() {
        return emplist.size();
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        listdata currentEmp = emplist.get(position);
        holder.name.setText(currentEmp.getName());
        holder.email.setText(currentEmp.getEmail());
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    public static class viewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView email;

        public viewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView);
            email = itemView.findViewById(R.id.imageView);
        }
    }
}



//        final listdata listdata1=listData[position];
//holder.textView.setText(listData[position].getDescription());
//holder.imageView.setImageResource(listData[position].getImgId());
//holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        Toast.makeText(view.getContext(),"click on item: "+listdata.getDescription(),Toast.LENGTH_SHORT).show();
//    }
//    });


//    @Override
//    public int getItemCount() {
//        return listData.length;
//    }
//
//    public class viewHolder {
//    }
//
//public class viewHolder {
//    }
