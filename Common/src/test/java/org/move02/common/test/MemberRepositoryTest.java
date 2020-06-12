package org.move02.common.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.move02.common.ModuleCommonAppliationTests;
import org.move02.common.member.Member;
import org.move02.common.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ModuleCommonAppliationTests.class)
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void test(){
        List<Member> members =  memberRepository.findAll();
        System.out.println(members);
        assertThat(members.get(0), isA(Member.class));
    }

}
