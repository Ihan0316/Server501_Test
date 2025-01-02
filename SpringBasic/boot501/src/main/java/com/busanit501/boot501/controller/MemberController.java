package com.busanit501.boot501.controller;

import com.busanit501.boot501.dto.MemberJoinDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    // 시큐리티 설정에서 설정한 로그인 페이지로 이동함.
    @GetMapping("/login")
    public void loginGet(String error, String logout,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        log.info("loginGet===================");
        log.info("logoutTest ===================" + logout);

        if (logout != null) {
            log.info("logoutTest user ====================");
        }
        if (error != null) {
            // 403 , error 만 확인한 상태
            log.info("logoutTest error ====================" + error);
//            redirectAttributes.addFlashAttribute(
//                    "error", error);
            model.addAttribute("error", error);
        }

    }

    //회원 가입용 화면
    @GetMapping("/join")
    public void join() {

    }

    @PostMapping("/join")
    public String joinPost(MemberJoinDTO memberJoinDTO) {
        // 서비스 만들어서, 연결 해주기.

        return "redirect:/board/list";
    }
}
