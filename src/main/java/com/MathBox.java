package com;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

// MathBox - наследник ObjectBox, но с типом Number
public class MathBox<T extends Number> extends ObjectBox<T> {

    public MathBox(T[] array) {
        for (T a : array) {
            if (!super.collection.contains(a)) {
                super.addObject(a);
            } else {
                try {
                    throw new Exception("Element " + a.doubleValue() + " already exist");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public double summator() {
        double sum = 0;
        for (T c : this.collection) {
            sum += c.doubleValue();
        }
        return sum;
    }

    public void splitter(T divider) {
        if (Double.compare(divider.doubleValue(), 0.0d) == 0) {
            try {
                throw new Exception("Divided by zero");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("Divided by " + divider);
        Set<Number> collectionDivision = new HashSet<>();
        for (T c : this.collection) {
            collectionDivision.add(c.doubleValue() / divider.doubleValue());
        }
        this.collection = (HashSet<T>) collectionDivision;
    }

    public void remove(Integer a) {
        System.out.println("Remove  " + a);
        super.collection.remove(a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.collection);
    }

    @Override
    public boolean equals(Object o) {
        //Проверка ссылок
        if (this == o) return true;
        //Проверка типов объектов
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }
        //Сравниваем сами коллекции
        MathBox altMathBox = ((MathBox) o);
        return this.collection.equals(altMathBox.collection);
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
