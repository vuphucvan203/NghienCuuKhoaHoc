package com.example.nghiencuukhoahoc.Adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.nghiencuukhoahoc.Fragment.AllRoomFragment;
import com.example.nghiencuukhoahoc.Fragment.BedRoomFragment;
import com.example.nghiencuukhoahoc.Fragment.LivingRoomFragment;

public class FragmentAdapter extends FragmentStateAdapter {
//    private ViewPager2 viewPager2;
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
//    public void setViewPager2(ViewPager2 viewPager2){
//        this.viewPager2 = viewPager2;
//    }
    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            AllRoomFragment allRoom = new AllRoomFragment();
            //allRoom.setData(lst);
            return allRoom;
        } else if (position == 1) {
            return new BedRoomFragment();
        } else return new LivingRoomFragment();

    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
