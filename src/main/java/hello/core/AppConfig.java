package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean memberService() -> new MemoryMemberRepository()
    //@Bean orderService() -> new MemoryMemberRepository(), new RateDiscountPolicy()
    //이렇게 되면서 싱글톤이 깨지는것처럼 보이지만, ConfigurationSingletonTest를 보면 동일한 객체를 공유하는 것을 볼 수 있음 (싱글톤)
    //실제로 호출을 찍어보면 아래처럼 찍힘
    //호출 AppConfig.memberService
    //호출 AppConfig.memberRepository
    //호출 AppConfig.orderService
    //=> @Configuration 덕분임, Configuration없이 @Bean만 사용할 경우 스프링 빈으로 등록은 되지만, 싱글톤 적용이 안됨

    @Bean //스프링 컨테이너에 등록해줌
    public MemberService memberService() {
        System.out.println("호출 AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("호출 AppConfig.orderService");
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("호출 AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
