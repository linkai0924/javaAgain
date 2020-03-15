package juc.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "dfdf");
        ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<>();
        map.put(null, "ererere");

        System.out.println(map.get(null));
        System.out.println(map2.get(null));
    }
}
