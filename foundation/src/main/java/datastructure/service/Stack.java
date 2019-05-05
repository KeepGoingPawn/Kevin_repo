package datastructure.service;
/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/5/5 14:55
 */
public interface Stack<E> {
    /**
      * @Description: entry stack
      * @Date: 2019/5/5 14:57
      * @Param:
      * @Return:
      */
    void push(int item);
    /**
     * @Description out stack
     * @Date  17:29
     **/
    int pop();
    /**
     * @Description is empty
     * @Date  17:30
     **/
    boolean isEmpty();
    /**
     * @Description see the top element of stack
     * @Date 2019/4/29 17:32
     **/
    E peek();
}
