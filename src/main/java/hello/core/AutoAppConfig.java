package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


//@ComponentScan은 @Component 어노테이션이 붙은 클래스들을 스프링빈으로 자동 등록
//basePackages와 basePackageClasses를 지정하지 않으면 @ComponentsScan이 붙은 클래스가 속한 패키지+하위패키지 모두를 탐색
//=> @ComponsneScan은 프로젝트 최상단 패키지에 두는 것을 권장 (basePackage설정을 생략할 수 있음)
@Configuration
@ComponentScan (
        basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //예제코드 정상동작을 위해 AppConfig 제외하기위함 (@Configuration어노테이션도 들어가보면 @Component를 포함하고있음)
public class AutoAppConfig {
    
    @Bean(name = "memoryMemberRepository")
    MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }

}
