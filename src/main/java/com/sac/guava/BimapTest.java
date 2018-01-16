package com.sac.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author:eason
 * @Description：
 * @Date: 13:57,2018/1/16
 * @ModifiedBy
 */
public class BimapTest {
    public static void main(String[] args) {
        BiMap<Integer, String> empIDNameMap = HashBiMap.create();
        empIDNameMap.put(new Integer(101), "Mahesh");
        empIDNameMap.put(new Integer(102), "Sohan");
        empIDNameMap.put(new Integer(103), "Ramesh");
        empIDNameMap.put(new Integer(103), "sac");
        System.out.println(empIDNameMap.inverse().get("Mahesh"));
        System.out.println("---------------");
        System.out.println(empIDNameMap.inverse());
    }
}
