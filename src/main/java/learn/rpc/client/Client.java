package learn.rpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client<T> {
    public static <T> T getRemoteProxyObj(final Class<?> serviceInterface, final InetSocketAddress address){
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(),
                new Class<?>[]{serviceInterface},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = null;
                        ObjectInputStream inputStream=null;
                        ObjectOutputStream outputStream = null;
                        Object result = null;
                        try{
                            socket=new Socket();
                            socket.connect(address);

                            outputStream =new ObjectOutputStream(socket.getOutputStream());
                            outputStream.writeUTF(serviceInterface.getName());
                            outputStream.writeUTF(method.getName());
                            outputStream.writeObject(method.getParameterTypes());
                            outputStream.writeObject(args);
                            while (inputStream==null){
                                inputStream = new ObjectInputStream(socket.getInputStream());
                            }

                            result = inputStream.readObject();
                        }finally {
                            if (inputStream != null){
                                inputStream.close();
                            }
                            if (outputStream != null){
                                outputStream.close();
                            }
                            if (socket != null){
                                socket.close();
                            }
                        }
                        return result;
                    }
                });
    }
}
