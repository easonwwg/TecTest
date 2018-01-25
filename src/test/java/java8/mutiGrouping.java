package java8;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author:eason
 * @Description
 * @Date: 20:55,2018/1/25
 * @ModifiedBy
 */
public class mutiGrouping {
    public static void main(String[] args) throws Exception {

    }

    @Test
    public void tt() throws Exception {
        List<po> lists = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        //1 --2    2--4 3--2  11--2
        lists.add(new po(sdf.parse("2018-01-01 00:21:10"), 20));
        lists.add(new po(sdf.parse("2018-01-02 12:21:10"), 30));
        lists.add(new po(sdf.parse("2018-01-03 10:21:10"), 10));
        lists.add(new po(sdf.parse("2018-01-02 08:21:10"), 60));
        lists.add(new po(sdf.parse("2018-01-11 00:21:10"), 90));
        lists.add(new po(sdf.parse("2018-01-11 05:21:10"), 10));
        lists.add(new po(sdf.parse("2018-01-01 01:21:10"), 20));
        lists.add(new po(sdf.parse("2018-01-02 20:21:10"), 40));
        lists.add(new po(sdf.parse("2018-01-03 10:21:10"), 30));
        lists.add(new po(sdf.parse("2018-01-02 00:21:10"), 10));

       /* Map<String, List<po>> groups = new TreeMap<>(
                new Comparator<String>(){
                    @Override
                    public int compare(String o1, String o2) throws  Exception{
                        return sdf.parse(o1).getDay()-sdf.parse(o2).getDay();
                    }
                }
        );*/

        //按照天分组
        Map<String, List<po>> groups = lists.stream().collect(Collectors.groupingBy(po -> {
            return sdf1.format(po.getDate());
        }));
        Map<String,List<po>> sortMap=new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(groups);
        for (Map.Entry<String, List<po>> item : sortMap.entrySet()) {
            System.out.println(item.getKey());
            List<po> itemList = item.getValue();
            System.out.println("最大值" + itemList.stream().max(Comparator.comparing(s -> s.getValue())).get().getValue());
            System.out.println("总共" + itemList.stream().map(s -> s.getValue()).collect(Collectors.summingInt(s -> s)));
            System.out.println("------------------------------");
        }

     /*  Map<String,Long> ss= lists.stream().collect(Collectors.groupingBy(po -> {
            return sdf1.format(po.getDate());
        },Collectors.counting()));*/


    }
}
class MapKeyComparator implements Comparator<String>{
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public int compare(String o1, String o2)  {
        try {
            return sdf.parse(o1).getDay()-sdf.parse(o2).getDay();
        }
        catch (ParseException pa){

        }
        return 0;
    }
}
class po {
    public po(Date date, int value) {
        this.date = date;
        this.value = value;
    }

    private Date date;
    private int value;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getGroupDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
