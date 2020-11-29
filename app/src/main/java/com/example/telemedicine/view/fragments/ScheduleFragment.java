package com.example.telemedicine.view.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telemedicine.R;
import com.example.telemedicine.view.activities.MainActivity;

public class ScheduleFragment extends Fragment {

    public static ScheduleFragment newInstance() {
        return new ScheduleFragment();
    }

    private RecyclerView doctorsList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        doctorsList = view.findViewById(R.id.doctor_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        doctorsList.setLayoutManager(linearLayoutManager);

        DoctorListAdapter doctorListAdapter = new DoctorListAdapter();
        doctorsList.setAdapter(doctorListAdapter);

        return view;
    }


}