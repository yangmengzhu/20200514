/*
 * @program: 2020513
 * @description
 * 两个栈实现队列
 * @author: mrs.yang
 * @create: 2020 -05 -14 19 :56
 */

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    //入队
    public void push(int data){
        this.stack1.push(data);
    }
    //出队
    public boolean empty(){
        return this.stack1.empty()&& this.stack2.empty();
    }
    public int pop(){
       if(empty()){
           return -1;
       }
       int size1=this.stack1.size();
        int size2=this.stack1.size();
       //1.判断s2是否有元素
        if(!this.stack1.empty()){
            while (!this.stack1.empty()){
                this.stack2.add(this.stack1.pop());
            }
        }
        //如果s2中有，直接出栈顶元素
        return this.stack2.peek();
    }
}
