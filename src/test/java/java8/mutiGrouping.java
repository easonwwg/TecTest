package java8;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author:eason
 * @Description
 * @Date: 20:55,2018/1/25
 * @ModifiedBy
 */
public class mutiGrouping {

    public static void main(String[] args) throws Exception {
        // ArrayList<Number> list = new ArrayList<Integer>(); //error
        //Number num = new Integer(1);
        //List<? extends Number> list1 = new ArrayList<Number>();
        //list1.add(new Integer(1)); //error

        //List<? extends Number> list001 = new ArrayList<Integer>();
        //List<? extends Number> list002 = new ArrayList<Float>();


    }


    /**
     * 获取任意时间的月最后一天
     * 描述:<描述函数实现的功能>.
     *
     * @param repeatDate
     * @return
     */
    public String getMinMonthDate(String repeatDate) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dft.parse(repeatDate));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
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

class load {
    private String startTime;
    private String endTime;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public load(String startTime, String endTime, String type) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }
}

class sub {
    private Long time;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public sub(Long time) {
        this.time = time;
    }
}
