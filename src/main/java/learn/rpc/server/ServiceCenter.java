package learn.rpc.server;

import com.sun.corba.se.spi.activation.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceCenter implements server {
    private static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static final HashMap<String , Class> registerCentor = new HashMap<String , Class>();
    private static boolean isRunning = false;
    private static int port;

    public ServiceCenter(int port){
        this.port = port;
    }
    @Override
    public boolean isRunning() {
       return this.isRunning;
    }

    @Override
    public int getPort() {
       return this.port;
    }

    @Override
    public void register(Class serviceInterface, Class impl) {
        registerCentor.put(serviceInterface.getName(),impl);
    }

    @Override
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));
        System.out.print("start server");

        try{
            while (true){
                executorService.execute(new ServiceTask(serverSocket.accept()));
            }
        }finally {
            serverSocket.close();
        }
    }

    @Override
    public void stop() {
       isRunning = false;
       executorService.shutdown();
    }

    private class ServiceTask implements Runnable{
        Socket client = null;

        public ServiceTask(Socket client ){
            this.client = client;
        }
        @Override
        public void run() {
            ObjectInputStream input = null;
            ObjectOutputStream output = null;
            try {
                input= new ObjectInputStream(client.getInputStream());
                String serviceName = input.readUTF();
                String methodName=input.readUTF();
                Class<?>[] parameterType = (Class<?>[])input.readObject();
                Object[] argument = (Object[])input.readObject();
                Class serviceClass = registerCentor.get(serviceName);

                if(serviceClass == null){
                    throw new ClassNotFoundException("serviceClass not found");
                }
                Method method = serviceClass.getMethod(methodName,parameterType);
                Object result = method.invoke(serviceClass.newInstance(),argument);

                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);
            }catch (IOException E){
                System.out.print("read from Client false");
            }catch (Exception e){
               e.printStackTrace();
            }finally {
                if(output!=null){
                    try {
                        output.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                if(input!=null){
                    try {
                        input.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                if(client!=null){
                    try {
                        client.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }

        }
    }
}
