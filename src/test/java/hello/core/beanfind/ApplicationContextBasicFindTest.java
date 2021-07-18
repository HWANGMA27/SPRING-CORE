package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Bean find by name")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
//        System.out.println("memberServiee = "+ memberService);
//        System.out.printf("memberService.getClass() =" + memberService.getClass());
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("Bean find by type without name")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
//        System.out.println("memberServiee = "+ memberService);
//        System.out.printf("memberService.getClass() =" + memberService.getClass());
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("Bean find by implement object type")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
//        System.out.println("memberServiee = "+ memberService);
//        System.out.printf("memberService.getClass() =" + memberService.getClass());
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("Bean find by name doesn't exist")
    void findBeanByNameX(){
//        MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        //if ac.getBean throw noSuchBean exception this test will be suceess
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }
}
