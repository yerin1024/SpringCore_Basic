package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        //new AnnotationConfigApplicationContext(PrototypeBean.class); 
        // =>이렇게 빈으로 등록하고 싶은 클래스명을 넣어주면 컴포넌트 스캔처럼 동작해서 스프링 빈으로 등록됨
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = "+prototypeBean1);
        System.out.println("prototypeBean2 = "+prototypeBean2);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        prototypeBean1.destroy(); //종료하고 싶으면 이렇게 수동으로 호출해줘야함
        prototypeBean2.destroy(); //종료하고 싶으면 이렇게 수동으로 호출해줘야함
        ac.close(); //스프링컨테이너는 종료되지만 프로토타입빈의 destroy는 실행되지 않음
        
    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.preDestroy");
        }

    }

}
