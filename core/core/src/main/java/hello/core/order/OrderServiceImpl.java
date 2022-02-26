package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPlicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //OrderServiceImpl에서 FixDiscountPolicy를 선택하는 것은 OCP, DIP 위반
    //private DiscountPolicy discountPolicy = new FixDiscountPlicy();
    private DiscountPolicy discountPolicy; // 미선택시 널포인터 에러 발생 어떻게 해야 해결 할까?

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
