package com.example.homework4.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework4.R;
import com.example.homework4.recycler.Info;
import com.example.homework4.recycler.InfoAdapter;

import java.util.ArrayList;

public class Fragment_Info extends Fragment {
    private ArrayList<Info> mArrayList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private InfoAdapter mAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);

        mAdapter = new InfoAdapter(mArrayList, new InfoAdapter.OnMyItemClickListener() {
            @Override
            public void onMyItemClick(int position) {
                Info info = new Info();
                info = mArrayList.get(position);
                Toast.makeText(getActivity(), info.getGmail(), Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        mRecyclerView.setAdapter(mAdapter);
        getData();
        return rootView;
    }

    private void getData() {
        Info info = null;
        for(int i =1;i<=20;i++){
            String g = "abc"+i+"gmail.com";
            info = new Info(g);
            mArrayList.add(info);
        }
        mAdapter.notifyDataSetChanged();
    }

}
