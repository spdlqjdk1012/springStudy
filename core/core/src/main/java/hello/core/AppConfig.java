package hello.core;

import hello.core.discount.FixDiscountPlicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService OrderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPlicy());
    }

}
