package core.exceptions;

import java.io.IOException;
import java.rmi.RemoteException;

public class MyException extends /*Exception*/ /*RuntimeException*/ Error{

    public static void main(String[] args) {
        try {
            throwError();
        }catch (MyException e){
            System.out.println("MyError");
        }catch (Error e){
            System.out.println("Error");
        }

        try {
            throwChecked();
        } catch (CheckedEx e) {
            System.out.println("CheckedEx");
        }finally {
            System.out.println("recovered");
        }
//        throwError();
//        throw new MyException();

        try {
            overflow();
        }catch (StackOverflowError e){
            System.out.println("StackOverflowError");
        }catch (Error e){
            System.out.println("Error");
        }finally {
            System.out.println("recovered StackOverflowError");
        }

        try {
            int i = 0;
        }catch (NullPointerException e){}/*catch (CheckedEx)*/
        System.out.println("Finish");

    }
    static void throwError(){
        throw new MyException();
    }

    static void throwChecked() throws CheckedEx {
        throw new CheckedEx();
    }

    static void overflow(){
        overflow();
    }

    public void throwsDefinitionNoActualThrow() throws IOException{
        ;
    }
}
class CheckedEx extends Exception{}

class A{
    void uncheckedLow(){}
    void uncheckedHigh() throws RuntimeException{}
    void checkedLow(){}
    void checkedHigh() throws CheckedEx{}


}
class B extends A{
    void uncheckedLow() throws RuntimeException{}
    void uncheckedHigh(){}
//    void checkedLow() throws CheckedEx{}
    void checkedHigh(){}

}



