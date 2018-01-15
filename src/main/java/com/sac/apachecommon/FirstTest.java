package com.sac.apachecommon;

import com.sac.pojo.UserGuava;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.iterators.FilterIterator;
import org.apache.commons.collections.iterators.UniqueFilterIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author:eason
 * @Description
 * @Date: 20:27,2018/1/15
 * @ModifiedBy
 */
public class FirstTest {
    public static void main(String[] args) {
        List<UserGuava> list = new ArrayList<UserGuava>();
        UserGuava user = new UserGuava();
        user.setAge(1);
        user.setName("Apple");
        list.add(user);
        user = new UserGuava();
        user.setAge(2);
        user.setName("Facebook");
        list.add(user);
        user = new UserGuava();
        user.setAge(3);
        user.setName("Twitter");
        list.add(user);
        user = new UserGuava();
        user.setAge(4);
        user.setName("Youtube");
        list.add(user);
        user = new UserGuava();
        user.setAge(5);
        user.setName("Telerik");
        list.add(user);
        user = new UserGuava();
        user.setAge(6);
        user.setName("Google");
        list.add(user);
        user = new UserGuava();
        user.setAge(6);
        user.setName("Google");
        list.add(user);

        Predicate predicate
                = new Predicate() {
            public boolean evaluate(Object o) {
                UserGuava u = (UserGuava) o;
                return u.getAge() > 2;
            }
        };
        Iterator<?> iterator
                =new FilterIterator(list.iterator(),predicate);
        while (iterator.hasNext()){
            UserGuava userGuava =(UserGuava) iterator.next();
            System.out.println(userGuava.getName()+"-"+userGuava.getAge());
        }
        System.out.println("-------------------你懂的------------------------");
        Iterator iterator1=new UniqueFilterIterator(list.iterator());
        while (iterator1.hasNext()){
            UserGuava userGuava =(UserGuava) iterator1.next();
            System.out.println(userGuava.getName()+"-"+userGuava.getAge());
        }
    }

}
