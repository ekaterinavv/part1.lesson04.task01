package com;

/*3. Доработать классы MathBox и ObjectBox таким образом, чтобы MathBox был наследником ObjectBox.
 Необходимо сделать такую связь, правильно распределить поля и методы.
Функциональность в целом должна сохраниться. При попытке положить Object в MathBox должно создаваться исключение*/
public class Main {
    public static void main(String[] args) throws Exception {
        Test.testObjectBox();
        Test.testObjectBoxGeneric();
        Test.testMathBox();
        Test.testMathBoxCompare1();
        Test.testMathBoxCompare2();
        Test.testMathBoxCompare3();
    }
}
