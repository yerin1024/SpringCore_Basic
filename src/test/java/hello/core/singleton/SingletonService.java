package hello.core.singleton;

public class SingletonService {

    //자기자신을 내부에 static으로 가지면
    //자바가 실행되면서 static영역에 딱 하나만 존재하게되고 참조값을 instance에 넣어둠
    //객체 사용하려면 getInstance만 사용하도록 private 생성자와 getInstance를 만들어둠 (new를 방지)
    //아래의 코드는 싱글톤 패턴 구현방식 중 객체를 미리 생성해두는 가장 단순하고 안전한 방법중 하나이고, 방법은 여러가지가 있음
    //스프링컨테이너를 사용하면 기본적으로 객체를 싱글톤으로 만들어서 관리해주고 싱글톤 패턴의 문제점을 모두 보완해줌
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //private 생성자를 만들어서 new SingletonService를 못하도록 막음
    private SingletonService() {};
    
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
