package com.example.nghiencuukhoahoc.Model;

public class Desired {
    private Rooms livingRoom;
    private Rooms bedRoom;

    public Desired(Rooms livingRoom, Rooms bedRoom) {
        this.livingRoom = livingRoom;
        this.bedRoom = bedRoom;
    }

    public Desired() {
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
