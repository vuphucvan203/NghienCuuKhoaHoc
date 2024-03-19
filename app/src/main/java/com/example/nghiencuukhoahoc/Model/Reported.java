package com.example.nghiencuukhoahoc.Model;

public class Reported {
    private Rooms livingRoom;
    private Rooms bedRoom;

    public Reported(Rooms livingRoom, Rooms bedRoom) {
        this.livingRoom = livingRoom;
        this.bedRoom = bedRoom;
    }

    public Reported() {
    }

    public Rooms getLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(Rooms livingRoom) {
        this.livingRoom = livingRoom;
    }

    public Rooms getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(Rooms bedRoom) {
        this.bedRoom = bedRoom;
    }
}
