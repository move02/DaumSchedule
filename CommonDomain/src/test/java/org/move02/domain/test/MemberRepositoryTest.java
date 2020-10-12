package org.move02.domain.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.move02.domain.ModuleCommonAppliationTests;
import org.move02.domain.Member;
import org.move02.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ModuleCommonAppliationTests.class)
public class MemberRepositoryTest {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberRepositoryTest(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Test
    public void insertTest(){
        List<Member> members = new ArrayList<>();

        members.add(new Member("dy.lee", "이동영"));
        members.add(new Member("sb.kim", "김수빈"));
        members.add(new Member("yb.jeon", "전유빈"));

        List<Member> results = memberRepository.saveAll(members);
        assert results.size() == 3;
    }

    @Test
    public void selectTest(){
        List<Member> selected = memberRepository.findAll();
        for(Member m : selected){
            System.out.println(m);
        }
    }

}
