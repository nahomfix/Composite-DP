import javax.swing.*;

public class CompositePatternDemo {
    public static void main(String[] args){
        Employee CEO = new Employee("John","CEO", 30000);

        Employee headSales = new Employee("Robert","Head Sales", 20000);

        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);


         //Prints all subordinate employees
        System.out.println("----- Subordinates of employee CEO ----- \n");
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);

            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }

        System.out.println("\nSalary of subordinates under employee CEO -> " + CEO.getSubordinatesTotalSalary());


        //Prints the bosses of employee clerk1
        System.out.println("\n----- Bosses of employee Clerk1 ----- \n");
        for (Employee emp : clerk1.getBosses()){
            System.out.println(emp);

            for (Employee e : emp.getBosses()){
                System.out.println(e);
            }
        }


    }
}
