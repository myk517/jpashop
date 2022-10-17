package jpabook.jpashop.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberSerivce;
    @Autowired MemberRepository memberRepository;
    
    @Test
    public void 회원가입() {
        //Given
        Member member = new Member();
        member.setName("kim");
        
        //When
        Long saveId = memberSerivce.join(member);
        
        //Then
        assertEquals(member, memberRepository.findOne(saveId));
    }
    
    @Test(expected = IllegalStateException.class)
    public void 중복회원예외() throws Exception{
        //Given
        Member member1 = new Member();
        member1.setName("kim");
        
        Member member2 = new Member();
        member2.setName("kim");

        //When
        memberSerivce.join(member1);
        memberSerivce.join(member2); //예외 발생 해야 함.
        
        //Then
        fail("예외 발생 해야 함");
        
    }
    
}