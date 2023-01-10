package himedia.finalproject.repository;

import java.util.List;
import java.util.Optional;

import himedia.finalproject.domain.Member;

public interface MemberInterfaceRepository {
	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
	void update(Long memberId, Member updateMember);
}
