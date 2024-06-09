package xyz.mon0mon.hellospring.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import xyz.mon0mon.hellospring.domain.Member;

import java.util.*;

/**
 * @see <a href="https://docs.spring.io/spring-boot/reference/data/sql.html#data.sql.jdbc-client">Spring Docs</a>
 * @see <a href="https://www.baeldung.com/spring-6-jdbcclient-api">Baeldung</a>
 */
public class JdbcClientMemberRepository implements MemberRepository {
    private final JdbcClient jdbcClient;

    public JdbcClientMemberRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Member save(Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql("INSERT into member(name) values(:name)")
                .param("name", member.getName())
                .update(keyHolder);

        member.setId(keyHolder.getKey().longValue());

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return jdbcClient.sql("select * from member where id = ?")
                         .param(id)
                         .query(memberRowMapper())
                         .optional();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return jdbcClient.sql("select * from member where name = ?")
                         .param(name)
                         .query(memberRowMapper())
                         .optional();
    }

    @Override
    public List<Member> findAll() {
        return jdbcClient.sql("select * from member")
                         .query(memberRowMapper())
                         .list();
    }

    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            return member;
        };
    }
}
