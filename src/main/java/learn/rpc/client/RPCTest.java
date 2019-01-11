package learn.rpc.client;

import learn.rpc.server.HelloService;
import learn.rpc.server.HelloServiceImp;
import learn.rpc.server.ServiceCenter;
import learn.rpc.server.server;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;


public class RPCTest {
    public static void main(String[] args) throws IOException {
        HelloService helloService = Client.getRemoteProxyObj(HelloService.class , new InetSocketAddress(8088));

        System.out.print(helloService.sayHello("test"));
    }
}
