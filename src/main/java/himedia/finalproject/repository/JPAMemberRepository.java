package himedia.finalproject.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import himedia.finalproject.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Transactional
@Slf4j
public class JPAMemberRepository implements MemberInterfaceRepository {

	private final EntityManager em;
	
	@Override
	public Member save(Member member) {
		em.persist(member);
		return member;
	}
	
	@Override
	public Optional<Member> findById(Long id) {
		Member member = em.find(Member.class, id);
		return Optional.ofNullable(member);
	}
	
	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = em.createQuery("select i from Member i where i.memberName = :name", Member.class)
				.setParameter("name", name)
				.getResultList();
		return result.stream().findAny();
	}
	
	@Override
	public List<Member> findAll() {
		return em.createQuery("select i from Member i", Member.class)
				.getResultList();
	}
	
	public void update(Long memberId, Member updateMember) {
		String sql = "update Member i"
				+ "set name=:name, title=:title, contents=:contents"
				+ "where id=:id";
		int result = em.createQuery(sql)
				.setParameter("name", updateMember.getName())
				.setParameter("title", updateMember.getTitle())
				.setParameter("contents", updateMember.getContents())
				.executeUpdate();
		em.clear();
	}
}
