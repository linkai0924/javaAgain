package jdk.test;

import java.util.HashMap;

public class HashCodeTest {
    public static void main(String[] args) {
        HashMap<String,String> map=new HashMap<>();
        map.put("dfdfd","dfdfd");
        System.out.println(map);
        System.out.println(map.hashCode());
    }
}
