package himedia.finalproject.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import himedia.finalproject.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberRepository {

	private final EntityManager em;
	
	public void save(Member member) {
		em.persist(member);
	}
	
	public Member find(Long id) {
		return em.find(Member.class, id);
	}
	
	
	public List<Member> findAll() {
		return em.createQuery("select s from Member as s", Member.class)
				.getResultList();
	}
	
	public Member update(Member updatedMember) {
		Member member = em.find(Member.class, updatedMember.getId());
		member.setName(updatedMember.getName());
		return member;
	}
	
	public void remove(Long id) {
		em.remove(find(id));
	}
	
}
