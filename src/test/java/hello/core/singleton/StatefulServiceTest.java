package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;


class StatefulServiceTest {
    /*
    Test for stateful singleton pattern issue
    price field is using commonly
    So when multi user access service it can be a problem
    */
    @Test
     void statefulServiceSingleton(){
         ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
         StatefulService s1 = ac.getBean(StatefulService.class);
         StatefulService s2 = ac.getBean(StatefulService.class);

         s1.order("user1", 1000);
         s2.order("user2", 2000);

         org.assertj.core.api.Assertions.assertThat(s1.getPrice()).isEqualTo(2000);
     }

    static class TestConfig{

         @Bean
        public StatefulService statefulService(){
             return new StatefulService();
         }
    }
}