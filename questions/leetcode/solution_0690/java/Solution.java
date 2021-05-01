package solution_0690.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. 员工的重要性
 *
 * @author ZhouYi
 * 2021/5/1 9:53 下午
 */

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class Solution {

    Map<Integer, Employee> employeeMap = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for(Employee employee : employees){
            employeeMap.put(employee.id, employee);
        }
        return dfs(id);
    }

    public int dfs(int id){
        final Employee employee = employeeMap.get(id);
        int totalImportance = employee.importance;
        for(Integer subId : employee.subordinates){
            totalImportance += dfs(subId);
        }
        return totalImportance;
    }

}
