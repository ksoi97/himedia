package himedia.finalproject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import himedia.finalproject.domain.Member;
import himedia.finalproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberRepository repository;
	
	@GetMapping("/")
	public String main() {
		return "store/index";
	}
	
	@GetMapping("/effects")
	public String effects() {
		return "store/effects";
	}
	
	@GetMapping("/notice")
	public String notice() {
		return "store/notice";
	}
	
	@GetMapping("/freeboard")
	public String freeboard(Model model) {
		List<Member> members = repository.findAll();
		model.addAttribute("members", members);
		return "store/members";
	}	
	
//	@GetMapping("/{memberId}")
//	public String member(@PathVariable Long memberId, Model model) {
//		Member member = repository.find
//	}
	
	@GetMapping("/tip")
	public String tipboard() {
		return "store/latestTip";
	}	
	
	@GetMapping("/login")
	public String login() {
		return "store/login";
	}	
	
	@GetMapping("/join")
	public String join() {
		return "store/join";
	}	

	@GetMapping("/roulette")
	public String roulette() {
		return "store/roulette";
	}	
	
	@GetMapping("/promise")
	public String promise() {
		return "store/promise";
	}	
	
	@GetMapping("/board-write")
	public String boardWrite() {
		return "store/board_write";
	}
	
	@GetMapping("/write")
	public Member write() {
		Member member = new Member();
		repository.save(member);
		return member;
	}
	
}
