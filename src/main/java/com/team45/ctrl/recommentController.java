package com.team45.ctrl;


import com.team45.entity.Member;
import com.team45.entity.Recomment;
import com.team45.service.MemberService;
import com.team45.service.RecommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/recomment/*")
public class RecommentController {

    @Autowired
    private RecommentService recommentService;

    @Autowired
    private MemberService memberService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/List")
    public String recommentList(String id, Model model) {
        Member mem = memberService.memberGet(id);

        List<Recomment> recommentList = recommentService.recommentList(id);
        logger.info("ㅇㄴㄻㅇㄴㄻㅇㄴㄹㅇㅁㄴ"+ id);
        logger.info("ㅇㄴㄻㅇㄴㄻㅇㄴㄹㅇㅁㄴ"+recommentList );
        model.addAttribute("recommentList", recommentList);
        return "/recomment/recommentList";
    }

    @GetMapping("/Add")
    public String recommentform(String id, Model model){
        Member mem = memberService.memberGet(id);
        model.addAttribute("mem", mem);
        return "/recomment/recommentForm";
    };

    @PostMapping("/Add")
    public String recommentAdd(Recomment recomment){
        recommentService.recommentAdd(recomment);
        return "redirect:/recomment/List?id=recomment.getMem_id())";
    };

    @GetMapping("/Del")
    public String recommentDel(int no){
        recommentService.recommentDel(no);
        return "redirect:/recomment/List";
    };

}
