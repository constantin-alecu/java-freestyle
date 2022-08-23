package core.nested.classes.inner;

public class Home {

    private String smth = "HHsmth";

    private class Room extends Home{ // al accesses
        private String smth = "RRsmth";
        public void enter(){
            System.out.println(smth);
            System.out.println(Home.this.smth);
            System.out.println("enter Room");
        }
    }

    void enter(){
        System.out.println("enter Home");
    }

    void enterRoom(){
        Room room = new Room();
        room.enter();
    }

    public static void main(String[] args) {
        Home home = new Home();
        Home room = home.new Room();
        home.enter();
        room.enter();
        room.enterRoom();
        System.out.println();
        Home.Room r1 = new Home().new Room();
        Room r2 = new Home().new Room();
//        Room r3 = new Room(); // it is not static class, no instantiation possible
    }
}
