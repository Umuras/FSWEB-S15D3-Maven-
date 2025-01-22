package org.example;


import org.example.entity.Employee;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee(1,"Ali","Kucur"));
        employeeList.add(new Employee(1,"Ali","Kucur"));
        employeeList.add(new Employee(2,"Umur","Kucur"));
        employeeList.add(new Employee(3,"Hasan","Şendağlı"));
        employeeList.add(new Employee(4,"Mustafa","Kaçmaz"));
        employeeList.add(new Employee(5,"Engin","Tanöz"));



        //System.out.println(findDuplicates(employeeList));
        //System.out.println(WordCounter.calculatedWord());
    }

    public static List<Employee> findDuplicates(List<Employee> employeeList)
    {
        List<Employee> sameEmployeeList = new LinkedList<>();
        nullClear(employeeList);
        for (int i = 0; i < employeeList.size(); i++) {
            for (int j = 0; j < employeeList.size(); j++) {
                if(i!=j)
                {
                    if(employeeList.get(i).equals(employeeList.get(j)))
                    {
                        if(sameEmployeeList.isEmpty())
                        {
                            sameEmployeeList.add(employeeList.get(i));
                        }else{
                            boolean haveSameEmployee = false;
                            for (int k = 0; k < sameEmployeeList.size(); k++) {
                                if(sameEmployeeList.get(k).equals(employeeList.get(i)))
                                {
                                    haveSameEmployee = true;
                                }
                            }
                            if (!haveSameEmployee)
                            {
                                sameEmployeeList.add(employeeList.get(i));
                            }
                        }
                    }
                }
            }
        }
        return sameEmployeeList;
    }

    public static Map<Integer,Employee> findUniques(List<Employee> employeeList)
    {
        Map<Integer,Employee> employeeMap = new HashMap<>();
        List<Employee> sameEmployeeList = findDuplicates(employeeList);


        for (int i = 0; i < sameEmployeeList.size(); i++) {
            employeeMap.put(sameEmployeeList.get(i).getId(),sameEmployeeList.get(i));
        }

        for (int i = 0; i < employeeList.size(); i++) {
            boolean haveSameEmployee = false;
            if(employeeList.get(i) == null)
            {
                continue;
            }
            for (Map.Entry entry : employeeMap.entrySet())
            {
                if(entry.getValue().equals(employeeList.get(i)))
                {
                    haveSameEmployee = true;
                }
            }
            if (!haveSameEmployee)
            {
                employeeMap.put(employeeList.get(i).getId(),employeeList.get(i));
            }
        }

        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employeeList)
    {
        //Difference kullanılarak yapılacak
        //Nesne oluştururken eşitliğin sol tarafı reference ve instanceı sağ tarafı objeyi yaratıyor.
        //new HashSet<>(employeeList).stream().toList()
        List<Employee> sameEmployeeList = findDuplicates(employeeList);
        nullClear(employeeList);
        employeeList.removeAll(sameEmployeeList);
        return employeeList;
    }

    public static void nullClear(List<Employee> employeeList)
    {
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i) == null)
            {
                employeeList.remove(employeeList.get(i));
            }
        }
    }
}