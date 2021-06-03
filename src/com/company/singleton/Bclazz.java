package com.company.singleton;

public class Bclazz {
    private SocketClient socketClient;

    public Bclazz(){
        socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
