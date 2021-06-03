package com.company.adapter;

public class SocketAdapter implements Electronic110V{
    private Electornic220V electornic220V;

    public SocketAdapter(Electornic220V electornic220V){
        this.electornic220V = electornic220V;
    }
    @Override
    public void powerOn() {
        electornic220V.connect();
    }
}
