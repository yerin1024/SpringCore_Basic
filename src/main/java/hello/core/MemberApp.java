package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //스프링 컨테이너라고 보면됨 객체들 관리해줌(Bean) : AppConfig에 있는 설정들을 보고 객체만들어서 컨테이너에서 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member newMember = new Member(1L, "memberA", Grade.VIP);
        memberService.join(newMember);

        Member findMember = memberService.findMember(1L);

        System.out.println("newMember = " + newMember.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
