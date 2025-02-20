package hello.core.singleton;

public class StatefulService {

    //이렇게 만들면 필드가 공유되버림 => 스프링 빈은 항상 무상태(stateless)로 설계해야 한다.
//    private int price; //상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = "+name+" price = "+price);
//        this.price = price; //여기가 문제!
        return price;
    }

//    public int getPrice() {
//        return price;
//    }

}
