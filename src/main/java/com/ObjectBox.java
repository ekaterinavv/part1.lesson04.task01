package com;

import java.util.HashSet;

/*Задание 2. Создать класс ObjectBox, который будет хранить коллекцию Object.
У класса должен быть метод addObject, добавляющий объект в коллекцию.
У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции и при наличии удаляющий его.
Должен быть метод dump, выводящий содержимое коллекции в строку.
*/
public class ObjectBox {
    HashSet<Object> collection;

    ObjectBox() {
        collection = new HashSet<>();
    }

    public void addObject(Object object) {
        if (object == null) {
            throw new NullPointerException("Exception: attempt to add null");
        } else {
            this.collection.add(object);
        }
    }

    public void deleteObject(Object object) {
        this.collection.remove(object);
    }

    public String dump() {
        String res = "Size = " + this.collection.size() + "\n";
        for (Object c : this.collection) {
            res += "class=" + c.getClass() + " object= " + c.toString() + "; \n";
        }
        return res;
    }

}
