package com.sac.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * @author:eason
 * @Description：
 * @Date: 13:43,2018/1/16
 * @ModifiedBy
 */
public class MultisetTest {
    public static void main(String[] args) {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");
        multiset.add("b");
        multiset.add("b");
        System.out.println(multiset.contains("c"));
        System.out.println(multiset.size());
        System.out.println(multiset.count("b"));
        System.out.println(multiset.elementSet());
        System.out.println("-----------");
        for (Multiset.Entry<String> stringEntry : multiset.entrySet()) {
            System.out.println(stringEntry.getCount()+"--"+stringEntry.getElement());
        }


    }
}
