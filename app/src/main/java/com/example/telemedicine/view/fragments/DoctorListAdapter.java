package com.example.telemedicine.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telemedicine.R;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.DoctorListViewHolder> implements View.OnClickListener{

    int[] number = {1,2,3,4,5,6,7,8,9,10};

    public DoctorListAdapter () {
    }

    @NonNull
    @Override
    public DoctorListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View doctorView = inflater.inflate(R.layout.doctor_contact, parent, false);

        DoctorListViewHolder viewHolder = new DoctorListViewHolder(doctorView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return number.length;
    }

    @Override
    public void onClick(View view) {
        Context context = view.getContext();
    }



    public class DoctorListViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        public DoctorListViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.doctor_info);

            relativeLayout.setOnClickListener(DoctorListAdapter.this);
        }
    }
}
