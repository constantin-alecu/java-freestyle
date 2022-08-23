package core;

public class Labels {

    public static void main(String[] args) {
        PARENT_LOOP: for (int i = 0; i < 10; i++) {
            CHILD_LOOP:for (int j = 0; j < 10; j++) {
                if (j < 5){
                    break CHILD_LOOP;
                }
            }
            if(i > 6){
                continue PARENT_LOOP;
            }
            i++;
        }
    }
}
