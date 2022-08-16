package com.test.testproject.javatest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {

        // Map에 값을 전체 출력하기 위해서는 entrySet(), keySet() 메소드를 사용
        // entrySet() 메서드는 key와 value의 값이 모두 필요한 경우 사용하고, keySet() 메서드는 key의 값만 필요한 경우 사용
        // Map.Entry는 Map 형태의 인터페이스를 만드는데 사용, 실제 사용은 Map을 For문에서 돌려줄 경우 인터페이스 용도로 사용
        // 또는 스트림(Stream) 사용 시 Map 형식의 데이터에서 처리가 필요할 때 Map.Entry를 사용하여 처리

        //map 전체 출력 방법
        entryTest();
        keyTest();
        iteratorKTest();
        iteratorETest();
        lambdaTest();
        streamTest();

    }

    // entrySet 사용
    public static void entryTest(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        System.out.println("### entrySet Test ###");
        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
        System.out.println();
    }

    // keySet 사용
    public static void keyTest(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        System.out.println("### keySet Test ###");
        for(String key : map.keySet()){
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
        System.out.println();
    }

    // keySet().iterator 사용
    public static void iteratorKTest(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        System.out.println("### iterator_KeySet Test ###");
        Iterator<String> iteratorK = map.keySet().iterator();
        while (iteratorK.hasNext()){
            String key = iteratorK.next();
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
        System.out.println();
    }

    // entrySet().iterator 사용
    public static void iteratorETest(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        System.out.println("### iterator_EntrySet Test ###");
        Iterator<Map.Entry<String ,String>> iteratorE = map.entrySet().iterator();
        while (iteratorE.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iteratorE.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " " + value);
        }
        System.out.println();
    }

    // Lambda 사용
    public static void lambdaTest(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        System.out.println("### Lambda Test ###");
        map.entrySet().stream().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
        System.out.println();
    }

    // Stream 사용
    public static void streamTest(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        System.out.println("### Stream - 내림차순 Test ###");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry ->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
        System.out.println();

        System.out.println("### Stream - 오름차순 Test ###");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(entry ->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
        System.out.println();
    }
}

