package core.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;

public class TryWithResources {

    public static void main(String[] args) throws FileNotFoundException {

        try (PlasaTantari plasa = new PlasaTantari();
             Door door = new Door()) {
            System.out.println("enter home");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Window cracked");
        }finally {
//            door.close(); door out of scope
            System.out.println("Done entering home");
        }

        System.out.println("--------break--------");

        final Door door = new Door();
        PlasaTantari plasa = new PlasaTantari();
        try(plasa; door){ //effective final
            System.out.println("inside try");
        }
//        plasa = new PlasaTantari();

        try(Door d = null; Door c = new Door()) {
            System.out.println("x");
        }
    }
}

class Door implements AutoCloseable{

    public Door(){
        System.out.println("opening door");
    }

    @Override
    public void close()  {
        System.out.println("closing door");
    }
}

class PlasaTantari implements AutoCloseable{

    public PlasaTantari(){
        System.out.println("opening plasa");
    }

    @Override
    public void close(){
        System.out.println("closing plasa");
    }
}