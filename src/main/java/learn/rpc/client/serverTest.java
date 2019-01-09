package learn.rpc.client;

import learn.rpc.server.HelloService;
import learn.rpc.server.HelloServiceImp;
import learn.rpc.server.ServiceCenter;
import learn.rpc.server.server;

public class serverTest {
    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                server serviceServer = new ServiceCenter(8088);
                serviceServer.register(HelloService.class, HelloServiceImp.class);
                try {
                    serviceServer.start();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }).start();
        System.out.print("thread has stop");
    }
}
