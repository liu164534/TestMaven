package com.abcd.javabase;

import com.abcd.entity.Men;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: TestMaven
 * @description: 创建对象的方式
 * @author: Liu Xinpeng
 * @create: 2021-05-21 17:17
 **/
public class CreatObject {


    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            NoSuchMethodException,
            InvocationTargetException, IOException {

        // 1 使用new关键字
        Men men = new Men();
        men.setName("new关键字创建对象");
        System.out.println(men);

        // 2 使用Class类的newInstance方法
        Men menTwo = (Men) Class.forName("com.abcd.entity.Men").newInstance();
        menTwo.setName("使用Class类的newInstance方法创建对象");
        System.out.println(menTwo);

        // 3 使用Constructor类的newInstance方法
        Constructor<Men> constructor = Men.class.getConstructor();
        Men menThree = constructor.newInstance();
        menThree.setName("使用Constructor类的newInstance方法");
        System.out.println(menThree);
        /**
         * 和Class类的newInstance方法很像，java.lang.reflect.Constructor类里也有一个newInstance方法可以创建对象
         * 我们可以通过这个newInstance方法调用有参数的和私有的构造函数
         * 这两种newInstance方法就是大家说的反射。事实上Class的newInstance方法内部调用的是Constructor的newInstance方法
         */

        // 4 使用clone方法 实现的Cloneable接口没有找到clone()方法
        // Men menFour = (Men) men.clone();

        // 5 使用反序列化
        // 当我们使用反序列化的时候，jvm会给我们创建一个单独的对象。在反序列化的时候，jvm并不会调用任何构造函数
        // 为了反序列化一个对象，我们需要让我们的类实现Serializable接口 ,应该是反序列化class文件
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("filePath"));
         Men menFive = (Men) in.readObject();
         menFive.setName("使用反序列化创建对象");
        System.out.println(menFive);
     }
}