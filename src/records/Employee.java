package records;

import java.util.ArrayList;
import java.util.List;

class PersonClass /*extends Employee()*/{}

interface Person{}

public record Employee(List<String> list) /*extends PersonClass*/ implements Person{

    public static void main(String[] args) {
        var emp = new Employee(new ArrayList<>());
        emp.list().add("s");
    }

    @Override
    public List<String> list(){
        return new ArrayList<>(this.list);
    }

    public void addElement(String s){
        this.list.add(s);
    }
}


