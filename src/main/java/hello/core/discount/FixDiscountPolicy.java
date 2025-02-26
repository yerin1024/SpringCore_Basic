package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//정액
@Component
public class FixDiscountPolicy implements DiscountPolicy{
    
    private int discountFixAmount = 1000; //1000원 할인으로 고정
    
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) { //enum은 ==으로 체크해야함
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
