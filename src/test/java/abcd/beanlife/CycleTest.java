package abcd.beanlife;

import com.abcd.beanlife.Student;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: TestMaven
 * @description: 测试类
 * @author: Liu Xinpeng
 * @create: 2021-05-14 10:50
 **/
public class CycleTest {


    /**
     * Bean的生命周期
     */
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student)context.getBean("student");
        // Bean的使用
        student.play();
        System.out.println(student);
        // 关闭容器
        context.close();
    }


    /**
     * 有后置处理的bean的生命周期
     */
    @Test
    public void afterBeanTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationAfterContext.xml");
        Student student = (Student) context.getBean("student");
        // Bean的使用
        student.play();
        System.out.println(student);
        // 关闭容器
        context.close();

    }
}