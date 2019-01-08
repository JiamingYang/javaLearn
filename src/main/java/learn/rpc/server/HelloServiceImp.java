package learn.rpc.server;

public class HelloServiceImp implements HelloService {

    @Override
    public String sayHello(String name) {
        return "server say hello to"+name;
    }
}
