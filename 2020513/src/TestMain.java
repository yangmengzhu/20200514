import java.util.*;

/*
 *
 * @program: 2020513
 * @description
 * 员工的重要度
 * @author: mrs.yang
 * @create: 2020 -05 -14 15 :16
 */
class Employee {
    public int id;
    public int importance;
    public  List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        return String.format("[%d,%d,[%d]",id,importance,subordinates);
    }
}

public class TestMain {
    public int getImportance(List<Employee> employees, int id){
        Map<Integer,Employee> map=new HashMap<>();
        for (Employee e:employees) {
            map.put(e.id,e);
        }
        Queue<Employee> queue=new LinkedList<>();
        queue.offer(map.get(id));
        int sum=0;
        while(!queue.isEmpty()){
            Employee e=queue.poll();//拿到的队头员工
            sum+=e.importance;
            for (int x :e.subordinates ) {
                queue.offer(map.get(x));
            }
        }
        return sum;
    }
    /*public int getImportance(List<Employee> employees, int id){
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int sum = 0;
        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            sum =sum+e.importance;
            for (int x: e.subordinates) {
                queue.offer(map.get(x));
            }
        }
        return sum;
    }*/
    public static void main(String[] args) {
        Map<Integer,Integer > map = new HashMap<>();
        map.put(1,1);
    }
}
