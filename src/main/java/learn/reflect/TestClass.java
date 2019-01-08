package learn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestClass {
    public static void main(String[] args) {
        Class cla1=null;
        try{
            cla1= Class.forName("learn.reflect.smallUser");
        }catch (ClassNotFoundException e){
            System.out.print("smallUser not exist");
        }
        System.out.print(cla1.toString());

        Constructor[] con=cla1.getDeclaredConstructors();
        for(Constructor constructor:con){
            try {
                Object object=constructor.newInstance();
                System.out.print(constructor.toString());

            }catch (IllegalAccessException e){

            }catch (InstantiationException e1){

            }catch (InvocationTargetException e2){

            }

        }
    }
}
