package javase.serializable;

import java.io.*;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/7/3 14:22
 */
public class SerializableTest {

    public static void main(String[] args) throws Exception{
        serializePeople();
        People p = deserializePeople();
        System.out.println(p.toString());
    }

    private  static void serializePeople() throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("d:/people.txt")));;
        try {
           People p = new People();
           p.setAge(11);
           p.setName("kevin");
           p.setWeight(80);
           oos.writeObject(p);
       }catch (Exception e){
            e.printStackTrace();
       }finally {
            oos.close();
       }
    }

    private static People deserializePeople() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("d:/people.txt")));
        People person = (People) ois.readObject();
        System.out.println("FlyPig 对象反序列化成功！");
        return person;
    }

}
