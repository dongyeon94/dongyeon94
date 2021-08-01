package com.project.egloo.member.service;

import com.project.egloo.config.security.UserPrincipal;
import com.project.egloo.member.domain.Member;
import com.project.egloo.member.repository.MemberRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Service
public class CustomMemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        Member member = memberRepository.findByUserId(email).orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다. email: " + email));
        return UserPrincipal.create(member);
    }
}
