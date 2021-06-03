package com.company.adapter;

public class Aircon implements Electornic220V{

    @Override
    public void connect() {
        System.out.println("에어컨 220V on");
    }
}
