package com.example.nghiencuukhoahoc.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nghiencuukhoahoc.Model.Rooms;
import com.example.nghiencuukhoahoc.R;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {
    private Context mContext;
    private List<Rooms> lstRoom;
    private onItemClickListener listener;
    public RoomAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setDataRoom(List<Rooms> l){
        this.lstRoom = l;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room,parent,false);
        return new RoomViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Rooms currRoom = lstRoom.get(position);
        if(currRoom == null) return;

        switch (currRoom.getName()){
            case "bedRoom" :
                holder.tvNameRoom.setText("bedRoom");
                holder.imgRoom.setImageResource(R.drawable.bedroom);
                holder.tvDevices.setText(currRoom.getNumber_devices() + " Devices");
                break;
            case "livingRoom" :
                holder.tvNameRoom.setText("LivingRoom");
                holder.imgRoom.setImageResource(R.drawable.livingroom);
                holder.tvDevices.setText(currRoom.getNumber_devices() + " Devices");
                break;
            case "kitchen":
                holder.tvNameRoom.setText("Kitchen");
                holder.imgRoom.setImageResource(R.drawable.kitchen);
                holder.tvDevices.setText(currRoom.getNumber_devices() + " Devices");
                break;

        }



        holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    holder.aSwitch.setText("On");
                }else{
                    holder.aSwitch.setText("Off");
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        if (lstRoom != null) {
            return lstRoom.size();
        } else {
            return 0;
        }
    }
    public class RoomViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgRoom;
        private TextView tvNameRoom,tvDevices;
        private Switch aSwitch;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRoom = itemView.findViewById(R.id.image_room);
            tvNameRoom = itemView.findViewById(R.id.room_name);
            tvDevices = itemView.findViewById(R.id.number_devices);
            aSwitch = itemView.findViewById(R.id.switch_room);
        }

    }
}
