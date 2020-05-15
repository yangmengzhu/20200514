/*
 * @program: 2020513
 * @description
 * 两个队列实现栈
 * @author: mrs.yang
 * @create: 2020 -05 -14 18 :58
 */

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    public MyStack(){
        this.queue1=new LinkedList<>();
        this.queue2=new LinkedList<>();
    }
    //入栈，哪个不为空就放到哪个队列中，两个都为空，就放到queue1中
    public void push(int data){
        if(queue1.isEmpty() &&queue2.isEmpty()){
            queue1.offer(data);
        }
        if(!queue1.isEmpty()){
            queue1.offer(data);
        }else{
            queue2.offer(data);
        }
    }
    //出栈
    public boolean empty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }
    public int pop(){
        if(empty()){
            return -1;
        }
        int val=0;
        int size1=queue1.size();
        int size2=queue2.size();
        if(!queue1.isEmpty()){

            while(size1-1>0){
                queue2.offer(queue1.poll());
                size1--;
            }
            val=queue1.poll();
        }else{
            while(size2-1>0){
                queue1.offer(queue2.poll());
                size2--;
            }
            val=queue2.poll();
        }
        return val;
    }
    public int top(){
        if(empty()){
            return -1;
        }
        int val=0;
        int size1=queue1.size();
        int size2=queue2.size();
        if(!queue1.isEmpty()){
            while(size1>0){
                val=queue1.poll();
                queue2.offer(val);
                size1--;
            }
        }else{
            while(size2>0){
                val=queue2.poll();
                queue1.offer(val);
                size2--;
            }
        }
        return val;
    }
}
