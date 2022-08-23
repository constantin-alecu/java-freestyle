package core.io;

import java.io.*;

public class Serialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        User userToWrite = new User("Jay");
//        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("User.txt")))){
//            out.writeObject(userToWrite);
//        }
//        System.out.println("user = " + userToWrite);
//        User.type = "global set";
//        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("User.txt")))){
//            System.out.println("user = " + in.readObject());
//        }

        UserRecord userToWrite = new UserRecord("Jay", "password");
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("User.txt")))){
            out.writeObject(userToWrite);
        }
        System.out.println("user = " + userToWrite);
        User.type = "global set";
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("User.txt")))){
            System.out.println("user = " + in.readObject());
        }
    }
}

record UserRecord(String name, String password) implements Serializable{

    @Override
    public String toString() {
        return """
                User{name=%s, password=%s""".formatted(name, password);
    }

    UserRecord{
        System.out.println("constructor called");
    }
}
class User implements Serializable {

    public static String type;
    private String name;
    private transient String password = "password";

    {this.password = "default->CodeBlock";}

    public User(String name) {
        this.name = name;
        this.password = "default->Constructor";
        type = "1 arg constructor";
    }
    public User(){
        this.name = "Unknown";
        this.password = "N/A";
        type = "no arg constructor";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return """
                User{name=%s, password(transient)=%s, type(static)=%s}""".formatted(name, password, type);
    }
}

