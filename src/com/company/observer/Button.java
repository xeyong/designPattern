package com.company.observer;

public class Button {
    private String name;
    private IbuttonListner ibuttonListner;

    public Button(String name){
        this.name = name;
    }

    public void click(String message){
        ibuttonListner.clickEvent(message);
    }

    public void addListnener(IbuttonListner ibuttonListner){
        this.ibuttonListner = ibuttonListner;
    }
}
