package com.company.adapter;

public class Cleaner implements Electornic220V{

    @Override
    public void connect() {
        System.out.println("청소기 220v on");
    }
}
