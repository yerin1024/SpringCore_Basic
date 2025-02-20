package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        //세개 모두 동일한 객체를 참조하는 것을 볼 수 있음
        System.out.println("memberService -> memberRepository1 = "+memberRepository1);
        System.out.println("orderService -> memberRepository2 = "+memberRepository2);
        System.out.println("memberRepository = "+memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = "+bean.getClass()); //bean의 클래스타입
        //bean = class hello.core.AppConfig$$SpringCGLIB$$0
        //CGLIB이 붙으면 내가 만든 클래스가 아니라
        //스프링이 CGLIB라는 바이트코드 조작라이브러리를 사용해서 AppConfig클래스를 상속받은 임의의 클래스를 생성하고 빈으로 등록한 것임
        //이것이 싱글톤이 보장되도록 해줌
        //AppConfigCGLIB은 AppConfig를 상속받은 자식클래스
        //부모클래스로 조회하면 자식클래스 모두 조회가능하기 때문에 AppConfig bean = ac.getBean(AppConfig.class); 이걸로 조회가능
        //@Configuration 덕분에 싱글톤이 적용됨
    }

}
