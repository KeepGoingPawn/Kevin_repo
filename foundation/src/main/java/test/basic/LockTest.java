package test.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/6/17 9:39
 */
public class LockTest {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        try {
            lock.tryLock();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
