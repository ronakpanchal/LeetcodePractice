package com.leetcode.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeImportance {
	
   public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        for(Employee e:employees) map.put(e.id, e);
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(id);
        int total = 0;
        while (!q.isEmpty()) {
            int e = q.poll();
            total +=  map.get(e).importance;
            for (Integer employee:map.get(e).subordinates) q.add(employee);
        }
        return total;
    }
   
   class Employee {
	    public int id;
	    public int importance;
	    public List<Integer> subordinates;
	};

}
