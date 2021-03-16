package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test {
    static void testObjectBox() {
        System.out.println("Test1: ");
        // Исходные данные для ObjectBox
        Byte b = (byte) -3;
        Short s = (short) -2000;
        Integer i1 = 6;
        Integer i2 = 8;
        Character ch = 'k';
        Long l = 67000L;
        Double d = 3.56d;
        Float f = -19.2f;
        String str = "hello";
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "a");
        hashMap.put(2, "b");
        hashMap.put(3, "c");
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        // Работа с ObjectBox
        ObjectBox objectBox = new ObjectBox();
        objectBox.addObject(str);
        objectBox.addObject(i1);
        objectBox.addObject(f);
        //objectBox.addObject(null);
        objectBox.addObject(ch);
        objectBox.addObject(b);
        objectBox.addObject(s);
        objectBox.addObject(d);
        objectBox.addObject(l);
        objectBox.addObject(arrayList1);
        objectBox.addObject(hashMap);
        System.out.println(objectBox.dump());
        //Удалим элементы и выведем результат
        objectBox.deleteObject(b);
        objectBox.deleteObject(i1);
        objectBox.deleteObject(hashMap);
        objectBox.deleteObject(i1);
        objectBox.deleteObject(null);
        System.out.println(objectBox.dump());
    }

    static void testObjectBoxGeneric() {
        ObjectBox<Integer> objectBox = new ObjectBox<>();
        //При попытке положить Long в ObjectBox<Integer> ошибка компиляции
        // objectBox2.addObject(5l);
        objectBox.addObject(6);
        objectBox.addObject(7);
        System.out.println("Result objectBox2: " + objectBox.dump());
    }

    static void testMathBox() throws Exception {
        //Исходные данные для MathBox
        Integer i = 6;
        Number[] numbers = new Number[]{(byte) -3, (short) -2, -1, (byte) 1, i, 2.3f, 3.7d, (byte) 4, 5L,
                7L, 8f, 9};
        MathBox<Number> mathBox = new MathBox<>(numbers);
        System.out.println("Initial mathBox: " + mathBox.dump());
        //Операции над MathBox
        System.out.println("Sum = " + mathBox.summator());
        System.out.println("HashCode = " + mathBox.hashCode());
        mathBox.remove(15);
        mathBox.remove(9);
        mathBox.remove(i);
        System.out.println("Result mathBox: " + mathBox.toString());
        mathBox.splitter(-3d);
        // mathBox.splitter(new Double(0.0));
        System.out.println("Sum = " + mathBox.summator());
        System.out.println("Divided mathBox: " + mathBox.toString());
    }

    // Сравнение одинаковых Mathbox
    static void testMathBoxCompare1() throws Exception {
        Integer i = 6;
        Number[] numbers = new Number[]{(byte) -13, (short) 30, 15, (byte) 9, i, 12.3f, 18.7d, (byte) 1, 30L,
                31L, 10f, 102};
        MathBox<Number> mathBox1 = new MathBox<>(numbers);
        //Сравнение 2 MathBox
        Number[] numbers2 = new Number[]{(byte) -13, (short) 30, 15, (byte) 9, i, 12.3f, 18.7d, (byte) 1, 30L,
                31L, 10f, 102};
        MathBox<Number> mathBox2 = new MathBox<>(numbers2);
        System.out.println("Equals mathBox1 and mathBox2 = " + mathBox1.equals(mathBox2));
    }

    // Сравнение MathBox с разными типами данных
    static void testMathBoxCompare2() throws Exception {
        MathBox<Integer> mathBox1 = new MathBox<>(new Integer[]{1, 4, 6, 2, 14, 8, 9});
        MathBox<Byte> mathBox2 = new MathBox<>(new Byte[]{1, 4, 6, 2, 14, 8, 9});
        System.out.println("Equals mathBox1 and mathBox2 = " + mathBox1.equals(mathBox2));
    }

    // Сравнение MathBox с разными данными
    static void testMathBoxCompare3() throws Exception {
        Integer i = 6;
        Number[] numbers = new Number[]{(byte) -13, (short) 30, 15, (byte) 9, i, 12.3f, 18.7d, (byte) 1, 30L,
                31L, 10f, 102};
        MathBox<Number> mathBox1 = new MathBox<>(numbers);
        Number[] numbers2 = new Number[]{(byte) -13, (short) 30, 15, (byte) 19, i, 12.3f, 18.7d, (byte) 1, 30L,
                31L, 10f, 102};
        MathBox<Number> mathBox2 = new MathBox<>(numbers2);
        System.out.println("Equals mathBox1 and mathBox2 = " + mathBox1.equals(mathBox2));
    }

    static void testInsertObjectToMathbox() {
        //При попытке положить Object в MathBox ошибка компиляции
        //MathBox<String> mathBox6 = new MathBox<>(new String[]{"aaa", "bbb"});
    }
}
