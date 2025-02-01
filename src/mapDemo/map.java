package mapDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class map {
    public static void main(String[] args) {
        // 目标：完成Map集合相关的案例：投票统计程序。
    mapDemo();
    }

    public static void mapDemo(){
        //1.把80个学生选择的景点数据拿到一个集合中
        List<String> locations=new ArrayList<>();
        //创建一个数组，用来存储4个景点名称
        String[] names={"景点1","景点2","景点3","景点4"};
        //利用随机数原理将80个学生选择的景点数据放入集合中
        for (int i = 0; i < 80; i++) {
            //随机数原理
            int index=(int)(Math.random()*4);
            //将随机数对应的景点名称放入集合中
            locations.add(names[index]);
        }
        System.out.println(locations);

        //2、统计每个景点被选择的次数
        // 最终统计的结果是一个键值对的形式，所以可以考虑定义一个Map集合来统计结果。
        Map<String,Integer> map=new HashMap<>();

        //3 遍历集合，将景点名称和次数存入map数组中
        for (String location : locations){
            //判断景点是否存在，如果不存在，则添加到map集合中，如果存在，则次数加1
            if (map.containsKey(location)){
                //这个景点已经存在，次数加1
                map.put(location,map.get(location)+1);
            }else{
                //这个景点不存在，次数为1
                map.put(location,1);
            }

        }
        System.out.println(map);
    }
}
