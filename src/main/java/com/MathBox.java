package com;

import java.util.*;

/*
Задание 1. Написать класс MathBox, реализующий следующий функционал:
Конструктор на вход получает массив Number. Элементы не могут повторяться.
Элементы массива внутри объекта раскладываются в подходящую коллекцию (выбрать самостоятельно).
Существует метод summator, возвращающий сумму всех элементов коллекции.
Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте
элементов на делитель, являющийся аргументом метода. Хранящиеся в объекте данные
полностью заменяются результатами деления.
Необходимо правильно переопределить методы toString, hashCode, equals, чтобы можно было использовать
MathBox для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap).
 Выполнение контракта обязательно!
Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
*/

public class MathBox<T extends Number> extends ObjectBox {

    public MathBox(T[] array) throws Exception {

        for (T a : array) {
            if (!super.collection.contains(a)) {
                super.addObject(a);
            } else {
                throw new Exception("Element " + a.doubleValue() + " already exist");
            }
        }
    }

    public double summator() {
        double sum = 0;
        for (Object c : this.collection) {
            sum += ((Number) c).doubleValue();
        }
        return sum;
    }

    public void splitter(double divider) throws Exception {
        if (divider == 0) {
            throw new Exception("Divided by zero");
        }
        System.out.println("Divided by " + divider);
        HashSet<Object> collectionDivision = new HashSet<>();
        for (Object c : this.collection) {
            collectionDivision.add(((Number) c).doubleValue() / divider);
        }
        this.collection = collectionDivision;
    }

    public void remove(Integer a) {
        super.collection.remove(a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.collection);
    }

    @Override
    public boolean equals(Object o) {
        //Проверка типов объектов
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }
        //Сравниваем сами коллекции
        HashSet<Object> setObj = ((MathBox) o).collection;
        if (!this.collection.equals(setObj)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String res = "Size = " + this.collection.size() + "\n";
        for (Object s : this.collection) {
            res += s + " ";
        }
        return res;
    }
}
