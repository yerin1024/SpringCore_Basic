package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //1. 조회: 호출할 때마다 객체 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할 때마다 객체 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인 => 호출할 때마다 객체가 새로 생성하는 것을 확인할 수 있음
        System.out.println("memberService1 = "+memberService1);
        System.out.println("memberService2 = "+memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);

        //우리가 만든 스프링 없는 순수한 DI컨테이너인 AppConfig는 요청을 할 때마다 객체를 새로 생성 => 메모리 낭비 심해짐
        //해결방안은 해당 객체가 딱 1개만 생성되고, 공유하도록 설계해야함 => 싱글톤 패턴
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
//        new SingletonService(); 불가능
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        //참조값이 동일한 것을 확인
        System.out.println("singletonService1 = "+singletonService1);
        System.out.println("singletonService2 = "+singletonService2);
        
        //isSameAs : 참조값 확인(객체) && isEqualTo : 실제값 비교
        assertThat(singletonService1).isSameAs(singletonService2);

    }

}
