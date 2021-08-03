package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
    
    @Test
    @DisplayName("print all bean")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name" + beanDefinitionName + "object = " + bean);
        }
    }

    @Test
    @DisplayName("print application bean")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            /*
            bean meta data
            ROLE_APPLICATION : USER REGISTER BEAN
            ROLE_INFRASTRUCTURE : SPRING INTERNAL USING/CREATE BEAN
            */
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name" + beanDefinitionName + "object = " + bean);
            }
        }
    }
}
