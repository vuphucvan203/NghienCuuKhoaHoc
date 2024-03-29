package com.example.nghiencuukhoahoc.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nghiencuukhoahoc.Adapter.DeviceAdapter;
import com.example.nghiencuukhoahoc.Adapter.onItemClickListener;
import com.example.nghiencuukhoahoc.Devices.GasActivity;
import com.example.nghiencuukhoahoc.Model.Rooms;
import com.example.nghiencuukhoahoc.MyViewModel.RoomsViewModel;
import com.example.nghiencuukhoahoc.R;

import java.util.List;

public class KitchenFragment extends Fragment implements onItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private RecyclerView rcv_devices;
    private DeviceAdapter adapterDevices;
    private RoomsViewModel roomsViewModel ;
    public KitchenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rcv_devices = view.findViewById(R.id.recyclerview);
        rcv_devices.setHasFixedSize(true);

        adapterDevices = new DeviceAdapter(this);

        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 2);
        rcv_devices.setLayoutManager(linearLayoutManager);

        //getData();

        rcv_devices.setAdapter(adapterDevices);
        roomsViewModel = new ViewModelProvider(getActivity()).get(RoomsViewModel.class);
        roomsViewModel.getLst_liveData().observe(getViewLifecycleOwner(), new Observer<List<Rooms>>() {
            @Override
            public void onChanged(List<Rooms> rooms) {

                for(int i =0 ; i < rooms.size(); i++){
                    if(rooms.get(i).getName().equals("livingRoom")){
                        adapterDevices.SetData(rooms.get(i));
                        break;
                    }
                }
            }
        });
        return view;
    }

    @Override
    public void onItemClick(int position, String name, int value) {
        Log.i("intent", "onItemClick: " + position);
        if (position == 2) {
            Intent intent = new Intent(getActivity(), GasActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("value", value);
            startActivity(intent);
        }
    }
}