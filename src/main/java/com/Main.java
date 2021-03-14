package com;

import java.util.*;

/*3. Доработать классы MathBox и ObjectBox таким образом, чтобы MathBox был наследником ObjectBox.
 Необходимо сделать такую связь, правильно распределить поля и методы.
Функциональность в целом должна сохраниться. При попытке положить Object в MathBox должно создаваться исключение*/
public class Main {
    public static void main(String[] args) throws Exception {
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

        //Исходные данные для MathBox
        Integer i3 = 6;
        Number[] numbers = new Number[]{(byte) -13, (short) 30000, 15, (byte) 9, i3, 12.3f, 18.7d, (byte) 1, 30L,
                31L, 10f, 102};
        MathBox<Number> mathBox = new MathBox<>(numbers);
        System.out.println("Initial mathBox: " + mathBox.dump());
        //Сравнение 2 MathBox
        Number[] numbers2 = new Number[]{(byte) -13, (short) 30000, 15, (byte) 9, i3, 12.3f, 18.7d, (byte) 1, 30L,
                31L, 10f, 102};
        MathBox<Number> mathBox2 = new MathBox<>(numbers2);
        //Поменяем тип первого элемента
        Number[] numbers3 = new Number[]{(short) -13, (short) 30000, 15, (byte) 9, i3, 12.3f, 18.7d, (byte) 1, 30L,
                31L, 10f, 102};
        MathBox<Number> mathBox3 = new MathBox<>(numbers3);
        System.out.println("Equals mathBox1 and mathBox2 = " + mathBox.equals(mathBox2));
        System.out.println("Equals mathBox1 and mathBox3 = " + mathBox.equals(mathBox3));
        //Операции над MathBox
        System.out.println("Sum = " + mathBox.summator());
        System.out.println("HashCode = " + mathBox.hashCode());
        mathBox.remove(15);
        mathBox.remove(9);
        mathBox.remove(i3);
        mathBox.splitter(-3);
        System.out.println("Result mathBox: " + mathBox.toString());
        //При попытке положить Object в MathBox ошибка компиляции
        //MathBox<Number> mathBox3 = new MathBox<>(new Object[]{new Integer(23)});
    }
}
