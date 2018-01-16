package com.sac.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Map;

/**
 * @author:eason
 * @Description：
 * @Date: 9:32,2018/1/16
 * @ModifiedBy
 */
public class TableTest {

    public static void main(String[] args) {
        Table<String, String, String> employeeTable = HashBasedTable.create();
        employeeTable.put("IBM", "101", "Mahesh");
        employeeTable.put("IBM", "102", "Ramesh");
        employeeTable.put("IBM", "103", "Suresh");

        employeeTable.put("Microsoft", "111", "Sohan");
        employeeTable.put("Microsoft", "112", "Mohan");
        employeeTable.put("Microsoft", "113", "Rohan");

        employeeTable.put("TCS", "121", "Ram");
        employeeTable.put("TCS", "122", "Shyam");
        employeeTable.put("TCS", "123", "Sunil");

        Map<String, String> tcs = employeeTable.row("TCS");
        for (Map.Entry<String, String> entry : tcs.entrySet()) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
        System.out.println("____________");
        for (String s : employeeTable.rowKeySet()) {
            System.out.println(s);
        }
        System.out.println("____________");
        Map<String, String> EmployerMap = employeeTable.column("122");
        for (Map.Entry<String, String> entry : EmployerMap.entrySet()) {
            System.out.println( entry.getKey() + "-- " + entry.getValue());
        }


    }
}
