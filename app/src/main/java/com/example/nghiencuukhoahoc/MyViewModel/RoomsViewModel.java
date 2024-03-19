package com.example.nghiencuukhoahoc.MyViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nghiencuukhoahoc.Model.Rooms;

import java.util.ArrayList;
import java.util.List;

public class RoomsViewModel extends ViewModel {
    private MutableLiveData<List<Rooms>> LiveData ;
    private DataSingleton dataSingleton ;

    public RoomsViewModel() {
        LiveData = new MutableLiveData<>();
        dataSingleton = DataSingleton.getInstance();
        initData();
    }

    public MutableLiveData<List<Rooms>> getLst_liveData() {
        return LiveData;
    }
    private void initData() {
        List<Rooms> lst  =new ArrayList<>();
        lst.add(new Rooms("bedRoom",19,0,0,-1));
        lst.add(new Rooms("livingRoom",40,0,0,-1));
        lst.add(new Rooms("streamRoom",99,0,0,-1));
        lst.add(new Rooms("kitchen",23,0,0,-1));
        LiveData.setValue(lst);
        dataSingleton.setSharedData(lst);
    }
    public void setData(List<Rooms> m_lst){
        LiveData.setValue(m_lst);
        dataSingleton.setSharedData(m_lst);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
