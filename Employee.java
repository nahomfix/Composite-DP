import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;
    private List<Employee> bosses;

    public Employee(String name,String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
        bosses = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
        if (!(e.bosses.contains(this)) && this.subordinates.contains(e)){
            e.bosses.add(this);
        }
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    public String toString(){
        return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary : " + salary + " ]");
    }

    public int getSubordinatesTotalSalary(){
        int totalSalary = 0;
        for (int i = 0; i < subordinates.size(); i++){
            totalSalary += subordinates.get(i).salary;
        }
        return totalSalary;
    }

    public List<Employee> getBosses(){
        return this.bosses;
    }
}
