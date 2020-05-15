/*
 * @program: 2020513
 * @description
 * 最小栈
 * @author: mrs.yang
 * @create: 2020 -05 -14 20 :38
 */

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack1;
    private Stack<Integer> minStack;
    public MinStack(){
        this.stack1=new Stack<>();
        this.minStack=new Stack<>();
    }
    //入栈
    public void push(int data){
        //如果最小栈没有元素
        if(this.minStack.empty()){
            this.stack1.push(data);
            this.minStack.push(data);
        }else{
            //最小栈中有元素
            int tmp=this.stack1.push(data);
            //比较data和最小栈，如果小于等于最小栈顶元素就放入
            if(tmp<=this.minStack.peek()){
                this.minStack.push(data);
            }
        }
    }
    //出栈
    public void pop(){
      if(!this.stack1.empty()){
          int tmp=this.stack1.pop();
          if(tmp==this.minStack.peek()){
              this.minStack.pop();
          }
      }
    }
    //拿到栈顶元素
    public int top(){
        if(this.stack1.empty()){
            return -1;
        }
        return this.stack1.peek();
    }
    //拿到最小的元素
    public int getMin(){
        if(this.stack1.empty()){
            return -1;
        }
        return this.minStack.peek();
    }

}
