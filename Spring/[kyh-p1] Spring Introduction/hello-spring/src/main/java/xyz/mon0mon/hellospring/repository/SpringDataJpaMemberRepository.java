package xyz.mon0mon.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.mon0mon.hellospring.domain.Member;

import java.util.*;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // JPQL SELECT m FROM MEMBER m WHERE m.name = :name
    @Override
    Optional<Member> findByName(String name);
}
