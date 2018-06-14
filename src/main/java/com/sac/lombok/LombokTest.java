package com.sac.lombok;

/**
 * @author:eason
 * @Description
 * @Date: 20:18,2018/4/18
 * @ModifiedBy
 */
public class LombokTest {
    public static void main(String[] args) {
        Stu stu = new Stu();
        stu.setCountry("sac");
        stu.setName("wwg");

        Stu stu1 = Stu.builder().country("sac").name("wwg").build();

        //val定义表示是final 不可变的
        //val s = "xx";
        //var 表示是可变的
        //var ss = new HashMap<String, String>();
    }
}
