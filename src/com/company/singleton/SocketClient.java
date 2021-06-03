package com.company.singleton;

public class SocketClient {
    private static SocketClient socketClient = null;//싱글톤 패턴자체가 static 메서드를 사용할거라서 거기에 사용하기위해 static으로 선언
    private SocketClient(){//기본생성자를 private으로 접근제한을 해줌

    }

    public static SocketClient getInstance(){
        if(socketClient == null){
            socketClient = new SocketClient();
        }
        
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
