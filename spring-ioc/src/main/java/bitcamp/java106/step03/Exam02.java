package bitcamp.java106.step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam02 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("bitcamp/java106/step03/application-context-02.xml");
        
        BeanUtils.printBeanNames(iocContainer);
    }
}
