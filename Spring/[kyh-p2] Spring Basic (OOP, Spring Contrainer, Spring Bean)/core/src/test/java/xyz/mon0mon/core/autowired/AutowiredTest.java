package xyz.mon0mon.core.autowired;

import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.mon0mon.core.member.Member;

import java.util.*;

public class AutowiredTest {
    @Test
    void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    /**
     * Intellij 유료버전을 사용할 경우, 다음과 같은 경고 출력
     * Autowired members must be defined in valid Spring bean (@Component|@Service|...)
     * 의존관계를 주입하려는 빈이 현재 스프링 컨테이너에서 관리되고 있지 않다는 경고
     */
    static class TestBean {
        /**
         * @Autowired인 경우 기본적으로 required 옵션은 true로 설정
         * 해당하는 빈이 없을 경우에는 NoSuchBeanDefinitionException 예외 발생
         * 명시적으로 required를 false로 설정 가능
         * 이 때는 스프링 컨테이너에서 대상 빈이 없으면, 실행이 되지 않음
         */
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        /**
         * 스프링 빈을 가져올 때 앞에 @Nullable을 선언할 경우
         * 스프링 컨테이너에 대상 빈이 없더라도 내부 함수는 실행이 됨
         * 이 때 대상 빈이 없기에 null 값이 할당
         */
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        /**
         * 스프링 빈을 가져올 때 Optional로 래핑해서 가져오는 경우
         * @Nullable과 동일하지만, Optional 형식으로 가져옴
         * 내부 함수는 동일하게 실행
         */
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
