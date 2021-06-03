package com.company.singleton;

public class Aclazz {
    private SocketClient socketClient;

    public Aclazz(){
        socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
