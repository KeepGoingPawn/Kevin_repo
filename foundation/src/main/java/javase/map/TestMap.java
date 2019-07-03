package javase.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/7/3 17:03
 */
public class TestMap {
    /**
     *      the type of map     Key is null     Value is null
     *        HashMap               √                 √
     *        Hashtable             ×                 ×
     *        ConcurrentHashMap     ×                 ×
     *        TreeMap               ×                 √
     */
    public static void main(String[] args) {
        Map<Object,Object> hm = new HashMap<>();
        Map<Object,Object> ht = new Hashtable<>();
        Map<Object,Object> chm = new ConcurrentHashMap<>();
        Map<Object,Object> tm = new TreeMap<>();

        try{
            hm.put("map",null);
        }catch (Exception e){
            System.out.println("hm value is null");
        }

        try{
            hm.put(null,null);
        }catch (Exception e){
            System.out.println("hm's key and value are null");
        }

        try{
            ht.put("map",null);
        }catch (Exception e){
            System.out.println("ht value is null");
        }

        try{
            ht.put(null,null);
        }catch (Exception e){
            System.out.println("ht's key and value are null");
        }

        try{
            chm.put("map",null);
        }catch (Exception e){
            System.out.println("chm value is null");
        }

        try{
            chm.put(null,null);
        }catch (Exception e){
            System.out.println("chm's key and value are null");
        }

        try{
            tm.put("map",null);
        }catch (Exception e){
            System.out.println("tm value is null");
        }

        try{
            tm.put(null,null);
        }catch (Exception e){
            System.out.println("tm's key and value are null");
        }
    }
}
