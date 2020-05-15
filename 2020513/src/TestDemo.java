/*
 * @program: 2020513
 * @description
 * 杨辉三角
 * @author: mrs.yang
 * @create: 2020 -05 -14 13 :15
 */

import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> ret=new ArrayList<>();//二维数组类似
        if(numRows==0){
           return ret;
        }
        ret.add(new ArrayList<>());
        ret.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRows=new ArrayList<>();//当前行
            //第一个元素
            curRows.add(1);
            //第二行开始计算
            List<Integer> prevRows=ret.get(i-1);//前一行
            for (int j = 1; j < i; j++) {//列
              int x=prevRows.get(j);
              int y=prevRows.get(j-1);
              curRows.add(x+y);
            }
            //最后一个元素
            curRows.add(1);
            ret.add(curRows);
        }
        return ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> ret=generate(5);
        System.out.println(ret);
    }
}
