package com.yhh.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GCTest {

    private static final int _1MB = 1024 * 1024;


    /**
     * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
     * -XX:+PrintTenuringDistribution
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];

        allocation3 = new byte[4 * _1MB];

        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
//        System.gc();
    }

    public void invoke() {
        List<Object> test = test();
        ref(test);
    }

    public List<Object> test() {
        return IntStream.range(0, 100).boxed().collect(Collectors.toList());
    }

    public void ref(List<Object> objects) {
        objects.forEach(obj -> System.out.println(obj));
    }
}
