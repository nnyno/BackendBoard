package minho.backboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import minho.backboard.domain.Member;
import minho.backboard.repository.DBMemberRepository;
import minho.backboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {
    private final MemberService memberService;
    private final DBMemberRepository dbMemberRepository;

    @Autowired
    public MemberController(MemberService memberService, DBMemberRepository dbMemberRepository) {
        this.memberService = memberService;
        this.dbMemberRepository = dbMemberRepository;
    }

    @GetMapping("/members/new")
    public  String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        member.setUserid(form.getUserid());
        member.setPassword((form.getPassword()));

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @GetMapping("/members/LogIn")
    public  String loginForm() {
        return "members/LogIn";
    }

    @RequestMapping("/members/login")
    public String login(HttpServletRequest request) {
        Member user = memberService.findOne(request.getParameter("userid")).get();
        String userid = user.getUserid();
        String userpw = user.getPassword();
        String requestpw = request.getParameter("password");
        if(requestpw.equals(userpw)) {
            HttpSession session = request.getSession();
            session.setAttribute("userid", request.getParameter("userid"));
            session.setAttribute("password", request.getParameter("password"));
            return "redirect:/";
        } else {
            user.setUserid(null);
            user.setPassword(null);
            return "redirect:/members/LogIn";
        }
    }

    @GetMapping("/members/login")
    @ResponseBody
    public String loginStatus(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // 세션이 없으면 null 반환
        if (session != null && session.getAttribute("userid") != null) {
            return "true"; // 로그인 상태인 경우
        } else {
            return "false"; // 로그아웃 상태인 경우
        }
    }

    @RequestMapping("/members/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/members/LogIn";
    }

    @GetMapping("/members/userid")
    @ResponseBody
    public String loginId(@RequestParam("id") Long id) {
        Optional<Member> result = memberService.findOne(dbMemberRepository.findById(id).get().getUserid());
        String userid = result.get().getUserid();
        return userid;
    }
}
