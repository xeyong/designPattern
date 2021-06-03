package com.company;

import com.company.adapter.*;
import com.company.decorator.*;
import com.company.facade.Ftp;
import com.company.facade.Reader;
import com.company.facade.SftpClient;
import com.company.facade.Writer;
import com.company.observer.Button;
import com.company.observer.IbuttonListner;
import com.company.proxy.Browser;
import com.company.proxy.BrowserProxy;
import com.company.proxy.IBrowser;
import com.company.proxy_aop.AopBrowser;
import com.company.singleton.Aclazz;
import com.company.singleton.Bclazz;
import com.company.singleton.SocketClient;
import com.company.strategy.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    /*
    public static void main(String[] args) {
        -------------싱글톤-------------
        Aclazz a = new Aclazz();
        Bclazz b = new Bclazz();

        SocketClient aclient = a.getSocketClient();
        SocketClient bclient = b.getSocketClient();
        
        if(aclient == bclient){
            System.out.println("싱글톤을 활용하면 1개의 객체를 공유하기때문에 같은객체를 참조하고");
        }
        if(aclient.equals(bclient)){
            System.out.println("같은객체이다");
        }
    }
     */
    /*
    public static void main(String[] args) {

        --------Adapter패턴---------
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        //connect(cleaner);
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);
        Aircon aircon = new Aircon();
        adapter = new SocketAdapter(aircon);
        connect(adapter);


    }
    */
    /*
    -----프록시패턴------
    public static void main(String[] args) {
        프록시 사용전
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        프록시 사용후
        BrowserProxy browserProxy = new BrowserProxy("www.naver.com");
        browserProxy.show();
        browserProxy.show();
        browserProxy.show();
        browserProxy.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end =new AtomicLong();

        IBrowser aop = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });
        aop.show();
        System.out.println("loading time: " + end.get());
        aop.show();
        System.out.println("loading time: " + end.get());//cache를 활용해서 0초가 걸림
    }
    */
    /*
    ----데코레이터 패턴-----
    public static void main(String[] args) {
        Icar audi = new Audi(1000);
        audi.showPrice();

        //a3
        Icar audi3 = new A3(audi, "A3");
        audi3.showPrice();
        //a4
        Icar audi4 = new A4(audi, "A4");
        audi4.showPrice();
        //a5
        Icar audi5 = new A5(audi, "A3");
        audi5.showPrice();
    }
    */
    /*
    ------옵저버패턴---------
    public static void main(String[] args) {
        Button button = new Button("버튼");
        button.addListnener(new IbuttonListner() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("메시지 전달: clcik1");
        button.click("메시지 전달: clcik2");
        button.click("메시지 전달: clcik3");
        button.click("메시지 전달: clcik4");
    }
     */
    /*
    public static void main(String[] args) {
        Ftp ftpClient = new Ftp("www.foo.co.kr",22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();
        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        SftpClient sftpClient = new SftpClient("www.foo.co.kr",22,"/home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.read();
        sftpClient.disConnect();

    }
    */
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        //base64
        EncodingStrategy base64 = new Base64Strategy();
        //normal
        EncodingStrategy normal = new NormalStrategy();

        String message="hello java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);

    }

    //adapter패턴 콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
