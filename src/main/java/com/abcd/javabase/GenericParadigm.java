package com.abcd.javabase;

/**
 * @program: TestMaven
 * @description: 泛型
 * @author: Liu Xinpeng
 * @create: 2021-05-24 16:54
 **/
public class GenericParadigm <T> {

    String s = new String("123");
    int num = Integer.parseInt(s);

    Integer i = new Integer(10);
    Object o = i;
    // Object 是所有类的父类（超类）向上转型
    Integer integer = (Integer) o;
    // 错误的向下转型，类型不一致，编译器无法识别
    // String string = (String) o;

    String abc = new String("123");
    Object abcObject = abc;
    String abcString = (String) abcObject;
    // 错误的向下转型，类型不一致
    // Integer abcInteger = (Integer) abcObject;

    /**
     * 在Object显示转换存在不安全行为的情况下，出现了泛型，通过泛型可以有效避免类型转换的时候出现的问题
     * 泛型简单理解就是在类、接口、方法中定义未知类型的变量，只有初始化的时候才知道真正的类型。在定义的类
     * 或者接口方法中可以使用这个未知类型进行操作
     * T 叫做通配符，T,E,K,V 分别代表类型、元素、键、值，不是硬性规定
     */

    private T value;

    public GenericParadigm(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {

        // T 可以在类中自由使用，暂时不需要知道是什么类型，初始化的时候编译器进行判断
        GenericParadigm<String> abc = new GenericParadigm<>("abc");
        String value = abc.getValue();
        System.out.println(value);

        GenericParadigm<Integer> integerGenericParadigm = new GenericParadigm<>(123);
        Integer valueInt = integerGenericParadigm.getValue();
        System.out.println(valueInt);
    }

    /**
     * 泛型接口和泛型类有所区别，子类在继承泛型接口的时候需要声明泛型的类型，否则编译会报错
     * 泛型接口如果进行继承依然想使用泛型的话就需要在继承的类中事先定义好接口的部分的泛型类供接口使用
     * class 类 <A,B,C>implements 接口<C>
     */

    /**
     * 泛型方法的使用和泛型类泛型接口类似，菱形需要放到函数类型前边
     * public   <T1,T2> void fuc(T1 t1,T2 t2)
     * {
     *      System.out.println(t1);
     *      System.out.println(t2);
     *  }
     */

    /**
     * 边界限定
     * 1。类型的上界 格式为：<? extends T>,即类型必须为T类型或者是T类型的子类
     * 2。类型的下界 格式为：<? super T>，即类型必须为T或者是T的父类
     */

}